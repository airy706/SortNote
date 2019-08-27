package sort;

import java.util.Arrays;

public class HeapSort {
    /*
    堆排序
    左节点：2*i+1
    右节点：2*（i+1）
    最后一个非叶子节点：n/2-1
     */
    //全局变量，记录存放堆元素数组长度
    private static int len;
    private static void swap(int[] arr,int i,int j){
        int tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
    private static void sort(int[] arr){
        len=arr.length;
        if(len<0){
            return ;
        }
        //构建二叉堆
        buildBinaryHeap(arr);
        //取出堆顶元素与尾元素交换，堆长度--，并进行调整
        while(len>0){
            swap(arr,0,len-1);
            len--;
            adjust(arr,0);
        }
    }
    private static void buildBinaryHeap(int[] arr){
        //从最后一个非叶子节点开始，进行调整
        for(int i=len/2-1;i>0;i--){
            adjust(arr,i);
        }
    }
    private static void adjust(int[] arr,int i){
        int maxIndex=i;
        int left=2*i+1;
        int right=2*(i+1);
        //与左节点右节点比较交换
        if(left<len&&arr[i]<arr[left]){
            maxIndex=left;
        }
        if(right<len&&arr[i]<arr[right]){
            maxIndex=right;
        }
        //若需要交换，对交换后的子节点递归调用调整
        if(maxIndex!=i){
            swap(arr,i,maxIndex);
            adjust(arr,maxIndex);
        }

    }

    public static void main(String[] args) {
        int[] arr={12,34,56,22,4,6,90,64,34,56,73,43,567,42,5743,6534,543,5,3,562,6798};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
