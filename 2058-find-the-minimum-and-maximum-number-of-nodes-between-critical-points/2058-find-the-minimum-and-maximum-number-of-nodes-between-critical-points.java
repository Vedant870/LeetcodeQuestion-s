/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // maxima= cur node> prev node and next node
        // minima= cur node < prevnode and next node
        // if prev and next exist then only local maxima, minima
        int first=-1 ;// 1st critical point
        int last=-1 ;// last cp 
        int index=1;
        int min=Integer.MAX_VALUE;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr.next!=null){
            //check if cur node is cp
            if((curr.val >prev.val && curr.val>curr.next.val)||
            (curr.val< prev.val && curr.val<curr.next.val)){
                if(first==-1){
                    first=index;
                    last=index;
                }
                else{
                    min=Math.min(min,index-last);
                    last=index;
                }
            }
            prev=curr;
            curr=curr.next;
            index++;
        }
        if(first==last){
            return new int[]{-1,-1};
        }
        return new int[]{min,last-first};
    }
}