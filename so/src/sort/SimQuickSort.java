package sort;

import java.util.Arrays;

public class SimQuickSort {
    public static void sort(int[] arr,int begin,int end){
        if(arr.length<=1||begin<0||end>=arr.length||begin>end){
            return;
        }
        int pivot= arr[begin];

        int i=begin,j=end;
        for(;;){
            while(arr[j]>=pivot&&i<j){
                j--;
            }
            while(arr[i]<=pivot&&i<j){
                i++;
            }
            if(i<j){
                swap(arr,i,j);
            }else{
                break;
            }
        }
        swap(arr,i,begin);
        sort(arr,begin,i-1);
        sort(arr,i+1,end);

    }
    private static  void swap(int[] arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String[] args) {
        int[] arr={12,34,56,22,4,6,90,64,34,56,73,43,567,42,5743,6534,543,5,3,562,6798};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
