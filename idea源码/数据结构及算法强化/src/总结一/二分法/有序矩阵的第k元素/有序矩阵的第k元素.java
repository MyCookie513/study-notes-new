package 总结一.二分法.有序矩阵的第k元素;

public class 有序矩阵的第k元素 {

    public int kthSmallest(int[][] matrix, int k) {

        int n =matrix.length;
        int e=matrix[n-1][n-1];
        int s=matrix[0][0];
        while (s!=e){
            System.out.println(s +"  "+e);
            int mid=(e+s)/2;
            int count=getIndex(matrix,mid);//todo < mid值的有多少个；
            System.out.println(count);

            if (count >=k){
                e=mid;//todo   now　：　target  <=  e;
            }else{//todo mid值大于第 k 值
                s=mid+1;
            }
        }

        return s;
    }

    private int getIndex(int[][] matrix, int mid) {

        int count =0;
        for (int i = 0; i < matrix.length ; i++) {
            int n=matrix.length;
            int x=matrix.length-1;
            while (x>=0 && mid <matrix[i][x]){
                n--;
                x--;
            }
            count=count+n;
        }
        return count;
    }


}
