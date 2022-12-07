import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        final int N = 1000;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        printArray(ARRAY);

        mergeSort(ARRAY, 0, ARRAY.length - 1);

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


    private static void merge(int[] array, int low, int mid, int high) {

        // Find sizes of two sub arrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(array, low, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


    public static void mergeSort(int[] array, int low, int high) {

        System.out.println("Begin " + low + " " + high);

        if (low < high) {
            // Find the middle point
            int mid = low + (high - low) / 2;

            // Sort first and second halves
            System.out.println("MergeSort1 " + low + " " + mid);
            mergeSort(array, low, mid);
            System.out.println("MergeSort2 " + (mid + 1) + " " + high);
            mergeSort(array, mid + 1, high);

            // Merge the sorted halves
            System.out.println("Merge " + low + " " + mid + " " + high);
            merge(array, low, mid, high);
        }

        System.out.println("Final " + low + " " + high);

    }

}
