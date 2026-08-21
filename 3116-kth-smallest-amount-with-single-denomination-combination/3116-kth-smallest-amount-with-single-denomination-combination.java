class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long min = coins[0];
        long max=coins[0];
        for(int i=0;i<coins.length;i++){
            min=Math.min(coins[i],min);
            max=Math.max(coins[i],max);
        }
        long left=1;
        long right=1000000000000000000L;
        long ans=Long.MAX_VALUE;
        while(left<right){
            long mid=left+(right-left)/2;
            if(isGreaterk(mid,coins,k)){
                ans=Math.min(mid,ans);
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isGreaterk(long mid, int []coins,long k){
        long l = countUniqueMultiples(coins,mid);
        // System.out.println(mid+" "+l);
        if(l>=k){
            return true;
        }
        return false;
    }
      public  long countUniqueMultiples(int[] numbers, long k) {
        return countMultiplesRecursive(numbers, k, 1, 0, -1);
    }

    private long countMultiplesRecursive(int[] numbers, long k, long lcm, int depth, int lastIdx) {
         long count = 0;
         if(depth==numbers.length){
             return 0;
         }
        for (int i = lastIdx + 1; i < numbers.length; i++) {
            long newLcm = depth == 0 ? numbers[i] : lcm(lcm,numbers[i]);
            long currentMultipleCount = (k) / newLcm;
            if (depth % 2 == 0) {
                count += currentMultipleCount;
            } else {
                count -= currentMultipleCount;
            }
            count += countMultiplesRecursive(numbers, k, newLcm, depth + 1, i);
        }
        return count;
    }
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }   
}