package 总结一.BFS和DFS精通的题.单词接龙2;

import java.util.*;

public class BFS剪枝DFS深搜 {


    boolean istouch=false;


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        //todo 最后返回的结果；
        List<List<String>> result=new ArrayList<>();

        //todo 定义双向BFS，进行遍历的每层
        Set<String> startList=new HashSet<>();
        Set<String> endList=  new HashSet<>();
        //todo 将BFS剪枝后的结果，放入map地图中，后续进行DFS的选出可达性路线
        Map<String,List<String>> map=new HashMap<>();

        //todo 用于查询的字典；
        Set<String> words=new HashSet<>(wordList);
        words.removeAll(startList);

        //todo 不包含结束单词；
        if (!words.contains(endWord))
            return result;

        startList.add(beginWord);
        endList.add(endWord);


        istouch=false;

        //todo 单用BFS 剪枝建树的入口；
        BFS(startList,endList,map,words,false);
        if (!istouch)
            return result;

        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() +"   :"+entry.getValue().toString());
        }
        DFS0(beginWord,endWord,result,map,new ArrayList<String>());

        return result;

    }

    private void DFS0(String beginWord, String endWord, List<List<String>> result, Map<String, List<String>> map, ArrayList<String> strings) {

        if (beginWord.equals(endWord)){
            strings.add(beginWord);
            result.add(new ArrayList<>(strings));
            strings.remove(beginWord);
        }

        if (map.containsKey(beginWord)){
            strings.add(beginWord);
            List<String> list=map.get(beginWord);
            for (String s: list) {
                DFS0(s,endWord,result,map,strings);
            }
            strings.remove(beginWord);
        } else{
            return;
        }

    }

    private void BFS(Set<String> startList, Set<String> endList, Map<String, List<String>> map, Set<String> words, boolean reserve) {

        //todo 这一层没有可达的路线了，说明不可能走通了；
        if (startList.size()==0) return;

        //todo 层级删除： 应用背景可搜索所有最短路径；
        words.removeAll(startList);

        Set<String> nextCeng=new HashSet<>();
        for(String s : startList){
            char[] c=s.toCharArray();
            //todo s.length = n  时间复杂度 : 26n
            for (int i = 0; i <c.length ; i++) {
                char c0=c[i];
                for (int j = 'a'; j <='z' ; j++) {
                    c[i]=(char)j;
                    String s1=String.valueOf(c);
                    if (words.contains(s1)){
                        if (endList.contains(s1)){
                            istouch=true;
                        }else{
                            nextCeng.add(s1);
                        }
                        //todo 对下一层遍历到的进行建树
                        String key =reserve? s1 : s;
                        String value =reserve? s:s1;
                        System.out.println("key:"+key +"   v : "+value);
                        if (!map.containsKey(key))
                            map.put(key,new ArrayList<>());
                        map.get(key).add(value);
                    }
                }
                c[i]=c0;
            }
        }
        if (istouch)
            return;
        else{
            //todo 选择小的ceng进行下一层的搜索；
            if (nextCeng.size()>endList.size()){
                BFS(endList,nextCeng,map,words,!reserve);
            }else{
                BFS(nextCeng,endList,map,words,reserve);
            }
        }



    }


}
