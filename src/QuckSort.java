import com.sun.security.jgss.InquireSecContextPermission;

import java.util.Arrays;
import java.util.Scanner;

public class QuckSort {

    void sort(int[] arr) {

    }

    public static void main(String[] args) {
        //Method scanner for input the length of array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //initialize array
        int[] array = new int[n];
        //loop to add values into array
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        QuckSort qs = new QuckSort();

        qs.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
