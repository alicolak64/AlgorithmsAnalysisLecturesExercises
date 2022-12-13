import java.util.Random;

public class ExtractMaxWithIterative {

    public static void main(String[] args) {


        final int N = 10;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        buildHeap(ARRAY);

        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        for (int i = ARRAY.length; i >= 0; i--) 
            System.out.println("The maximum element in the array is : " + extractMax(ARRAY, i));

        printArray(ARRAY);


    }


    // Fills the array with random numbers that can be equal to the maximum array length
    private static void fillArray(int[] array) {

        Random random = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(array.length) + 1;

    }

    // print array method
    private static void printArray(int[] array) {

        for (int element : array)
            System.out.print(element + " ");

        System.out.println();

    }

    private static boolean isHeap(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < array.length && array[left] > array[i])
                return false;

            if (right < array.length && array[right] > array[i])
                return false;

        }

        return true;

    }

    private static void buildHeap(int[] array) {

        for (int i = (array.length / 2) - 1; i >= 0; i--)
            heapify(array, i, array.length);

    }

    public static int extractMax(int[] array, int heapSize) {

        if (heapSize < 1)
            return -1;

        int max = array[0];

        swap(array, 0, heapSize - 1);

        heapify(array, 0, --heapSize);

        return max;


    }

    private static void heapify(int[] array, int index, int heapSize) {


        while (index <= heapSize) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int largest = index;

            if (left < heapSize && array[left] > array[largest])
                largest = left;

            if (right < heapSize && array[right] > array[largest])
                largest = right;

            if (largest != index) {
                swap(array, index, largest);
                index = largest;
            } else
                break;

        }


    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
