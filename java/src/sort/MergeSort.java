package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        //for(int i=0;i<100;i++){
        int[] array=new int[]{3,1,2,4,6};
        int[] arrayRandom=Main.createRandomArray(1000000);
        int[] arrayRandomCopy=Arrays.copyOf(arrayRandom,1000000);
        //PrintUtil.printArray(arrayRandom);
        long start1=System.currentTimeMillis();
        Arrays.sort(arrayRandomCopy);
        long end1=System.currentTimeMillis();
        System.out.println("系统排序时间为："+(end1-start1));
        MergeSort mergeSort=new MergeSort();
        int flag=0;
        long start2=System.currentTimeMillis();
        mergeSort.sort(arrayRandom,0,arrayRandom.length,flag);
        long end2=System.currentTimeMillis();
        System.out.println("归并排序时间为："+(end2-start2));
        //PrintUtil.printArray(array);
        System.out.println(ArrayUtil.isTwoArrayEqual(arrayRandom,arrayRandomCopy));
    }
//}
    public void sort(int[] array,int left,int right,int flag){
        //System.out.println("最右边的元素下标为："+right);
        //System.out.println("最左边的元素下标为："+left);
        flag++;
        //System.out.println("第次排序："+flag);
        //包含left,不包含right
        if((right-left)==1) return;

        int middle=(right+left)/2;
        //System.out.println(middle);
        //System.out.println("数组左边的下标为："+left);
        //System.out.println("数组右边的下标为："+right);
        //System.out.println("数组中间的下标为："+middle);
        //PrintUtil.printArray(array);
       // System.out.println("Programmming is bug.");


        sort(array,left,middle,flag);
        int[] array1= Arrays.copyOfRange(array,left,middle);
        //System.out.println("左边");
        //PrintUtil.printArray(array1);
        //System.out.println("Programmming is bug.");

        sort(array,middle,right,flag);
        int[] array2=Arrays.copyOfRange(array,middle,right);
        //System.out.println("右边");
        //PrintUtil.printArray(array2);
        int[] array3;
        array3= merge(array1,array2);
        //System.out.println("合并");
        int q=left;
        //PrintUtil.printArray(array3);
        for(int i=0;i<array3.length;i++){
           array[q]=array3[i];
           q++;
        }
        //PrintUtil.printArray(array);
    }
    public int[] merge(int[] arrayLeft,int[] arrayRight){
        //array1,array2是待传入排序的数组，array3是排序后的数组
        int i=arrayLeft.length;
        int j=arrayRight.length;
        int[] array=new int[i+j];
            for(int q=0;q<arrayLeft.length+arrayRight.length;q++) {
                //如果两个数组长度均大于0
                if(i>0&&j>0){
                    //如果右边数组的元素小于左边数组的元素
                    if(arrayLeft[arrayLeft.length-i]>arrayRight[arrayRight.length-j]){
                        //将右边数组的元素赋值给array
                        array[q]=arrayRight[arrayRight.length-j];
                        j--;
                        //System.out.println(j);
                        //比较的元素向后移动一位
                    }
                    else{
                        //否则，将左边数组的元素赋值给array
                        array[q]=arrayLeft[arrayLeft.length-i];
                        i--;
                        //System.out.println(i);
                        //比较的元素向后移动一位
                    }
                }
            else if(i==0){
                    array[q]=arrayRight[arrayRight.length-j];
                    j--;
                    }
                    else{
                    array[q]=arrayLeft[arrayLeft.length-i];
                    i--;
                }

            }
            //PrintUtil.printArray(arrayLeft);
            //PrintUtil.printArray(arrayRight);
            //PrintUtil.printArray(array);
            return array;
    }
}
