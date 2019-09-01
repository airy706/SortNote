package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    /*
    假设原始数据服从个均匀分布，利用某种映射关系将数据分到有限数量的桶里，在对每个桶进行排序。
     */
    private static ArrayList<Integer> sort(ArrayList<Integer> array,int buckerSize){
        if(array==null||array.size()<2){
            return array;
        }
        int max=array.get(0);
        int min=array.get(0);
        for(int i=0;i<array.size();i++){
            if(min>array.get(i)){
                min=array.get(i);
            }
            if(max<array.get(i)){
                max=array.get(i);
            }
        }
        int bucketCount=(max-min)/buckerSize+1;
        ArrayList<ArrayList<Integer>> bucketArr=new ArrayList<>(bucketCount);
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<bucketCount;i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<array.size();i++){
            bucketArr.get((array.get(i)-min)/buckerSize).add(array.get(i));
        }
        for(int i=0;i<bucketCount;i++){
            if(buckerSize==1){
                for(int j=0;j<bucketArr.get(i).size();j++){
                    result.add(bucketArr.get(i).get(j));
                }

            }else{
                if(bucketCount==1){
                    buckerSize--;
                }
                ArrayList<Integer> tmp=sort(bucketArr.get(i),buckerSize);
                for(int j=0;j<tmp.size();j++){
                    result.add(tmp.get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(9);
        array.add(3);
        array.add(7);
        array.add(4);
        array.add(0);
        array.add(6);
        ArrayList<Integer> de=sort(array,3);
        System.out.println(Arrays.toString(de.toArray()));
    }
}
