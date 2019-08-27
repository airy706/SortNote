package sort;

import java.util.Arrays;

public class CountSort {
    /*
    计数排序
    将原始数组中每个元素的值作为计数数组的下标，统计该值出现的个数，作为计数数组中该下标对应的值
    再遍历计数数组，将元素写出
    适合一定范围内的整数排序
     */
    private static void sort(int[] arr){
        if(arr.length<0){
            return;
        }
        int min=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int[] countArr=new int[max-min+1];
        Arrays.fill(countArr,0);
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]-min]++;
        }
        int index=0;
        int i=0;
        while(index<arr.length){
            if(countArr[i]>0){
                arr[index]=i+min;
                countArr[i]--;
                index++;
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={90,43,43,67,82,30,45,73,40,50,39};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
