package sort;

import java.util.Arrays;

public class QuickSort {
    /*
    快速排序
    选择基准数（随机法/三数中值法）
    i从头到尾，j从尾到头
    i对应元素大于基准数，j对应元素小于基准数，交换元素
    重复该过程直到i j交叉
     */
    //交换数组元素
    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    //三数中值法
    private static int pivot(int[] arr,int left,int right){
        int mid=(left+right)/2;
        if(arr[mid]>arr[right]){
            swap(arr,mid,right);
        }
        if(arr[left]>arr[mid]){
            swap(arr,left,mid);
        }
        if(arr[left]>arr[right]){
            swap(arr,left,right);
        }
        //arr[right]大于基准数，将基准数放在right-1的位置
        swap(arr,mid,right-1);
        //返回基准数
        return arr[right-1];
    }
    private static void quickSort(int[] arr,int begin,int end){
//        if(arr.length<=1||arr.length<=end||begin<0||begin>end){
//            return;
//        }
        //小数组时插入排序
        if((end-begin)<6){
            int j=0;
            int tmp=0;
            for(int i=1;i<arr.length;i++){
                tmp=arr[i];
                for(j=i;j>=1&&tmp<arr[j-1];j--){
                    arr[j]=arr[j-1];
                }
                arr[j]=tmp;
            }

        }else{
            //基准数
            int pivot=pivot(arr,begin,end);
            int i=begin;
            int j=end-1;
            //i从前往后，j从后往前
            for(;;){
                while(arr[++i]<pivot){}
                while(arr[--j]>pivot){}
                if(i<j){
                    swap(arr,i,j);
                }else{
                    break;
                }
            }
            swap(arr,i,end-1);
            quickSort(arr,begin,i-1);
            quickSort(arr,i+1,end);
        }

    }

    public static void main(String[] args) {
        int[] arr={12,34,56,22,4,6,90,64,34,56,73,43,567,42,5743,6534,543,5,3,562,6798};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
