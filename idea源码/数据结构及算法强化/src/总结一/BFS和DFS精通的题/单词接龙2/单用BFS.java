package 总结一.BFS和DFS精通的题.单词接龙2;

import java.util.*;

public class 单用BFS {
    boolean istouch=false;
    private String endStr ;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        endStr=endWord;
        istouch=false;
        List<List<String>> result =new ArrayList<>();
        Set<String> words =new HashSet<>(wordList);

        if (!words.contains(endWord))
            return result;
        Set<Node> Ceng =new HashSet<>() ;
        Set<String> rm =new HashSet<>();
        rm.add(beginWord);

        Ceng.add(new Node(beginWord));
        while (Ceng.size()!=0){
            words.removeAll(rm);
            rm.clear();
            Set<Node> newCeng=new HashSet<>();
            for (Node node: Ceng){
                verrify(node,words,rm,newCeng,result);//todo 把字典里面包含有的封装成指向此节点的node；
            }

            Ceng=newCeng;
            if (istouch)
                break;
        }

        return result;
    }

    private Set<Node> verrify(Node node, Set<String> words, Set<String> rm,Set<Node> newCeng,  List<List<String>> result) {
        char[] cs=node.val.toCharArray();

        for (int i = 0; i <cs.length; i++) {
            char c0=cs[i];
            for (char c='a';c<='z';c++){
                cs[i]=c;
                String s=String.valueOf(cs);
                if (words.contains(s)){
                    rm.add(s);

                    if (s.equals(endStr)){
                        //todo 收集此条路线
                        LinkedList<String> list=new LinkedList<>();
                        list.add(s);
                        while (node!=null){
                            list.addFirst(node.val);
                            node=node.pre;
                        }
                        result.add(list);
                        istouch=true;
                    }
                    if (!istouch)
                        newCeng.add(new Node(node,s));
                }
            }
            cs[i]=c0;
        }
        return newCeng;
    }


    class Node {
        public Node(String val) {
            this.val = val;
        }

        public Node(Node pre, String val) {
            this.pre = pre;
            this.val = val;
        }

        Node pre;
        String val;
    }
}
