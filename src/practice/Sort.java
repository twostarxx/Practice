package practice;

/**
 * @version 2017.10.1
 * @author XINGXIN
 * */
public class Sort {
	
	/**
	 * <p>ѡ������O(n^2).<br>
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
	 * <p>ð������O(n^2).<br>
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
	 * <p>��������O(n^2).<br>
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
	 * <p>��������O(nlogn).</br>
	 * �ݹ�.
	 * @param nums[]: ����
	 * @param start: 0
	 * @param end: nums.length - 1
	 * @return int[] nums.
	 */
	public int[] quickSort(int[] nums, int start, int end) {
		int key = nums[start];	//��һ����Ϊkey
		int i=start, j=end;
		/*keyֵ�̶�����һ��*/
		while (i != j) {
			if (nums[j]>=key && i<j)
				j--;
			nums[i] = nums[j];	//!!����key�����滻��һ��while֮����Զ�������key���С��ֵ��key��ֵ�������滻
			if (nums[i]<key && i<j)
				i++;
			nums[j] = nums[i];
		}
		nums[i] = key;	//i==j����Ҫ��key�滻��i��j��λ��
		
		/*�����*/
		if (i-1 > start)
			quickSort(nums, start, i-1);
		/*���ұ�*/
		if (j+1 < end)
			quickSort(nums, j+1, end);
		
		return nums;
	}

}
