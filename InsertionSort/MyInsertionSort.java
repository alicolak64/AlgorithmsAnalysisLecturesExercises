import java.util.Random;

public class MyInsertionSort {


    public static void main(String[] args) {

        final int N = 20;

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

        for (int i = 1; i < array.length; i++) {

            int index = i;

            while (i > 0 && array[i] < array[i - 1]) {

                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;

                i = i - 1;

            }

            i = index;

        }

    }


}



