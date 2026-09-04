class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] sufixMin = new int[n];
        prefixMax[0] = nums[0];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
        }
        sufixMin[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            sufixMin[i] = Math.min(sufixMin[i+1], nums[i]);
        }
        for(int i=0; i<n; i++){
            if(prefixMax[i] - sufixMin[i] <= k){
                return i;
            }
        }
        return -1;
    }
}