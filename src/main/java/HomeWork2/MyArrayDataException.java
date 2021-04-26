package HomeWork2;

    class MyArrayDataException extends Exception {

        private final int i;
        private final int j;

        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;

        }

        public void text() {
            System.out.println("On coordinates y = " + this.i + " and x = " + this.j + " symbol or text," +
                    " need to change on number!");
        }
    }

