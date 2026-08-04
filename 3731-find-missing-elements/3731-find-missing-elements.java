class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length -1;i++) {
            for (int value=nums[i]+ 1;value <nums[i+1];value++) {
                result.add(value);
            }
        }
        return result;
    }
}