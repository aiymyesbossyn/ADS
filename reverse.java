//7
public class reverse {

    /* Function to reverse arr[] from
     start to end*/
    static void reverseArray(int arr[],
                             int start, int end)
    {
        int temp;

        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int arr[],
                           int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {

        int arr[] = {1, 4, 6, 2 };
        printArray(arr, 4);
        reverseArray(arr, 0, 3);
        System.out.print("\n");
        printArray(arr, 4);

    }
}