
package Arrays;

import java.util.*;

public class ProcessArrayCopy {

	public static int[] insert(int arr[], int number) {

		int[] array2 = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			array2[i] = arr[i];
		}
		array2[arr.length] = number;

		return array2;

	}

	public static int[] delete(int arr[], int number) {

		int a = 0;
		int[] arraycopy = new int[0];
		for (int i = 0; i < arr.length; i++) {
			if (number == arr[i]) {
				continue;
			}else {
				arraycopy = insert(arraycopy, arr[i]);
			}
		}
		return arraycopy;
	}

	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		Scanner in = new Scanner(System.in);

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = (rand.nextInt(50) + 1);
		}

		System.out.print("The array is: ");
		display(array);

		System.out.print("Please enter a number to be added into the array: ");
		int x = in.nextInt();

		int[] array2 = insert(array, x);
		System.out.println("The updated array is:");
		display(array2);

		System.out.print("Please enter a number to be deleted from the array: ");
		x = in.nextInt();

		int[] array3 = delete(array2, x);
		System.out.println("The updated array is: ");
		display(array3);
		
		

	}

}
