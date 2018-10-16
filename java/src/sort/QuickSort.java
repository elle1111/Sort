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
        quick.sort(array1, 0, array1.length-1 );
        long end1=System.currentTimeMillis();
        System.out.println("快速排序时间为："+(end1-start1));
        //PrintUtil.printArray(array3);
        System.out.println(ArrayUtil.isTwoArrayEqual(array1,array2));
    }

    public void sort(int[] array, int leftInclusive, int rightInclusive) {
        //left包含，right不包含
        int length=rightInclusive-leftInclusive+1;
        if(length<=1) {
            return;
        }
        int pivotPosition = partition(array, leftInclusive, rightInclusive);
        //System.out.println("left:"+leftInclusive);
        //System.out.println("pivot:"+pivotPosition);
        //System.out.println("right:"+rightInclusive);
        //PrintUtil.printArray(array);
        sort(array, leftInclusive, pivotPosition-1);
        sort(array, pivotPosition+1, rightInclusive);
    }

    /**
     * 将array[rightInclusive]调整到最终排序所需要在的位置并返回该位置
     * @return array[rightInclusive]调整到最终排序所需要在的位置
     */
    public int partition(int[] array, int leftInclusive, int rightInclusive) {
        int pivot = array[rightInclusive];
        //i是最后一个小于等于pivot的下标
        int i = leftInclusive - 1;
        for (int j = leftInclusive; j < rightInclusive; j++) {
            if (array[j] <= pivot) {
                //记下小于pivot的个数
                i = i + 1;
                //交换A[i]和A[j]
                int tmp;
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
        //交换A[i+1]和pivot
        int tmp1;
        tmp1 = array[i + 1];
        array[i+1] = array[rightInclusive];
        array[rightInclusive] = tmp1;
        return i+1;
        /*
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
            */
        }
}

