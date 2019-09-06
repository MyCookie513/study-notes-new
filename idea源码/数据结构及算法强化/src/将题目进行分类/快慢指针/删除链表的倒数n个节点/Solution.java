package 将题目进行分类.快慢指针.删除链表的倒数n个节点;


public class Solution {






    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hd = head;
        ListNode s = head, f = head;
        int i = 0;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            i++;
        }
        int sum = 0;
        int hadstep = i + 1;
        if (f == null)
            sum = 2 * i;
        else sum = 2 * i + 1;

        int zhengshu = sum - n + 1;
        if (zhengshu > hadstep) {
            while (zhengshu - 1 != hadstep) {
                s = s.next;
                hadstep++;
            }
            s.next = s.next.next;

            return hd;
        } else {
            int k = 1;
            ListNode ss = hd;
            if (zhengshu == 1) {
                hd = hd.next;
                return hd;
            }
            while (zhengshu - 1 != k) {
                ss = ss.next;
                k++;
            }
            ss.next = ss.next.next;

            return hd;
        }

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}