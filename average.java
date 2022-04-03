//2
public class average {
    private average(){}

    public static int findMin (int [] a){
        return findMin(a, 1 , a[0]);
    }

    private static int findMin (int[] a, int i, int min ) {
        if (i>= a.length) return min;

        if (min> a[i]) min=a[i];

        return findMin(a, i+1  , min);
    }
    public static double calculateAverage (int[] a) {
        return calculateAverage(a, 0,  0);
    }

    private static double calculateAverage (int[] a, int i,int sum) {
        if (i>= a.length) return (double)sum / a.length;

        sum += a[i];

        return calculateAverage(a, i+1, sum);
    }

}