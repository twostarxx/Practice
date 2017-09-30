package practice;

public class Search {
	
	/*=====================���ֲ���===========================================*/
	/*-------�ǵݹ�---------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
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

}
