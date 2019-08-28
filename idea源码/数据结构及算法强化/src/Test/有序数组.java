package Test;

public class 有序数组 {



    /***
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）O(log(m+n）。
     *
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)O(1)。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        /**
         * 如果是偶数的话，分别求出中间的两个数
         * 如果是奇数的话，求出中间的那个第k个数就好
         */
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }





















    public static void main(String[] args) {

        int[] a={1,3,4,5};
        int[] b={1,2,6,7,8,9,10,11,12,13};
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        boolean zho= false;
        int k=0;
        if ((n+m)%2==0) {
            zho = true;
            k=(n+m)/2;
        }else{
            k=(n+m)/2+1;
        }

        int s1=0,s2=0;



        while (true){
            if (k==1){
                if (zho==false){
                    if (s1<nums1.length && s2<nums2.length)
                      return  Math.min(nums1[s1],nums2[s2]);
                    else if (s1<nums1.length)
                        return nums1[s1];
                    else
                        return nums2[s2];
                }else{
                    if (s1<nums1.length && s2<nums2.length) {
                        if (nums1[s1] > nums2[s2]) {

                            if (s2 + 1 < nums2.length)
                                return (nums2[s2] + Math.min(nums1[s1], nums2[s2 + 1])) / 2.0;
                            else
                                return (nums2[s2] + nums1[s1]) / 2.0;
                        }else {
                            if (s1 + 1 < nums1.length)
                                return (nums1[s1] + Math.min(nums2[s2], nums1[s1 + 1])) / 2.0;
                            else
                                return (nums1[s1] + nums2[s2]) / 2.0;
                        }
                    }
                    else if (s1<nums1.length)
                        return (nums1[s1] + nums1[s1+1]) / 2.0;
                    else
                        return (nums2[s2] + nums2[s2+1]) / 2.0;

                }
            }
            int x=k/2;
            k=k-x;
           //
            if (nums1[s1+x-1]>nums2[s2+x-1]){
                //如果有一方在移动的过程中到了终点的话；
                if (s2+x-1==nums2.length-1){
                    s1=k+s1-2;
                    k=1;
                    continue;
                }
                s2=s2+x;

                if (s2>=nums2.length)
                    s2=nums2.length-1;
            }else{
                if (s1+x-1==nums1.length-1){
                    s2=k+s2-2;
                    k=1;
                    continue;
                }
                s1=s1+x;
                System.out.println();
                if (s1>=nums1.length)
                    s1=nums1.length-1;
            }




        }
    }




}
