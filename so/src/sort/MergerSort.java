package sort;

import java.util.Arrays;

public class MergerSort {
    /*
    归并排序
    对于给定的数据序列，通过递归和分治的方式将待排序序列化分层越来越小的子序列，对子序列排序后，通过
    递归的方式将子序列合并成越来越大的有序序列。
     */
    private static int[] mergeSort(int[] arr){
        int length=arr.length;
        //此处可使用其他排序算法，提高效率；
        //例如插入排序
//        if(length<6){
//            int j=0;
//            int tmp;
//            for(int i=1;i<length;i++){
//               tmp=arr[i];
//               for(j=i;j>=1&&tmp<arr[j-1];j--){
//                   arr[j]=arr[j-1];
//               }
//               arr[j]=tmp;
//            }
//            return arr;
//        }
        if(length<2){return arr;}
        //划分2部分
        int mid=length/2;
        //左右两部分
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,length);
        //递归调用
        return  merge(mergeSort(left),mergeSort(right));
    }
    //合并两数组，升序
    private static int[] merge(int[] left,int[] right){
        int[] result=new int[left.length+right.length];
        for(int i=0,l=0,r=0;i<result.length;i++){
            //先判断有没有越界
            if(l>=left.length){
                result[i]=right[r++];
            }
            else if(r>=right.length){
                result[i]=left[l++];
            } else if (left[l] < right[r]) {
                result[i]=left[l++];
            }else{
                result[i]=right[r++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={90,43,43,67,82,30,45,73,40,50,39};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
