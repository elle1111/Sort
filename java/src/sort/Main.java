package sort;

import sort.ArrayUtil;
import sort.Configure;
import sort.InsertSort;
import sort.PrintUtil;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        //int[] array=new int[10];
        //int[] array=new int[]{1,10,8,4,6,7};
        int[] array = createRandomArray(10000);
        int[] array1=Arrays.copyOf(array,10000);
        if(Configure.IS_LOG_DEBUG){System.out.println("排序前的数组为：");
        PrintUtil.printArray(array1);}
        long startTime1=System.currentTimeMillis();
        InsertSort.sort(array1);
        long endTime1=System.currentTimeMillis();
        if(Configure.IS_LOG_DEBUG){
        System.out.println("排序后的数组为：");
        PrintUtil.printArray(array1);}
        System.out.println("插入排序时间："+(endTime1-startTime1)+"ms");
        if(Configure.IS_LOG_DEBUG){
        System.out.printf("系统排序前的数组为:");
        PrintUtil.printArray(array);}
        long startTime=System.currentTimeMillis();
        Arrays.sort(array);
        long endTime=System.currentTimeMillis();
        if(Configure.IS_LOG_DEBUG){
        System.out.printf("系统排序后的结果为：");
        PrintUtil.printArray(array);}
        System.out.println("系统排序时间为:"+(endTime-startTime)+"ms");
        System.out.println(ArrayUtil.isTwoArrayEqual(array,array1));
    }
    public static int[] createRandomArray(int length){
        int[] array = new int[length];
        Random random = new Random();
        for(int i=0;i  < length;i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

}
