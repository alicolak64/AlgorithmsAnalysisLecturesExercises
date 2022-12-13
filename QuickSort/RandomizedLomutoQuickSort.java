import java.util.Random;

public class RandomizedLomutoQuickSort {

    public static void main(String[] args) {

        final int N = 20;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        printArray(ARRAY);

        quickSort(ARRAY, 0, ARRAY.length - 1);

        printArray(ARRAY);


    }


    // Fills the array with random numbers that can be equal to the maximum array length
    public static void fillArray(int[] array) {

        Random random = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(array.length) + 1;

    }

    // print array method
    public static void printArray(int[] array) {

        for (int element : array)
            System.out.print(element + " ");

        System.out.println();

    }

    public static void quickSort(int[] array, int low, int high) {

        if (low < high) {

            int pivot = randomPartition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);

        }

    }

    private static int randomPartition(int[] array, int low, int high) {

        Random random = new Random();

        int randomIndex = random.nextInt(high - low) + low;

        swap(array, randomIndex, high);

        return partition(array, low, high);

    }

    private static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;
        int j;

        for (j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }

        }

        swap(array, (i + 1), j);

        return i + 1;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
