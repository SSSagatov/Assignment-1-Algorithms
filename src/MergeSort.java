import java.util.Scanner;

public class MergeSort {

    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L =  new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left+i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] =  arr[mid+1+j];
        }

        int i = 0, j = 0;

        int k = left;

    }

    void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(array, left, mid);
            sort(array,mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,4,7,8,9,4,5,3,2};

        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);
    }
}