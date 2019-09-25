package 总结一.双指针移动.求两个数组合并之后的中位数;

public class Retry0 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;

        if ((len1+len2)%2==0){
            int k1=(len1+len2)/2;
            int k2=k1+1;
            return (find_k(nums1,nums2,k1)+find_k(nums1,nums2,k2))/(2.0);
        }else {
            int k=(len1+len2+1)/2;
            return find_k(nums1,nums2,k);
        }

    }

    private int find_k(int[] nums1, int[] nums2, int k) {

        int len1=nums1.length;
        int len2=nums2.length;

        int s1=0,s2=0;
        while (s1<len1 && s2<len2){
            if (k==1) {
                k--;
                return Math.min(nums1[s1], nums2[s2]);
            }
            //移动
            int t=k/2;


            int s11=s1+t-1;
            int s22=s2+t-1;

            if (s11>len1-1)
                s11=len1-1;
            if (s22>len2-1)
                s22=len2-1;
            //判定：
            if (nums1[s11]<nums2[s22]){
                k=k-(s11-s1+1);
                s1=s11+1;
            }else{
                k=k-(s22-s2+1);
                s2=s22+1;
            }

        }

       // System.out.println(k);
        if (k!=0){
            if (s1<nums1.length)
                return nums1[s1+k-1];
            else
                return nums2[s2+k-1];
        }


        return -1;

    }

}
