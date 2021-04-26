package HomeWork2;

public class Exceptions {

    static final String[][] ARR = {{"-1", "2", "3"}, {"1", "g", "3"}, {"1", "2", "3"}};

    public static void main(String[] args) {
        try {
            arrayForHomeWork(ARR);
        } catch (MyArraySizeException e) {
            System.out.println("Please, try again with array size for x = 3 and y = 3");
        } catch (MyArrayDataException e) {
            e.text();
        }

    }


    public static void arrayForHomeWork(String[][] array) throws MyArraySizeException, MyArrayDataException {
        String[][] arr = new String[3][3];
        if (arr.length == array.length && arr[0].length == array[0].length) {
            int[][] numArr = new int[array.length][array.length];
            int sum = 0;
            String regex = "[a-zA-z]+";
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (!array[i][j].matches(regex)) {
                        numArr[i][j] = Integer.parseInt(array[i][j]);
                        sum += numArr[i][j];
                    }
                    if (array[i][j].matches(regex)) {
                        numArr[i][j] = 0;
                        sum += numArr[i][j];
                    }
                }
            }
            System.out.println("Sum of all numbers in array: " + sum);
            checkMyArrayDataException(array, regex);
        } else throw new MyArraySizeException();
    }

    static void checkMyArrayDataException(String[][] array, String regex) throws MyArrayDataException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (ARR[i][j].matches(regex)) throw new MyArrayDataException(i, j);
            }
        }
    }
}

