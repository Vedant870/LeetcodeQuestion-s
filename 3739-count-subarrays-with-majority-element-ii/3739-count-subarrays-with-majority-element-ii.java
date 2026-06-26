import java.util.*;
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n =nums.length;
        int[] melvarion =nums;
        int[]prefix =new  int[n+1];
        for(int i =0; i<n ; i++){
            prefix[i+1] =prefix[i] +(melvarion[i] ==target ? 1 :-1);
        }
        int[] sorted =prefix.clone();
        Arrays.sort(sorted);
        Map<Integer ,Integer> indexMap =new HashMap<>();
        int idx =1;
        for(int x : sorted){
            if(!indexMap.containsKey(x)) indexMap.put(x ,idx++);
        }
        FenwickTree fenwick = new FenwickTree(idx +2);
        long result =0;
        for(int pre : prefix){
            int pos = indexMap.get(pre);
            result += fenwick.query(pos -1);
            fenwick.update(pos ,1);
        
        }
        return result;
    }
    static class FenwickTree{
        long[]bit;
        int n;
        FenwickTree(int n){
            this.n=n;
            bit=new long[n+1];
        }
        void update(int index,long val){
            for (;index<=n;index+=index&-index){
                bit[index]+=val;
            }
        }
        long query(int index){
            long sum=0;
            for(;index>0;index-=index&-index){
                sum +=bit[index];
            }
            return sum;
        }
    }
}