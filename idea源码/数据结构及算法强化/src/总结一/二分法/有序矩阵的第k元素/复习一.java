package 总结一.二分法.有序矩阵的第k元素;



public class 复习一 {


    /**
     *
     * 这道题看似有规律，实则 给我们的信息仅有
     * todo 表面提供的信息 ， 而推出的特性基本没有，而且在我们做题的时候还产生了很多误解；
     *
     *
     * todo 解题思路：
     * todo 全局思路:
     *  1. 知道最大值最小值， 我们需要寻找第 k值 ，而第 k 值就在 L = min   与   R = max  中间 ， 然后我们可以不断取中间值，然后
     *  逐步缩小范围，直到 出现　L = R 的情况；
     *
     * todo 注意：  范围值代表 L <= 范围 <= R ;
     *
     *todo    L->|_____________|<-R   划分范围　：　L->｜＿＿＿＿｜mid     (mid +1)｜＿＿＿＿＿｜<-R
     *todo    这里要重点说明 mid 划分判定条件一定是  属于左范围的 ， 当然会问为甚麽呢？
     * 这里 将mid 划分为右半范围   L--mid-1  mid--R 这种划分方式不可以吗？  在整数划分时，这种划分是肯定不行的；
     * for example    (2+3)/2 =2 ;  此时如果恰好判定范围为右范围，这样的话 新范围还是 【 2，3】，无线循环；
     *
     */

    public int kthSmallest(int[][] matrix, int k) {

        int L =matrix[0][0];
        int R =matrix[matrix.length-1][matrix.length-1];

        while (L != R ){
            int mid =(L+R)/2;
            int count =getIndex(mid,matrix);//todo 找到 mid 的 index ； 分割点 必须是 左范围包含中间点；右范围不包括中间点

            if (count>=k){//todo k在左范围的情况
                R=mid;
            }else{
                L=mid +1; //todo k在右范围 情况
            }
        }
        return L;

    }

    //todo 用于计算 <=mid 的值有多少；
    private int getIndex(int mid ,int[][] a) {
        int count =0;
        for (int i = 0; i <a.length; i++) {
            int len =a.length;
            while (len>=1){
                if (a[i][len-1]>mid){
                    len--;
                    continue;
                }
                count=count+len;
                break;
            }
        }
        return count;
    }


}
