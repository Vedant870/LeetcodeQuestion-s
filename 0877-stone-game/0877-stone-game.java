class Solution {
    public boolean stoneGame(int[] piles) {
        //Sravan.
        int last = piles.length-1;
        long al = 0;
        long bob = 0;
        boolean flag = true;
        int j=0;
        while(j<last){
            if(flag==true){
                if(piles[j]>piles[last] || piles[j]==piles[last]){
                    al+=piles[j];
                    j++;
                }
                else{
                    al+=piles[last];
                    last--;
                }
            }
            else{
                if(piles[j]>piles[last] || piles[j]==piles[last]){
                    bob+=piles[j];
                    j++;
                }
                else{
                    bob+=piles[last];
                    last--;
                }
            }
        }
        if(al>bob){
            return true;
        }
        return false;
    }
}