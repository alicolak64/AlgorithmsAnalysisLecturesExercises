import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

        final int N = 10;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        printArray(ARRAY);
        System.out.println();


        insertionSort(ARRAY);
        printArray(ARRAY);

    }

    // fillArray method randomly  from parameter and return array
    private static void fillArray(int[] array) {

        Random random = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(array.length) + 1;

    }

    // printArray method print array to console
    private static void printArray(int[] array) {

        for (int element : array)
            System.out.print(element + " ");

        System.out.println();

    }

    public static void insertionSort(int[] array) {

        int key;
        int i;

        for (int j = 1; j < array.length; j++) {

            key = array[j];
            i = j - 1;

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;

        }

    }

}
