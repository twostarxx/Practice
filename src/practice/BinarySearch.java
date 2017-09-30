package practice;

public class BinarySearch {
	
	/*=====================���ֲ���===========================================*/
	/*-------�ǵݹ飬����λ��-----------------*/
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
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
