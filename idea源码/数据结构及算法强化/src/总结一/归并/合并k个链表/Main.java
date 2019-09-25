package 总结一.归并.合并k个链表;

public class Main {



    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null ||lists.length==0)
            return null;

        int len =lists.length;
        while (len!=1){
            int j=0;
            int i=0;
            while (i!=len && i+1!=len){
               merge(i,i+1,j,lists);
               j++;
               i+=2;
            }
            if (i+1==len)
                lists[j]=lists[i];
            /**
             * 归并 下一次的长度已知
             */
            len=(len+1)/2;
        }
        return lists[0];
    }

    private void merge(int i, int j,int index,  ListNode[] lists) {

        ListNode h1=lists[i];
        ListNode h2=lists[j];

        ListNode head=new ListNode(0);
        ListNode x=head;

        while (h1!=null && h2!=null){
            if (h1.val<h2.val){
                x.next=h1;
                x=h1;
                h1=h1.next;
            }else {
                x.next=h2;
                x=h2;
                h2=h2.next;
            }
        }

        if (h1!=null){
            x.next=h1;
        }
        if (h2!=null){
            x.next=h2;
        }

        lists[index]=head.next;
    }


}