public class FindMinOfRotateSort {
    /**
     * https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii/description?_from=ladder&&fromId=6
     *
     * 寻找旋转排序数组中的最小值 II
     * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
     *
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int idx1 = 0;
        int idx2 = nums.length - 1;
        int mid = idx1;
        while(nums[idx1] >= nums[idx2]){
            if(idx2 - idx1 == 1){
                mid = idx2;
                break;
            }
            mid = idx1 + (idx2 - idx1) / 2;
            if(nums[mid] == nums[idx1] && nums[mid] == nums[idx2]){
                return minOfOrder(nums);
            }
            if(nums[idx1] <= nums[mid]){
                idx1 = mid;
            }else{
                idx2 = mid;
            }
        }
        return nums[mid];
    }
    public int minOfOrder(int[] nums){
        int min = nums[0];
        for(int i=1; i< nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
            }
        }
        return min;
    }
}
