package 总结一.自主发挥.接雨水;

public class Main {


    public int trap(int[] height) {

        int result=0;

        int i=0;
        while (i<height.length){
            //寻找大于等于这个节点值的第一个值以及index,如果没有的话选取最大值以及index；

            int jishu=0;
            int  value=0;
            int index=0;

            for (int j=i+1;j<height.length;j++){
                if (height[j] >=height[i]) {
                    index=j;
                    value=height[i];
                    break;
                }else{
                    if (value<=height[j]){
                        value=height[j];
                        index=j;
                    }
                }
            }

            for (int t=i+1;t<index;t++){
                jishu+=value-height[t];
            }

            result+=jishu;
            if (index!=0) {
                i = index;
            }else i++;
        }

        return result;

    }


}
