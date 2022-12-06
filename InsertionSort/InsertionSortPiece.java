import java.util.Random;

public class InsertionSortPiece {

    public static void main(String[] args) {

        final int N = 10;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        printArray(ARRAY);
        System.out.println();

        for (int i = 0; i < ARRAY.length; i++) {
            insertionSortPiece(ARRAY, i + 1);
            printArray(ARRAY);
        }


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


    public static void insertionSortPiece(int[] array, int sortedIndex) {

        int index = sortedIndex - 1;

        while ((index != 0) && (array[index] < array[index - 1])) {

            int temp = array[index];
            array[index] = array[index - 1];
            array[index - 1] = temp;

            index--;

        }

    }

}
