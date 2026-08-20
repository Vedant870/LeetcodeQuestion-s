class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0]=nums[0];
        int l=0;
        arr2[0]=nums[1];
        int r=0;
        for(int i=2;i<n;i++){
            if(arr1[l]>arr2[r]){
                l++;
                arr1[l]=nums[i];
            }
            else{
                r++;
                arr2[r]=nums[i];
            }
        }
        for(int i=0;i<=l;i++)
            ans[i]=arr1[i];
        for(int i=0;i<=r;i++)
            ans[l+i+1]=arr2[i];
        return ans;
    }
}