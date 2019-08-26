package sort;

import java.util.Arrays;

public class ShellInsert {
    /*
    对待排序序列进行多次分组，
    每次分组后，每个组内进行插入排序，
    组数依次减小，为一缩小增量序列（递减，且最后值必须为1）；
    组数为1时，完成排序
    突破O（n^2）的第一批算法
     */
    public static void shellInsert(int[] arr){
        if(arr.length==0){
            return ;
        }
        //当前待排序数据索引
        int j=0;
        //当前待排序数据
        int tmp;
        //缩小增量序列，进行多次分组
        for(int gap=arr.length/2;gap>0;gap/=2) {
            //从gap开始，前gap个数据做为已排序序列
            for (int i = gap; i<arr.length;i++ ) {
                tmp = arr[i];
                //分组进行插入排序
                for (j = i; j >=gap && tmp > arr[j - gap]; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={243,47,32,243,374,84,901,25,25,73,30,93,67};
        shellInsert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
