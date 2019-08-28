package Test;

public class 单链表排序 {

    public static void main(String[] args) {
        ListNode head1 =new ListNode(4);
        ListNode he2 =new ListNode(2);ListNode head3 =new ListNode(3);ListNode head4 =new ListNode(1);
        head1.next=he2;
        he2.next=head3;
        head3=head4;


        sortList(head1);
    }

    /**
     * 利用归并排序解决单链表排序的问题
     *
     *
     * 用快慢指针的方式  : 将一个链表进行二分
     *
     *
     * 然后利用归并的方式进行 divide --->  merge
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //链表二分 分为左右两部分；
        ListNode fast=head,slow=head ;
        fast=fast.next.next;
        while (fast !=null && fast.next !=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode left=head,right=slow.next;
        slow.next=null;
     /*   System.out.println("left :"+left.val );
        System.out.println("right :"+right.val );*/

        left=sortList(left);
        right=sortList(right);

        //merge
        ListNode newHead=new ListNode(0);
        ListNode xhead=newHead;
        while (left!=null && right != null){
            if (left.val >right.val){
                xhead.next=right;
                xhead=xhead.next;
                right=right.next;
            }else {
                xhead.next=left;
                xhead=xhead.next;
                left=left.next;
            }
        }

        if (left !=null){
            xhead.next=left;
        }

        if (right !=null){
            xhead.next=right;
        }

        return newHead.next;
    }





    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }



}
