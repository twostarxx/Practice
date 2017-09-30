package practice;

public class Search {
	
	/*=====================二分查找===========================================*/
	/*-------非递归---------*/
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
                high = middle-1;	//因为middle已经比较过，所以不是 high = middle
            } else if (target > nums[middle]){
                low = middle+1;		//同理，不是low = middle
            } 
        }
        return -1;
    }

}
