import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuckSort {

    // Partition method with a randomly selected pivot
    int partition(int[] arr, int low, int high) {
        Random rand = new Random(); // randomly selected pivot
        int pivotIndex = low + rand.nextInt(high - low + 1); // random pivot index
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // swap pivot with the last element

        int i = low - 1; // index of the smaller element
        for (int j = low; j < high; j++) { // iterate over the array
            if (arr[j] <= pivot) { // if current element is smaller than or equal to pivot
                i++; // move the smaller element's index
                swap(arr, i, j); // swap elements at i and j
            }
        }

        // place pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1; // Return pivot index
    }

    // swap 2 elements in the array
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // quickSort function
    void sort(int[] arr, int low, int high) {
        while (low < high) {
            // partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recurse on the smaller partition and iterate on the larger one
            if (pi - low < high - pi) {
                sort(arr, low, pi - 1); // sort left partition
                low = pi + 1;  // iterate over the larger partition
            } else {
                sort(arr, pi + 1, high); // sort right partition
                high = pi - 1;  // iterate over the smaller partition
            }
        }
    }

    public static void main(String[] args) {
        // input the length of the array
        System.out.print("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // initialize the array
        int[] array = new int[n];
        // loop to add values into the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        QuckSort qs = new QuckSort();
        // calling the sort function
        qs.sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
