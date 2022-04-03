//3
public class prime {
    private prime() {}

    public static double calculateAverage (int[] a){
        return calculateAverage(a, 0 , 0);
    }
    private static double calculateAverage(int [] a, int i, int sum) {
        if (i>= a.length) return (double)sum / a.length;

        sum+=a[i];

        return calculateAverage(a, i+1, sum) ;
    }
    public static boolean isPrime (int n){
        return isPrime(n, 2 );
    }

    private static boolean isPrime (int n, int i){
        if (i> Math.sqrt(n)) return true;

        if (n % 1 ==0) return false;

        return isPrime(n, i+1 );
    }
}