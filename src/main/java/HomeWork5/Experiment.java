package HomeWork5;

import java.util.Arrays;

public class Experiment {

    private static final int size = 10000000;
    private static final Object mon1 = new Object();
    private static final Object mon2 = new Object();
    private static final float[] arr = new float[size];
    private static final float[] arr1 = new float[size];
    private static final float[] a1 = new float[size / 2];
    private static final float[] a2 = new float[size - size / 2];

    public static void main(String[] args) {
        firstArray();
        try {
            secondArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.equals(arr, arr1));

    }


    private synchronized static void secondArray() throws InterruptedException {
        Arrays.fill(arr1, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr1, 0, a1, 0, size / 2);
        System.arraycopy(arr1, size  / 2, a2, 0, size - size / 2);
        Thread thread1 = new Thread(() -> {
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            System.out.println(Arrays.toString(a1));
        }
            System.arraycopy(a1, 0, arr1, 0, size / 2);
//            System.out.println(Arrays.toString(arr1) + " - arr1");
//            System.out.println(Arrays.toString(a1) + " - 1");
        });

        Thread thread2 = new Thread(() -> {
        for (int i = 0, j = size/2; i < a2.length; i++, j++) {
            a2[i] = (float) (a2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
            System.arraycopy(a2, 0, arr1, size / 2, size - size / 2);
//            System.out.println(Arrays.toString(arr1) + " - arr1");
//            System.out.println(Arrays.toString(a2) + " - 2");
        });

        thread1.start();
        thread2.start();
        System.currentTimeMillis();
        thread1.join();
        thread2.join();
        System.out.println(System.currentTimeMillis() - a + " - second");

    }


    private synchronized static void firstArray() {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a + " - first");

    }
}

