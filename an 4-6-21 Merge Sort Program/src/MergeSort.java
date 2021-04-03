import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSort {
	static Scanner sc;

	public static void main(String[] args) throws InputMismatchException {
		int[] array;
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("How many integers do you want to input? (1-10)");
				int count = sc.nextInt();
				if(count < 1 || count > 10) {
					System.out.println("Make sure input isn't less than 1 or greater than 10");
					continue;
				}
				array = new int[count];
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		for(int i = 0; i < array.length; i++) {
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.print(i + 1 + ": ");
					int input = sc.nextInt();
					array[i] = input;
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is an integer");
				}
			}
		}
		sort(array, 0, array.length - 1);
		int target;
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Input integer for search");
				target = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		binarySearch(array, 0, array.length, target);
	}

	public static void sort(int[] arr, int left, int r) {
		if (left < r) {
			int m = (left+r)/2;
			sort(arr, left, m);
			sort(arr , m+1, r);
			merge(arr, left, m, r);
		}
	}

	public static void merge(int[] arr, int left, int m, int r) {
		int n1 = m - left + 1;
		int n2 = r - m;
		int L[] = new int [n1];
		int R[] = new int [n2];
		for(int i=0; i<n1; ++i) L[i] = arr[left + i];
		for(int j=0; j<n2; ++j) R[j] = arr[m + 1+ j];
		int i = 0, j = 0;
		int k = left;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void binarySearch(int[] a, int min, int max, int target) {
		if(min >= max) {
			System.out.println("Not found");
			return;
		}
		int mid = (min + max) / 2;
		if(a[mid] == target) {
			System.out.println("Found");
			return;
		}
		if(a[mid] < target) {
			binarySearch(a, mid + 1, max, target);
			return;
		}
		binarySearch(a, min, mid, target);
		return;
	}
}
