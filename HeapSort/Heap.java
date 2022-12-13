import java.util.Random;

public class Heap {

    public static void main(String[] args) {

        final int N = 20;

        final int[] ARRAY = new int[N];

        fillArray(ARRAY);
        printArray(ARRAY);

        buildMaxHeap(ARRAY);
        printArray(ARRAY);

        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        System.out.println("Extracting elements from heap:" + extractMax(ARRAY, N));

        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        ARRAY[ARRAY.length - 1] = 1;
        printArray(ARRAY);
        ARRAY[0] = 1;
        printArray(ARRAY);
        heapify(ARRAY, 0, ARRAY.length);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        increaseKey(ARRAY, 0, 45);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        increaseKey(ARRAY, ARRAY.length - 1, 20);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));


        decreaseKey(ARRAY, 0, 5);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        insert(ARRAY, 0, ARRAY.length);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        insert(ARRAY, 18, ARRAY.length);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));


        fillArray(ARRAY);
        printArray(ARRAY);
        System.out.println("Is sorted : " + isSorted(ARRAY));
        heapSort(ARRAY);
        printArray(ARRAY);
        System.out.println("Is sorted : " + isSorted(ARRAY));


        buildMaxHeap(ARRAY);
        printArray(ARRAY);
        System.out.println("Is  Heap: " + isMaxHeap(ARRAY));

        System.out.println("Max :" + max(ARRAY));
        System.out.println("Min :" + min(ARRAY));
        System.out.println("Is Empty :" + isEmpty(ARRAY));
        System.out.println("Search :" + search(ARRAY, 5));


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

    // is sorted method
    private static boolean isSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;

    }

    private static boolean isMaxHeap(int[] array) {

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

    public static int max(int[] array) {
        return array[0];
    }

    public static int min(int[] array) {
        return array[array.length - 1];
    }

    public static boolean isEmpty(int[] array) {
        return array.length == 0;
    }

    public static boolean search(int[] array, int key) {

        for (int j : array)
            if (j == key)
                return true;

        return false;

    }

    public static void buildMaxHeap(int[] array) {

        for (int i = (array.length / 2) - 1; i >= 0; i--)
            heapify(array, i, array.length);

    }

    public static int extractMax(int[] array, int heapSize) {

        if (heapSize < 1)
            return -1;

        int max = array[0];

        swap(array, 0, heapSize - 1);

        heapSize--;

        heapify(array, 0, heapSize);

        return max;

    }

    public static void increaseKey(int[] array, int index, int key) {

        if (key < array[index])
            throw new IllegalArgumentException("New key is smaller than current key");

        array[index] = key;

        while (index > 0 && array[index] > array[(index - 1) / 2]) {

            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;

        }


    }

    public static void decreaseKey(int[] array, int index, int key) {

        if (key > array[index])
            throw new IllegalArgumentException("The new key is greater than the current key");

        array[index] = key;

        heapify(array, index, array.length);

    }

    public static void heapSort(int[] array) {

        buildMaxHeap(array);

        for (int i = array.length - 1; i > 0; i--) {

            swap(array, 0, i);

            heapify(array, 0, i);

        }


    }

    public static void insert(int[] array, int key, int heapSize) {

        heapSize++;

        int[] newArray = new int[heapSize];

        System.arraycopy(array, 0, newArray, 0, array.length);

        newArray[array.length] = key;

        array = newArray;

        int i = array.length - 1;

        while (i > 0) {

            int parent = (i - 1) / 2;

            if (array[parent] < array[i]) {
                swap(array, parent, i);
                i = parent;
            } else
                break;

        }

        array = newArray;

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

}
