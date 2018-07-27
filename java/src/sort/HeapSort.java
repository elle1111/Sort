package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args){
        int[] array=new int[]{6,2,5,3,1,10};
        int[] array1=Main.createRandomArray(10000);
        int[] array2= Arrays.copyOf(array1,10000);
        //创建最大堆
        long start1=System.currentTimeMillis();
        HeapSort heapsort=new HeapSort();
        heapsort.heapSort(array1);
        long end1=System.currentTimeMillis();
        System.out.println("堆排序时间为："+(end1-start1));
        long start2=System.currentTimeMillis();
        Arrays.sort(array2);
        long end2=System.currentTimeMillis();
        System.out.println("系统排序时间为："+(end2-start2));
        //PrintUtil.printArray(array1);
       System.out.println(ArrayUtil.isTwoArrayEqual(array1,array2));
    }
    public static void heapSort(int[] array1){
        array1=creatHeap(array1);
        for(int i=array1.length;i>2;i--) {
            //将最大堆的树根放到数组
            array1 = moveMax(array1, i);
            array1 = adjustArray(array1,0 ,i-1);
        }
        if(array1[1]<array1[0]){
            int tmp=array1[0];
            array1[0]=array1[1];
            array1[1]=tmp;
        }
    }
    public static int[] creatHeap(int[] array){
        for(int i=array.length/2-1;i>=0;i--){
            int j=i;
           adjustArray(array,i,array.length);
            i=j;
            }
        //System.out.println("调整之后的堆为：");
        //PrintUtil.printArray(array);
        return array;
    }
    public static int[] moveMax(int[] array,int i){
        int temp=array[0];
        array[0]=array[i-1];
        array[i-1]=temp;
        return array;
    }
    public static boolean compare(int[] array,int max,int min){
       if(array[max]>array[min])
           return true;
       else
           return false;
    }
    public static boolean changeMaximum(int[] array,int max,int min){
        if (array[max]<array[min])
        {
            int temp;
            temp=array[max];
            array[max]=array[min];
            array[min]=temp;
            return true;
        }
        else return false;
    }
    public static int findRoot(int[] array,int i){
        int flag=i;
        if(compare(array,2*i+1,2*i+2)){
            if(compare(array,2*i+1,i))
                if(changeMaximum(array,i,2*i+1))
                    flag=2*i+1;}
        else {if(compare(array,2*i+2,i))
                if(changeMaximum(array,i,2*i+2)){
                    flag=2*i+2;}}
        return flag;
    }
    public static int[] adjustArray(int[] array,int i,int heapLength){
        while((heapLength>2*i+2)&&(array[i]<array[2*i+1]||array[i]<array[2*i+2])) {
            i = findRoot(array, i);
            if (i > heapLength / 2 - 1)
                break;
        }
        if((heapLength==2*i+2)&&(array[i]<array[2*i+1]))
            changeMaximum(array,i,2*i+1);
        //PrintUtil.printArray(array);
        return array;
    }
}
