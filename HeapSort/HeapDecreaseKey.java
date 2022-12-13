import java.util.Random;

public class HeapDecreaseKey {


    public static void main(String[] args) {

        final int N = 20;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);

        printArray(ARRAY);

        buildHeap(ARRAY);

        printArray(ARRAY);

        decreaseKey(ARRAY, 1, 3);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        decreaseKey(ARRAY, 3, 12);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        decreaseKey(ARRAY, 1, 1);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));


        decreaseKey(ARRAY, 7, 6);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        decreaseKey(ARRAY, 5, 7);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        decreaseKey(ARRAY, 8, 4);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));

        decreaseKey(ARRAY, 6, 6);
        printArray(ARRAY);
        System.out.println("Is the array a heap? " + isHeap(ARRAY));


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

    private static void heapify(int[] array, int index, int heapSize) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < heapSize && array[left] > array[largest])
            largest = left;

        if (right < heapSize && array[right] > array[largest])
            largest = right;

        if (largest != index) {

            swap(array, index, largest);

            heapify(array, largest, heapSize);

        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void decreaseKey(int[] array, int index, int key) {

        if (key > array[index])
            throw new IllegalArgumentException("The new key is greater than the current key");

        array[index] = key;

        heapify(array, index, array.length);


    }

}
