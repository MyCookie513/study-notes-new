package 将题目进行分类.双指针动态移动.求两个数组合并之后的中位数;


/**
 *
 *
 * 给出两个有序数组，然后求出这两个数组的中位数
 *
 *
 * (1):
 * 首先想到的是两个指针--》两个数组，进行逐渐移动+1，直到移动到    --->  中位数的位置
 *       那麽这样的复杂度为 n+m ;
 *
 * (2)
 *   尝试性优化 ； 移动的过程中 可以 移动 k/2
 *    这样查找的速度就为 lg k    在速度上明显提升了
 *
 *
 *
 */
public class solve {


    public static void main(String[] args) {

        System.out.println();


    }
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        boolean ifzhognjian =true;
        int x=(nums1.length+nums2.length)%2;
        if (x==0){
            ifzhognjian=false;
            //取x和x-1的值
            x=(nums1.length+nums2.length)/2;
        }else{
            x=(nums1.length+nums2.length)/2;
        }
        int[] a=new int[x+1];
        int h=0;int s1=0,s2=0;
        while (h<=x){
            if ( (s2<nums2.length)&&(s1>=nums1.length  || nums1[s1]>nums2[s2])){
                a[h]=nums2[s2];
                h++;s2++;
            }else{
                a[h]=nums1[s1];
                h++;s1++;
            }
        }

        System.out.println(x);
        if (ifzhognjian==true)
            return a[x];
        else
            return ((double) a[x-1]+(double) a[x])/2;

    }



    public double find(int[] nums1, int[] nums2){
        int len1=nums1.length;
        int len2=nums2.length;
        int len=(len1+len2);
        if (len%2==0){
            int s1=getK(nums1,0,nums1.length-1,nums2,0,nums2.length-1,len/2);
            int s2=getK(nums1,0,nums1.length-1,nums2,0,nums2.length-1,len/2+1);
            return (s1+s2)/2.0;
        }else{
            int s1=getK(nums1,0,nums1.length-1,nums2,0,nums2.length-1,len/2+1);
            return s1;
        }

    }

    private int getK(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {

        if (k==1){

            if (s1<=e1 && s2<=e2){
                return Math.min(nums1[s1],nums2[s2]);
            }else if (s1<=e1){
                return nums1[s1];
            }else {
                return nums2[s2];
            }
        }else{
            int x=k/2;
            //如果一方出界了，直接返回最终的结果；
            if (s1 > e1)
                return nums2[s2+k-1];
            if (s2 > e2)
                return nums1[s1+k-1];
            //如果移动后出界，则将数组调到最后以为进行比较；然后指针逐渐向右移动
            int s11=s1+x-1,s22=s2+x-1;
            if (s11>e1)
                s11=nums1.length-1;
            if (s22>e2)
                s22=nums2.length-1;
            if (nums1[s11]<nums2[s22])
                return getK(nums1,s11+1,nums1.length-1,nums2,s2,nums2.length-1,k-(s11-s1+1));
            else
                return getK(nums1,s1,nums1.length-1,nums2,s22+1,nums2.length-1,k-(s22-s2+1));
        }
    }

}
