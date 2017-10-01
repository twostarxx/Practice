package practice;

import java.util.Arrays;

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
	
	/**
	 * <p>�鲢����O(nlogn).<br>
	 * @param nums: int[]
	 * @param low: 0.
	 * @param high: nums.length-1.
	 * @return nums.
	 */
	public int[] mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(nums, low, mid);	//�������
			mergeSort(nums, mid+1, high);	//�ұ�����
			merge(nums, low, mid, high);	//��������
		}
		return nums;
	}
	/*�ص㣺����������κϲ�����ϸ��˼��*/
	public int[] merge(int[] ns, int low, int mid, int high) {
		int[] temp = new int[high-low+1];	
		int i=low, j=mid+1, k=0;
		while (i<=mid && j<=high) {	
			if (ns[i] <= ns[j]) {	//�Ƚ�ʣ�µ���������ĵ�һ����С�ķ���temp
				temp[k++] = ns[i++];
			} else {
				temp[k++] = ns[j++];
			}
		}
		//nsǰ��λ���ʣ��
		while (i <= mid) {
			temp[k++] = ns[i++];
		}
		//ns���λ���ʣ��
		while (j <= high) {
			temp[k++] = ns[j++];
		}
		for (int k2=0; k2<temp.length; k2++) {
			ns[k2+low] = temp[k2];
		}
		return ns;
	}
	
	/**
	 * <p>Ͱ����.<br>
	 * ���������и�Ҫ��,���ǳ�Ա�����ڹ̶�(���޵�)������.
	 * �緶ΧΪ[0-9](���Է���Ϊ1-100��)
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
