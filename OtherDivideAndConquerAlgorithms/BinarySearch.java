public class BinarySearch {


    public static void main(String[] args) {

        final int ARRAY [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        final int KEY1 = 3;
        final int KEY2 = 11;

        System.out.println("Is contains " + KEY1 + " : " + binarySearch(ARRAY, 0, ARRAY.length - 1, KEY1 ));
        System.out.println("Is contains " + KEY2 + " : " + binarySearch(ARRAY, 0, ARRAY.length - 1, KEY2 ));

    }

    public static boolean binarySearch(int[] array, int low, int high, int key) {

        int mid = (low + high) / 2;

        if  (low > high)
            return false;
        else if (array[mid] == key)
            return true;
        else if (array[mid] > key)
            return binarySearch(array, low, mid - 1, key);
        else if (array[mid] < key)
            return binarySearch(array, mid + 1, high, key);
        else
            return false;

    }


}
