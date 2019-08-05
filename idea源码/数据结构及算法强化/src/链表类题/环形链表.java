package 链表类题;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个带有环形的链表；求出这个链表的size
 *https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class 环形链表 {


    public static void main(String[] args) {
        ListNode node0=new ListNode(0);
        ListNode node1=new ListNode(1);
        node0.next=node1;
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        ListNode node4=new ListNode(4);
        node3.next=node4;
        ListNode node5=new ListNode(05);
        node4.next=node5;
        ListNode node6=new ListNode(06);
        node5.next=node6;
        ListNode node7=new ListNode(07);
        node6.next=node7;
        ListNode node8=new ListNode(8);
        node7.next=node8;
        ListNode node9=new ListNode(9);
        node8.next=node9;
        ListNode node10=new ListNode(10);
        node9.next=node10;

        //node10.next=node4;
        System.out.println(hasCycle(node0));
        System.out.println(linedsize(node0));


    }
    /**
     * 节点class
     */
    static class ListNode {
          int val;
          ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
    public static int linedsize(ListNode head) {
        ListNode sNode=head;
        ListNode fNode=head;
        ListNode listNode;

        //这里是找到环形的开始节点，利用的是快慢指针的方式；
        /****************************************/
        while (true){
            if (sNode.next!=null&&fNode.next!=null&&fNode.next.next!=null){
                sNode=sNode.next;
                fNode=fNode.next.next;
            }else return 0;
            if (sNode==fNode){
                listNode=sNode;
                break;
            }
        }
        sNode=head;
        while(true){
            if(sNode==listNode)
                break;
            else {

                sNode=sNode.next;
                listNode=listNode.next;            }
        }
      /***************************************/


        System.out.println("环形的起点为"+listNode.val);
        int broadwise =0;
        int ring =1;
        ListNode node =head;
        while (true){
            if (node ==listNode){
                break;
            }else {
                node = node.next;
                broadwise++;
            }
        }
        System.out.println("非环形部分的长度为"+broadwise);

        node=listNode.next;
        while (true){
            if (node ==listNode){
                break;
            }else {
                node = node.next;
                ring++;
            }
        }
        System.out.println("环形部分的长度为"+ring);



        return broadwise+ring;
    }


    /**
     * 判定链表中是否有环形结构；
     * @param head
     * @return
     */
    public static  boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap();
        ListNode listNode = head;
        boolean flag = false;
        while (true) {
            if (map.containsKey(listNode)) {
                flag = true;
                break;
            } else {
                map.put(listNode,true);
                if(listNode.next!=null)
                    listNode = listNode.next;
                else break;
            }


        }
        return flag;
    }


}
