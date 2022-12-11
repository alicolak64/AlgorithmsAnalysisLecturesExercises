public class PowerANumber {

    public static void main(String[] args) {

        final int A = 2;
        final int N = 7;

        System.out.println(power(A, N));
        System.out.println(powerWithRecursive(A, N));

    }

    public static int power(int a, int n) {

        int powerNumber = a;

        for (int i = 1; i < n; i++) {
            powerNumber *= a;
        }

        return powerNumber;

    }

    public static int powerWithRecursive(int a, int n) {

        if (n == 1)
            return a;
        else if (n % 2 == 0) {
            return powerWithRecursive(a, n / 2) * powerWithRecursive(a, n / 2);
        } else
            return powerWithRecursive(a, n / 2) * powerWithRecursive(a, n / 2) * a;

    }

}
