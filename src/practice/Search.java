package practice;

public class Search {
	
	/*=====================���ֲ���===========================================*/
	/*-------�ǵݹ飬����λ��-----------------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
	 /*ʹ������ָ�룬�ֱ�ָ��ͷ��β�����Ƚϵ��м�λ�á�
	   ע�⣺ָ���޸�ʱ������ֱ�Ӹ�Ϊmiddle��*/
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int low = 0;
        int high = nums.length-1;
        int middle;
        while (low <= high){
        	middle  = (low + high)/2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                high = middle-1;	//��Ϊmiddle�Ѿ��ȽϹ������Բ��� high = middle
            } else if (target > nums[middle]){
                low = middle+1;		//ͬ������low = middle
            } 
        }
        return -1;
    }
	
	
	/*-------�ǵݹ飬���ص�һ�γ��ֵ�λ��---------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearchFirstLoc(int[] nums, int target) {
        if (nums == null || nums.length == 0) {  
            return -1;  
        }  
        int start = 0, end = nums.length - 1;  
        while (start + 1 < end) {   //���䳤��С��2
            int mid = start + (end - start) / 2;  
            if (nums[mid] >= target) {  
                end = mid;  
            } else {  
                start = mid;  
            }  
        }  
        if (nums[start] == target) {  
            return start;  
        }  
        if (nums[end] == target) {  
            return end;  
        }  
        return -1;  
    }

}
