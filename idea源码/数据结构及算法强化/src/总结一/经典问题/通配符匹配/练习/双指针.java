package 总结一.经典问题.通配符匹配.练习;

public class 双指针 {


    //todo

    /**
     * 指针性质的题目：
     *
     * 设置指针；
     * 动态指向判定
     * 跳出循环判定结果
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();


        //两个指针的起点
        int i=0 ,j=0;

        int p_s =-1,s_s=-1;


        while (i<ss.length ){ //todo 只能允许ss用完，但不能允许pp用完退出，因为pp中有 *的话，可以进行延长匹配；

            if (j<pp.length){
                //面对着三种情况；
                if ( ss[i]==pp[j]){ //两者正好匹配

                    i++;
                    j++;

                }else if (pp[j] == '?') {

                    i++;
                    j++;

                }else if (pp[j] == '*') {

                    // todo 记录回退点
                    p_s=j;
                    s_s=i;

                    //首先尝试 * 匹配为空；
                    j++;

                }else{//两者之间匹配失败，如果有回退点的话进行回退

                    if (p_s!=-1){
                        s_s++;
                        i=s_s;
                        j=p_s+1;
                    }else{
                        return false;
                    }
                }
            } else{

                if (p_s!=-1){
                    s_s++;
                    i=s_s;
                    j=p_s+1;
                }else{
                    return false;
                }
            }
        }

        while (j<pp.length){
            if (pp[j++]!='*')
                return false;
        }

        return true;


    }








}
