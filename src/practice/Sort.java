package practice;

import java.util.Arrays;

/**
 * @version 2017.10.1
 * @author XINGXIN
 * */
public class Sort {
	
	/**
	 * <p>选择排序O(n^2).<br>
	 * @param nums: int[].
	 * @return nums. 
	 */
	public int[] selectSort(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			int minindex = i;
			for (int j=i; j<nums.length; j++) {
				if (nums[j] < nums[minindex]) {
					minindex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minindex];
			nums[minindex] = temp;
		}
		return nums;
	}
	
	/**
	 * <p>冒泡排序O(n^2).<br>
	 * @param nums: int[].
	 * @return nums. 
	 */
	public int[] bubbleSort(int[] nums) {
		for (int i=0; i<nums.length-1; i++) {
			for (int j=0; j<nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		return nums;
	}
	
	/**
	 * <p>插入排序O(n^2).<br>
	 * @param nums: int[].
	 * @return nums. 
	 */
	public int[] insertionSort(int[] nums) {
		for (int i=1; i<nums.length; i++) {
			for (int j=i; j>0; j--) {
				if (nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
		return nums;
	}
	
	/**
	 * <p>快速排序O(nlogn).</br>
	 * 递归.
	 * @param nums[]: 数组
	 * @param start: 0
	 * @param end: nums.length - 1
	 * @return int[] nums.
	 */
	public int[] quickSort(int[] nums, int start, int end) {
		int key = nums[start];	//第一个作为key
		int i=start, j=end;
		/*key值固定，排一次*/
		while (i != j) {
			if (nums[j]>=key && i<j)
				j--;
			nums[i] = nums[j];	//!!不用key进行替换，一次while之后就自动交换比key大和小的值，key的值在最后才替换
			if (nums[i]<key && i<j)
				i++;
			nums[j] = nums[i];
		}
		nums[i] = key;	//i==j，需要将key替换到i或j的位置
		/*排左边*/
		if (i-1 > start)
			quickSort(nums, start, i-1);
		/*排右边*/
		if (j+1 < end)
			quickSort(nums, j+1, end);
		return nums;
	}
	
	/**
	 * <p>归并排序O(nlogn).<br>
	 * @param nums: int[]
	 * @param low: 0.
	 * @param high: nums.length-1.
	 * @return nums.
	 */
	public int[] mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(nums, low, mid);	//左边排序
			mergeSort(nums, mid+1, high);	//右边排序
			merge(nums, low, mid, high);	//两边连接
		}
		return nums;
	}
	/*重点：两个数组如何合并？详细见思想*/
	public int[] merge(int[] ns, int low, int mid, int high) {
		int[] temp = new int[high-low+1];	
		int i=low, j=mid+1, k=0;
		while (i<=mid && j<=high) {	
			if (ns[i] <= ns[j]) {	//比较剩下的两个数组的第一个，小的放入temp
				temp[k++] = ns[i++];
			} else {
				temp[k++] = ns[j++];
			}
		}
		//ns前半段还有剩余
		while (i <= mid) {
			temp[k++] = ns[i++];
		}
		//ns后半段还有剩余
		while (j <= high) {
			temp[k++] = ns[j++];
		}
		for (int k2=0; k2<temp.length; k2++) {
			ns[k2+low] = temp[k2];
		}
		return ns;
	}
	
	/**
	 * <p>桶排序.<br>
	 * 无序数组有个要求,就是成员隶属于固定(有限的)的区间.
	 * 如范围为[0-9](考试分数为1-100等)
	 * @param nums: int[].
	 * @param maxN: max space shall be used.
	 * @return nums.
	 */
	public int[] bucketSort(int[] nums, int maxN) {
		int[] temp = new int[maxN];
		for (int i : nums) {
			temp[i] ++;
		}
		System.out.println(Arrays.toString(temp));
		int k = 0;
		for (int j=0; j<temp.length; j++) {
			while (temp[j] > 0) {
				nums[k++] = j;
				temp[j]--;
			}
		}
		return nums;
	}

}
