class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int n=nums1.length;
        int even=0;
        int odd=0;
        // even
        Arrays.sort(nums1);
        boolean flag=true;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2!=0)
            {
              if(odd>0)
              {
                even++;
              }
              else
              {
                flag=false;
                break;
              }

            }
            else
            {
               even++;
            }

        }
        // odd
        if(flag) return flag;
        flag=true;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2!=0)
            {
              
              odd++;

            }
            else
            {
                if(odd>0)
                {
                    odd++;
                }
                else
                {
                    flag=false;
                    break;
                }
               
            }

        }
        return flag;
    }
}