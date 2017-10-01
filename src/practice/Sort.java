package practice;

/**
 * @version 2017.10.1
 * @author XINGXIN
 * */
public class Sort {
	
	/**
	 * <p>快速排序</br>
	 * 递归.
	 * @param nums[]: 数组
	 * @param start: 0
	 * @param end: nums.length - 1
	 * @return int[] nums.
	 * */
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

}
