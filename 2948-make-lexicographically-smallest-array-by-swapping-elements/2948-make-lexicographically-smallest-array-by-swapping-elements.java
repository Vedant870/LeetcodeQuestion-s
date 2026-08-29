class Pair{
    int node;
    int index;
    public Pair(int node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    static int[] rank;
    static int[] parent;
        public static int  find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i]=find(parent[i]);
    }
    public static void Union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent != yParent) {
            if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else if (rank[yParent] < rank[xParent]) {
                parent[yParent] = xParent;
            } else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        ArrayList<Pair> p=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            p.add(new Pair(nums[i],i));
        }
         rank=new int[nums.length];
        parent=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            rank[i]=0;
            parent[i]=i;
        }

        Collections.sort(p,Comparator.comparingInt(l->l.node));
        for(int i=0;i<n-1;i++){
            Pair m=p.get(i);
            Pair n1=p.get(i+1);
            if((Math.abs(m.node - n1.node)<=limit)){
                if(find(m.index)!=find(n1.index)){
                    Union(m.index,n1.index);
                }
            }
        }
        HashMap<Integer,ArrayList<Pair>> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(find(i))){
                hs.get(find(i)).add(new Pair(nums[i],i));
            }
            else{
                 hs.put(find(i),new ArrayList<>());
                 hs.get(find(i)).add(new Pair(nums[i],i));
            }
        }
        int[] ans=new int[nums.length];
        for(Map.Entry<Integer,ArrayList<Pair>> am:hs.entrySet()){
            ArrayList<Pair> m=am.getValue();
            List<Integer> nodes=new ArrayList<>();
            List<Integer> indexes=new ArrayList<>();
            for(Pair l:m){
                nodes.add(l.node);
                indexes.add(l.index);
            }
            Collections.sort(nodes);
            Collections.sort(indexes);
            for(int i=0;i<nodes.size();i++){
                ans[indexes.get(i)]=nodes.get(i);
            }

        }
        return ans;

    }
}