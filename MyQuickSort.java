// Matthew Scott, Quicksort method, modeled from class lecture slides & class notes.
public class MyQuickSort {

    public static int comparison = 0; // global variable for comparisons

    public static void main(String[] args) {

        int[] arr = new int[args.length];   // new integer array to hold the command line arguments

        for (int i = 0; i < args.length; i++) { // loop to convert command line string to integer array
            try {
                arr[i] = Integer.parseInt(args[i]);
            } catch(Exception e) {
                // trying to remove any bad inputs
            }
        }

        QuickSort(arr, 0, arr.length - 1); // quicksort method call


        for (int i = 0; i < args.length; i++) { // loop to print out the quicksorted array
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n" + comparison); // print number of comparisons

    }

    static int Partition(int[] arr, int p, int r) { // where p is the first index of array, r is the last index

        int x = arr[r]; // x is the pivot at index r, the last index of the array
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (arr[j] <= x) {
                i++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }

        int swap = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = swap;

        return i + 1;
    }

    static void QuickSort(int[] arr, int p, int r) {

        if (p < r) {
            int q = Partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
        comparison++;
    }

}