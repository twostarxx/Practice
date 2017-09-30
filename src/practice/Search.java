package practice;

public class Search {
	
	/*=====================二分查找===========================================*/
	/*-------非递归，返回位置-----------------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
	 /*使用三个指针，分别指向头、尾、待比较的中间位置。
	   注意：指针修改时并不是直接改为middle。*/
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
                high = middle-1;	//因为middle已经比较过，所以不是 high = middle
            } else if (target > nums[middle]){
                low = middle+1;		//同理，不是low = middle
            } 
        }
        return -1;
    }
	
	
	/*-------非递归，返回第一次出现的位置---------*/
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
        while (start + 1 < end) {   //区间长度小于2
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
