package sort;

import java.util.Arrays;

public class Maopao{
    public static void main(String[] args){
    int[] array=new int[]{1,5,3,46,32,5};
    int[] array1=Main.createRandomArray(10000);
    int[] array2= Arrays.copyOf(array1,10000);
    int[] array3=Arrays.copyOf(array,6);
    Maopao  maopaoSort=new Maopao();
    //System.out.println("排序前的数组为：");
    //PrintUtil.printArray(array1);
    long start1=System.currentTimeMillis();
    maopaoSort.sort(array1);
    long end1=System.currentTimeMillis();
    System.out.println("冒泡排序时间为："+(end1-start1));
    long start2=System.currentTimeMillis();
    Arrays.sort(array2);
    long end2=System.currentTimeMillis();
    System.out.println("系统排序时间为"+(end2-start2));
    System.out.println(ArrayUtil.isTwoArrayEqual(array1,array2));
    //System.out.println("排序后的数组为：");
    //PrintUtil.printArray(array2);
    }
    public void sort(int[] array){
        int temp;
        for(int lastUnsortedIndex=array.length-1;lastUnsortedIndex>=0;lastUnsortedIndex--){
            for(int j=0;j<lastUnsortedIndex;j++){
               if(array[j]>array[j+1]){
                   //PrintUtil.printArray(array);
                   temp=array[j];
                   //System.out.println(tmp);
                   array[j]=array[j+1];
                   array[j+1]=temp;
                }
            }
        }
    }
}