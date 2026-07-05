class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return memo(n-1,n-1,board,dp);
    }
    int mod = (int)1e9+7;
    public int[] memo(int r,int c,List<String> board,int[][][] dp){
        if(r==0 && c==0){
            return new int[]{0,1};
        }
        if(r<0 || c<0 || board.get(r).charAt(c)=='X'){
            return new int[]{0,0};
        }
        if(dp[r][c][0]!=-1) return dp[r][c];
        int[] up = memo(r-1,c,board,dp);
        int[] left = memo(r,c-1,board,dp);
        int[] diag = memo(r-1,c-1,board,dp);
        int max = Math.max(up[0],left[0]);
        max = Math.max(max,diag[0]);
        int count = 0;
        if(up[0]==max){
            count=(count+up[1])%mod;
        }
        if(left[0]==max){
            count=(count+left[1])%mod;
        }
        if(diag[0]==max){
            count=(count+diag[1])%mod;
        }
        char ch=board.get(r).charAt(c);
        max+=(ch=='S')?0:(ch-'0');
        if(count==0) max = 0;
        return dp[r][c] = new int[]{max,count};
    }
}