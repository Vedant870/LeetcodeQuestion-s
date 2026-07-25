class Solution {
    public int maxProduct(int n) {
       ArrayList<Integer> list=new ArrayList<>();
      while(n>0){
        list.add(n%10);
        n/=10;
       
      }
      Collections.sort(list);
      int siz=list.size()-1;
      return list.get(siz)*list.get(siz-1);
     
    }
}