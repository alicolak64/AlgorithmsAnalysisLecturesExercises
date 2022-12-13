import java.util.Arrays;
import java.util.Random;

public class SelectionLinearTime {


    // T(n) = T (n/2) + n ;
    // T(n) = T (n/2 - 1) + (n/2 - 1) + n ;

    // T(n) = O(n) ;

    public static void main(String[] args) {

        Random random = new Random();

        final int N = 20;

        final int[] ARRAY = new int[N];

        final int INDEX = random.nextInt(N);

        fillArray(ARRAY);

        System.out.println("The " + INDEX + "th smallest element in the array" + " : " + select(ARRAY, INDEX));

        Arrays.sort(ARRAY);

        System.out.println("Actual element : " + ARRAY[INDEX]);



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

    public static int select(int[] array, int index) {  //  i th the smallest element of a set of n elements

        if (array.length < index)
            return -1;
        else
            getIndex(array, 0, array.length - 1, index);

        return array[index];

    }

    private static void getIndex(int[] array, int low, int high, int index) {

        if (low < high) {

            int pivot = randomPartition(array, low, high);

            if (pivot > index)
                getIndex(array, low, pivot - 1, index);
            else
                getIndex(array, pivot + 1, high, index);

        }

    }

    private static int randomPartition(int[] array, int low, int high) {

        Random random = new Random();

        int randomIndex = random.nextInt(high - low) + low;

        swap(array, low, randomIndex);

        return partition(array, low, high);

    }


    private static int partition(int[] array, int low, int high) {

        int pivot = array[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (array[j] >= pivot && i < j)
                j--;

            if (i < j)
                swap(array, i, j);

            while (array[i] <= pivot && i < j)
                i++;

            if (i < j)
                swap(array, i, j);

        }

        return j;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}