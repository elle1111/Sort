package sort;

import java.util.Arrays;

public class CompareMain {
    public static void main(String[] args){
        int length=100000;
        int[] array=Main.createRandomArray(length);
        int[] arrayInsert= Arrays.copyOf(array,length);
        int[] arrayChoose=Arrays.copyOf(array,length);
        int[] arrayBubble=Arrays.copyOf(array,length);
        int[] arrayMerge=Arrays.copyOf(array,length);
        int[] arrayQuick=Arrays.copyOf(array,length);
        int[] arrayHeap=Arrays.copyOf(array,length);
        int[] arrayBlank=new int[length];
        HeapSort heapsort = new HeapSort();
        long heapStart = System.currentTimeMillis();
        heapsort.heapSort(arrayHeap);
        long heapEnd=System.currentTimeMillis();
        System.out.println("Heap sort time:"+(heapEnd-heapStart));
        InsertSort insertSort=new InsertSort();
        long insertStart=System.currentTimeMillis();
        insertSort.sort(arrayInsert);
        long insertEnd=System.currentTimeMillis();
        System.out.println("Insert sort time:"+(insertEnd-insertStart));
        Choose chooseSort=new Choose();
        long chooseStart=System.currentTimeMillis();
        chooseSort.chooseSort(arrayChoose);
        long chooseEnd=System.currentTimeMillis();
        System.out.println("choose sort time:"+(chooseEnd-chooseStart));
        Maopao bubbleSort=new Maopao();
        long bubbleStart=System.currentTimeMillis();
        bubbleSort.sort(arrayBubble);
        long bubbleEnd=System.currentTimeMillis();
        System.out.println("bubble sort time:"+(bubbleEnd-bubbleStart));
        MergeSort mergeSort=new MergeSort();
        long mergeStart=System.currentTimeMillis();
        mergeSort.sort(arrayMerge,0,arrayMerge.length,arrayBlank);
        long mergeEnd=System.currentTimeMillis();
        System.out.println("merge sort time:"+(mergeEnd-mergeStart));
        QuickSort quickSort=new QuickSort();
        long quickStart=System.currentTimeMillis();
        quickSort.sort(arrayQuick,0,arrayQuick.length-1);
        long quickEnd=System.currentTimeMillis();
        System.out.println("quick sort time:"+(quickEnd-quickStart));
    }
}
