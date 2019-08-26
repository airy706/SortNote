package InsertSort;

import java.util.Arrays;

public class InsertSort {
    /*
    对于未排序的数据，在已排序的序列中从后往前扫描，并在相应位置插入
    需将插入位置之后的元素都往后移一位
    适合部分有序序列和小规模序列
     */
    public static void sort(int[] arr){
        //已排序序列的最后一位元素
        int j=0;
        //待排序数据
        int tmp=0;
        //把序列第一个元素当成已排序序列，从第二个元素开始作为未排序数据，i为待排序数据的索引
        for(int i=1;i<arr.length;i++){
            tmp=arr[i];
            //前i个元素为已排序序列，从后往前遍历已排序序列
            //升序，待排序数据小于已排序序列的值时，后移一位，不小于时进行插入
            for(j=i;j>0&&tmp<arr[j-1];j--){
                arr[j]=arr[j-1];
            }
            arr[j]=tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr={2,4,3,8,4,7,90,4,43,50,23,475,682,63,3517,640};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
