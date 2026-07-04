class Solution {
    static class Pair{
        int dest;
        int cost;
        Pair(int dest, int cost){
            this.dest=dest;
            this.cost=cost;
        }
    }
    private int bfs(int start, List<List<Pair>> graph,boolean[] vis){
        Queue<Integer>q=new ArrayDeque<>();
        q.add(start);
        int minDist=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int front=q.poll();
            vis[front]=true;
            for(Pair neigh: graph.get(front)){
                if(vis[neigh.dest]) continue;
                minDist=Math.min(minDist, neigh.cost);
                q.offer(neigh.dest);
            }
        }
        return minDist;
    }
    public int minScore(int n, int[][] roads) {
        boolean[] visited=new boolean[n+1];
        List<List<Pair>>graph=new ArrayList<List<Pair>>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int[] road: roads){
            int u=road[0];
            int v=road[1];
            int cost=road[2];
            graph.get(u).add(new Pair(v, cost));
            graph.get(v).add(new Pair(u, cost));
        }
        return bfs(1, graph, visited);
    }
}