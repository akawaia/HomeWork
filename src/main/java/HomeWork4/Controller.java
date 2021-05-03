package HomeWork4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    public TextArea chatArea;
    public ListView onlineUsers;
    public TextField inputField;
    public Button btnSendMessage;
    public Hyperlink gbMyHyperLink;

    public void mockAction(ActionEvent actionEvent) {

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void sendMessage(ActionEvent actionEvent) {
        String msg = inputField.getText();
        if (msg.isEmpty()) return;
        chatArea.appendText("ME: " + msg + System.lineSeparator());
        inputField.clear();
    }

    public void showAbout(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/showAbout.fxml" ));
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
    private void desktopDesktopUri (String URI) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(URI));
    }
}
