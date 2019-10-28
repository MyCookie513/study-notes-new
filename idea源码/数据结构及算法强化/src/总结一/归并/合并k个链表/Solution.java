package 总结一.归并.合并k个链表;

public class Solution {


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists==null || lists.length==0)
            return null;

        SplitMerge(lists,0, lists.length-1);

        return lists[0];
    }

    private void SplitMerge(ListNode[] lists, int S, int E) {
        if (S==E){
            return;
        }
        int zhong =(S+E)/2;

        SplitMerge(lists,S,zhong);
        SplitMerge(lists,zhong+1,E);

        merge(lists,S,zhong+1);
    }

    private void merge(ListNode[] lists, int j, int i) {

        ListNode head =new ListNode(0);
        ListNode x=head;
        ListNode s1=lists[i];
        ListNode s2=lists[j];

        while (s1!=null && s2!=null){
            if (s1.val >s2.val){
                x.next=s2;
                x=s2;
                s2=s2.next;
            }else{
                x.next=s1;
                x=s1;
                s1=s1.next;
            }
        }


        while (s1!=null){
            x.next=s1;
            x=s1;
            s1=s1.next;
        }
        while (s2!=null){
            x.next=s2;
            x=s2;
            s2=s2.next;
        }
        lists[j]=head.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
