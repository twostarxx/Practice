package practice;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 5, 2, 7, 3, 1};
		Sort sort = new Sort();
		int[] sortA = sort.bubbleSort(A);
		System.out.println(Arrays.toString(sortA));

	}

}
