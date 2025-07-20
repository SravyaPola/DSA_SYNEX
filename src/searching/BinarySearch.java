package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 20, 32, 56, 71, 89, 97 };
		int key = 56;
		System.out.println(binarySearch(arr, key));
	}

	public static int binarySearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
