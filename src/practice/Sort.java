package practice;

/**
 * @version 2017.10.1
 * @author XINGXIN
 * */
public class Sort {
	
	/**
	 * <p>��������</br>
	 * �ݹ�.
	 * @param nums[]: ����
	 * @param start: 0
	 * @param end: nums.length - 1
	 * @return int[] nums.
	 * */
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
