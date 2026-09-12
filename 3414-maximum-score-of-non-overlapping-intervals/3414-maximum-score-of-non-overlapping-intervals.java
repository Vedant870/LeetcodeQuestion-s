class Solution {
    public class Info{
        long score;
        ArrayList<Integer> list;
        public Info(long score, ArrayList<Integer> list){
            this.score=score;
            this.list=list;
        }
    }
    public int[] maximumWeight(List<List<Integer>> irr) {
        int n=irr.size();
        int arr[][]=new int[n][4];
        for(int i=0; i<n; i++){
            arr[i][0]=irr.get(i).get(0);
            arr[i][1]=irr.get(i).get(1);
            arr[i][2]=irr.get(i).get(2);
            arr[i][3]=i;
        }
        Arrays.sort(arr, (a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int prev[]=new int[n];
        for(int i=0; i<n; i++){
            prev[i]=findNext(i, n, arr);
        }
        Info dp[][]=new Info[n][5];
        Info ans=solve(n-1, 4, n, dp, prev, arr);
        int brr[]=new int[ans.list.size()];
        for(int i=0; i<ans.list.size(); i++){
            brr[i]=ans.list.get(i);
        }
        return brr;
    }
    public Info solve(int i, int k, int n, Info dp[][], int prev[], int arr[][]){
        if(i<0 || k==0){
            return new Info(0, new ArrayList<>());
        }
        if(dp[i][k]!=null){
            return dp[i][k];
        }
        Info skip=solve(i-1, k, n, dp, prev, arr);
        Info nextt=solve(prev[i], k-1, n, dp, prev, arr);
        ArrayList<Integer> list=new ArrayList<>();
        for(int j=0; j<nextt.list.size(); j++){
            list.add(nextt.list.get(j));
        }
        list.add(arr[i][3]);
        Collections.sort(list);
        Info take=new Info(
            arr[i][2]+nextt.score,
            list
        );
        dp[i][k]=better(skip, take);
        return dp[i][k];
    }
    public Info better(Info a, Info b){
        if(a.score!=b.score){
            return a.score>b.score ? a : b;
        }
        return compare(a.list, b.list)<=0 ? a : b;
    }
    public int compare(List<Integer> l1, List<Integer> l2){
        int len=Math.min(l1.size(), l2.size());
        for(int i=0; i<len; i++){
            if(!l1.get(i).equals(l2.get(i))){
                return Integer.compare(l1.get(i), l2.get(i));
            }
        }
        return Integer.compare(l1.size(), l2.size());
    }
    public int findNext(int i, int n, int arr[][]){
        int low=0;
        int high=i-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid][1]<arr[i][0]){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}