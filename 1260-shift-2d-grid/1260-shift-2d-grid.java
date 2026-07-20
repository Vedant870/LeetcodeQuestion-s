class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        int len=row*col;
        int[] res=new int[len];
        int indx=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               res[indx++]=grid[i][j]; 
            }
        }
        indx=len-(k%len);
        List<List<Integer>> lt=new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> innerList=new ArrayList<>();
            for(int j=0;j<col;j++){
                innerList.add(res[indx%len]);
                indx++;
            }
            lt.add(innerList);
        }
        return lt;
    }
}