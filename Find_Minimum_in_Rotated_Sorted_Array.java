class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid]) {
                // left half sorted
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                // right half sorted
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }

        return min;
        
    }
}
