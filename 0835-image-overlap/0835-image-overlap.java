class Solution {
    class Coordinate{
        int row;
        int col;
        public Coordinate(int row, int col){
            this.row=row;
            this.col=col;
        }
        @Override
        public boolean equals(Object o) {
            if (this==o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate c=(Coordinate) o;
            return row==c.row && col==c.col;
        }
        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int img1Rows=img1.length;
        int img1Cols=img1[0].length;
        int img2Rows=img2.length;
        int img2Cols=img2[0].length;
        List<Coordinate> img1Coords=new ArrayList<>();
        List<Coordinate> img2Coords=new ArrayList<>();
        for(int i=0;i<img1Rows;i++){
            for(int j=0;j<img1Cols;j++){
                if(img1[i][j]==1){
                    img1Coords.add(new Coordinate(i,j));
                }
            }
        }
        for(int i=0;i<img2Rows;i++){
            for(int j=0;j<img2Cols; j++){
                if(img2[i][j]==1){
                    img2Coords.add(new Coordinate(i,j));
                }
            }
        }
        Map<Coordinate, Integer> frequency=new HashMap<>(); 
        for(int i=0;i<img1Coords.size();i++){
            for(int j=0;j<img2Coords.size();j++){
                int rowDiff=img2Coords.get(j).row-img1Coords.get(i).row;
                int colDiff=img2Coords.get(j).col-img1Coords.get(i).col;
                Coordinate diff = new Coordinate(rowDiff, colDiff);
                frequency.put(diff, frequency.getOrDefault(diff, 0) + 1);
            }   
        }
        int res=0;
        for(Map.Entry<Coordinate, Integer> entry: frequency.entrySet()){
            res = Math.max(res,entry.getValue());
        }
        return res;
    }
}