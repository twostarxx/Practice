package practice;

import java.util.Arrays;

public class BinarySearch {
	
	/*=====================���ֲ���===========================================*/
    /*-------�ݹ�---------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @start: 0.
     * @end: nums.length - 1.
     */
    public int binarySearchCur(int[] nums, int target, int start, int end) {
    	if (start <= end) {
    		int mid = start + (end-start) / 2;
    		if (target == nums[mid]) {
    			return mid;
    		} else if (target > nums[mid]) {
    			return binarySearchCur(nums, target, mid, end);
    		} else if (target < nums[mid]) {
    			return binarySearchCur(nums, target, start, mid);
    		}
    	}
    	return -1;
    }
	
	/*-------�ǵݹ飬����λ��-----------------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     */
	 /*ʹ������ָ�룬�ֱ�ָ��ͷ��β�����Ƚϵ��м�λ�á�*/
    public int binarySearch(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {  
	        return -1;  
	    }  
	    int start = 0, end = nums.length - 1;  
	    while (start + 1 < end) {  
	        int mid = start + (end - start) / 2;  
	        if (nums[mid] == target) {  
	            return mid;  
	        } else if (nums[mid] < target) {  
	            start = mid;  
	        } else {  
	            end = mid;  
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
    
    /*-------�ǵݹ飬�������һ�γ��ֵ�λ��---------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The last position of target. Position starts from 0.
     */
    public int binarySearchLastLoc(int[] nums, int target) {
    	if (nums == null || nums.length == 0)
    		return -1;
    	int start = 0, end = nums.length-1;
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] <= target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (nums[end] == target) {
    		return end;
    	}
    	if (nums[start] == target) {
    		return start;
    	}
    	return -1;
    }
    

}
