import java.util.ArrayList;
import java.util.List;

/*
 * Exercise 1-1
 */
public class Solution {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 4 };
		int[] array2 = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 3, 9 };
		int[] array3 = { 1, 1, 1, 1 };
		showNonDuplicateArray(array1);
		showNonDuplicateArray(array2);
		showNonDuplicateArray(array3);
	}

	/*
	 * Remove duplicate elements in an array and print it in the standard output
	 * 
	 * @param a the input array
	 */
	public static void showNonDuplicateArray(int[] arr) {
		// TODO
		List list = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
		Object[] newArr = list.toArray();
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(" " + newArr[i]);
		}
		System.out.println();
	}
}