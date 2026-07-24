import java.util.ArrayList;
import java.util.HashSet;
class Solution{
    public int uniqueXorTriplets(int[] nums){
        HashSet<Integer> uniqueValues=new HashSet<>();
        for(int number:nums){
            uniqueValues.add(number);
        }
        ArrayList<Integer> distinctNumbers=new ArrayList<>(uniqueValues);
        int maxXorValue=(int)Math.pow(2,11);
        boolean[][] dp=new boolean[4][maxXorValue];
        dp[0][0]=true;
        for(Integer currentNumber:distinctNumbers){
            for(int selectedCount=3;selectedCount>0;selectedCount--){
                for(int xorValue=0;xorValue<maxXorValue;xorValue++){
                    if(dp[selectedCount-1][xorValue]){
                        dp[selectedCount][xorValue^currentNumber]=true;
                    }
                }
            }
        }
        for(int xorValue=0;xorValue<maxXorValue;xorValue++){
            if(dp[3][xorValue]){
                uniqueValues.add(xorValue);
            }
        }
        return uniqueValues.size();
    }
}