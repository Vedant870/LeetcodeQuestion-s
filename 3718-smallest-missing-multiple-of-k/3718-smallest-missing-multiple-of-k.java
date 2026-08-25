class Solution {
    public int missingMultiple(int[] nums, int k) {  
        Arrays.sort(nums);
        if((nums[0] > k) || (k > nums[nums.length-1]))
            return k;
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]-nums[i+1] != 1){
                 for(int j = nums[i] + 1; j < nums[i+1]; j++){
                    if(j % k == 0)
                        return j;

                 }
               }
        }
        int sol = nums[nums.length-1]+1;
        while(true){
           if(sol % k == 0)
               return sol;
            sol++;
        }
    }
}