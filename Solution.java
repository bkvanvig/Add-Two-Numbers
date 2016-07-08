/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        
        if (l1 == null && l2 == null)
            return null;
        if (l1 != null && l2 == null)
            l2 = new ListNode(0);
        if (l1 == null && l2 !=null)
            l1 = new ListNode(0);
        
        sum = l1.val + l2.val;
        ListNode r = new ListNode(sum);
        if (r.val > 9){
            if (l1.next !=null){
                l1.next.val += r.val/10;
                r.val %= 10;
            }
            else if (l2.next !=null){
                l2.next.val += r.val/10;
                r.val%=10;
            }
            else{
                r.next = new ListNode(r.val/10);
                r.val %= 10;
                return r;
            }
                
        }
        
        r.next = addTwoNumbers(l1.next, l2.next);
        return r;
        
    }
}