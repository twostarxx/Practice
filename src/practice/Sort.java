package practice;

public class Sort {
	
	/**��������
	 * @nums[]: ����
	 * @start: 0
	 * @end: nums.length - 1
	 * 
	 * System.out.println(Arrays.toString(nums));
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
