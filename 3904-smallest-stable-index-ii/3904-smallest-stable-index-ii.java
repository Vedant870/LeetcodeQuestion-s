class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] nextSmallest=new int[n];
        nextSmallest[n -1]=nums[n - 1];
        for(int i=n-2;i>=0;i--){
            nextSmallest[i] = Math.min(nextSmallest[i + 1], nums[i]);
        }
        int maxElement = nums[0];
        for(int i=0;i<n;i++){
            maxElement=Math.max(maxElement, nums[i]);
            if(maxElement-nextSmallest[i] <= k) return i;
        }
        return -1;
    }
}