import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    // merge 2 subarrays of array
    void merge(int[] arr, int left, int mid, int right) {
        // calculate the left and right sides
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // send it to 2 arrays(left and right)
        int[] L =  new int[n1];
        int[] R = new int[n2];

        //copy elements from array to L(left) and R(right)
        for (int i = 0; i < n1; i++)
            L[i] = arr[left+i];

        for (int j = 0; j < n2; j++)
            R[j] =  arr[mid+1+j];

        // Merge the temp arrays
        // Initial indexes of both subarrays
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    //part of merge sort
    void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //sort both side by calling the same function(recursion)
            sort(array, left, mid);
            sort(array,mid + 1, right);

            //merge the final result
            merge(array, left, mid, right);
        }
    }

    //insertion sort used for array which length is less than 20 elements in it
    void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        //testing array
        //int[] arr = {4,3,6,4,7,8,9,4,5,3,2};
        //Input the length of array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //new array to store values
        int[] arr = new int[n];
        //loop to send values into array
        for  (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSort ms = new MergeSort();
        // Calling the merge function or insert sort
        // Also send the args to sort function
        if(arr.length >= 20 ) {
            //merge sort
            ms.sort(arr, 0, arr.length - 1);
        } else {
            //insert sort
            ms.insertSort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }
}