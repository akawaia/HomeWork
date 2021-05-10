package HomeWork6_WorkWithNet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    public static String getInputField;
    public static TextArea chatArea;
    public ListView onlineUsers;
    private static TextField inputField;
    public Button btnSendMessage;
    public Hyperlink gbMyHyperLink;
    private static DataOutputStream out;
    private static DataInputStream in;
    private final static int SERVER_PORT = 10001;
    private static final String SERVER_ADDRESS = "localhost";
    private static Socket socket;


    public static void startServer() {
        try {
            while (true) {
                socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                getMessageFromPC_Friends(socket);
                sendMessageFromPC_Your();
//                new Friends();
            }
        } catch (IOException e) {
            System.out.println("Problem with send message");
        } finally {
            closeOperations(socket);
            Thread.interrupted();
        }
    }

    public static void getMessageFromPC_Friends(Socket socket) {
        new Thread(() -> {
            while (Thread.currentThread().isInterrupted() || socket.isConnected()) {
                try {
                    String str = in.readUTF();
                    chatArea.appendText("Friend" + str + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("getMessageFromPC_Friends have error");
                }
            }
        }).start();
    }


    public static void sendMessageFromPC_Your() {
        String msg = inputField.getText();
        if (!msg.isEmpty()) {
            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                System.out.println("sendMessageFromPC_Your have error");
            }
            chatArea.appendText("ME: " + msg + System.lineSeparator());
            inputField.clear();
        }
    }

    private static void closeOperations(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showAbout(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/showAbout.fxml"));
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.setTitle("About");
        newWindow.setScene(new Scene(root));
        newWindow.show();
    }

    public void showHelp(ActionEvent actionEvent) throws URISyntaxException, IOException {
        desktopDesktopUri("https://thumbs.dreamstime.com/z/how-can-help-you-question-concept-made" +
                "-transparent-wipe-board-hand-holding-marker-51790220.jpg");
    }

    public void developerInfo(ActionEvent actionEvent) throws URISyntaxException, IOException {
        desktopDesktopUri("https://gb.ru/users/3872849");
    }

    public void developerTeacherInfo(ActionEvent actionEvent) throws URISyntaxException, IOException {
        desktopDesktopUri("https://gb.ru/users/2948451");
    }

    private void desktopDesktopUri(String URI) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(URI));
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mockAction(ActionEvent actionEvent) {
    }

}
