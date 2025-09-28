import java.util.Arrays;
import java.util.Scanner;

public class MedianOfMedians {

    // Helper function to perform partition with the pivot
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to find the median of the medians
    public static int medianOfMedians(int[] arr, int low, int high) {
        int n = high - low + 1;
        if (n <= 5) {
            Arrays.sort(arr, low, high + 1); // Sort the small group directly
            return arr[low + (high - low) / 2];  // Return the median of the group
        }

        // Step 1: Divide array into groups of 5
        int[] medians = new int[(n + 4) / 5]; // Array to store medians of each group
        int i = 0;
        for (int j = low; j <= high; j += 5) {
            int end = Math.min(j + 4, high); // Ensure the last group has fewer than 5 elements if needed
            Arrays.sort(arr, j, end + 1);
            medians[i++] = arr[j + (end - j) / 2];  // Store the median of the current group
        }

        // Step 2: Recursively find the median of the medians array
        return medianOfMedians(medians, 0, medians.length - 1);
    }

    // Function to select the k-th smallest element
    public static int deterministicSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        // Step 1: Find the pivot using median-of-medians
        int pivot = medianOfMedians(arr, low, high);

        // Step 2: Partition the array around the pivot
        int pivotIndex = partition(arr, low, high);

        // Step 3: Recurse into the correct half
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return deterministicSelect(arr, low, pivotIndex - 1, k);
        } else {
            return deterministicSelect(arr, pivotIndex + 1, high, k);
        }
    }

    public static void main(String[] args) {
        // Create a scanner to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Scan the length of the array
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        // Initialize the array with the given length
        int[] arr = new int[length];

        // Scan the values of the array
        System.out.println("Enter the values of the array: ");
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        // Scan the k-th smallest element (1-based index)
        System.out.print("Enter the k-th smallest element to find (1-based index): ");
        int k = scanner.nextInt();  // k is 1-based index, so subtract 1 for 0-based index

        // Call the deterministic select function
        System.out.println("The " + k + "-th smallest element is: " +
                deterministicSelect(arr, 0, arr.length - 1, k - 1));

        // Close the scanner after all inputs
        scanner.close();
    }
}
