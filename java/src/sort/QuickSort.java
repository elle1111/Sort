package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,6,2,5,4};
        int[] array3=Main.createRandomArray(5);
        int[] array1=Main.createRandomArray(100000);
        int[] array2= Arrays.copyOf(array1,100000);
        long start2=System.currentTimeMillis();
        Arrays.sort(array2);
        long end2=System.currentTimeMillis();
        System.out.println("系统排序时间为："+(end2-start2));
        QuickSort quick = new QuickSort();
        long start1=System.currentTimeMillis();
        quick.sort(array1, 0, array1.length );
        long end1=System.currentTimeMillis();
        System.out.println("快速排序时间为："+(end1-start1));
        //PrintUtil.printArray(array3);
        System.out.println(ArrayUtil.isTwoArrayEqual(array1,array2));
    }

    public void sort(int[] array, int leftInclusive, int rightExclusive) {
        //left包含，right不包含
        int length=rightExclusive-leftInclusive;
        if(length<=1) {
            return;
        }
        if(length==2){
            if(array[rightExclusive-1]<array[leftInclusive]){
                int tmp;
                tmp=array[rightExclusive-1];
                array[rightExclusive-1]=array[leftInclusive];
                array[leftInclusive]=tmp;
                return;
            }
            else return;
        }
        int pivotPosition = partition(array, leftInclusive, rightExclusive);
        //System.out.println("left:"+leftInclusive);
        //System.out.println("pivot:"+pivotPosition);
        //System.out.println("right:"+rightExclusive);
        //PrintUtil.printArray(array);
        sort(array, leftInclusive, pivotPosition);
        sort(array, pivotPosition+1, rightExclusive);
    }

    public int partition(int[] array, int leftInclusive, int rightExclusive) {
        /*
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i = i + 1;
                int tmp;
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
        int tmp1;
        tmp1 = array[i + 1];
        array[right] = array[i + 1];
        array[i + 1] = tmp1;
        return i+1;
        */
        //int pivot=array[0];
        int tmp;
        int j=leftInclusive;
        int flag;
        for(int i=leftInclusive+1;i<rightExclusive;i++){
            if(array[i]<array[j]){
                tmp=array[i];
                flag=i;
                for(;i>j;i--) {
                    array[i] = array[i-1];
                }
                i=flag;
                array[j]=tmp;
                j=j+1;
                }
            }
            return j;
        }

        /*
        int tmp;
        for(int j=0;j<=right-left;j++){
            if(array[j]<array[0]) {
                tmp = array[j];
                for (int i = 0; i < j; i++) {
                    array[i] = array[i + 1];
                }
                array[j+1] = tmp;
            }
        }
        return j+1;
    }
    */
}

