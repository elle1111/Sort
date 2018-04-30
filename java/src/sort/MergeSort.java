package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        //for(int i=0;i<100;i++){
        int[] array=new int[]{3,1,2,5,4};
        int[] arrayRandom=Main.createRandomArray(100000);
        int[] arrayRandomCopy=Arrays.copyOf(arrayRandom,100000);
        //PrintUtil.printArray(arrayRandom);
        int[] arrayNew=new int[100000];
        long start1=System.currentTimeMillis();
        Arrays.sort(arrayRandomCopy);
        long end1=System.currentTimeMillis();
        System.out.println("系统排序时间为："+(end1-start1));
        MergeSort mergeSort=new MergeSort();
        //int flag=0;
        long start2=System.currentTimeMillis();
        mergeSort.sort(arrayRandom,0,arrayRandom.length,arrayNew);
        //mergeSort.sort(array,0,array.length,arrayNew);
        long end2=System.currentTimeMillis();
        System.out.println("归并排序时间为："+(end2-start2));
        //PrintUtil.printArray(array);
        System.out.println(ArrayUtil.isTwoArrayEqual(arrayRandom,arrayRandomCopy));
    }
//}
    public void sort(int[] array,int left,int right,int[] arrayNew){
        //System.out.println("最右边的元素下标为："+right);
        //System.out.println("最左边的元素下标为："+left);

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


        sort(array,left,middle,arrayNew);
        //int[] array1= Arrays.copyOfRange(array,left,middle);
        //System.out.println("左边");
        //PrintUtil.printArray(array);
        //System.out.println("Programmming is bug.");

        sort(array,middle,right,arrayNew);
        //int[] array2=Arrays.copyOfRange(array,middle,right);
        //System.out.println("右边");
        //PrintUtil.printArray(array);
        //int[] array3;
        //array3= merge(array1,array2);
        merge(array,left,middle,right,arrayNew);
        //System.out.println("合并");

        int q=left;
        //PrintUtil.printArray(array);
        //
        //
        for(int i=left;i<right;i++){
           array[q]=arrayNew[i];
           q++;
        }
        //PrintUtil.printArray(arrayNew);
        //PrintUtil.printArray(array);
    }
    public int[] merge(int[] array,int left,int middle,int right,int[] arrayNew){
        //array1,array2是待传入排序的数组，array3是排序后的数组
        int i=0;
        int j=0;
        for(int q=0;q<right-left;q++){
            if((i<middle-left)&&(j<right-middle))
            {
                if(array[left+i]>array[middle+j]){
                    arrayNew[left+q]=array[middle+j];
                    j++;
                }
                else{
                    arrayNew[left+q]=array[left+i];
                    i++;
                }
            }
            else if(i==middle-left){
                arrayNew[left+q]=array[middle+j];
                j++;
            }
            else if(j==right-middle){
                arrayNew[left+q]=array[left+i];
                i++;
            }

        }

/*
        int i=middle-left;
        int j=right-middle;
        //int[] array=new int[i+j];
            for(int q=0;q<right-left;q++) {
                //如果两个数组长度均大于0
                if(i>0&&j>0){
                    //如果右边数组的元素小于左边数组的元素
                    if(array[middle-left+1-i]>array[right-left+1-j]){
                        //将右边数组的元素赋值给array
                        arrayNew[right-left-1+q]=array[right+1-left-j];
                        j--;
                        //System.out.println(j);
                        //比较的元素向后移动一位
                    }
                    else{
                        //否则，将左边数组的元素赋值给array
                        arrayNew[right-left-1+q]=array[middle+1-left-i];
                        i--;
                        //System.out.println(i);
                        //比较的元素向后移动一位
                    }
                }
            else if(i==0){
                    arrayNew[right-left-1+q]=array[right-left+1-j];
                    j--;
                    }
                    else{
                    arrayNew[right-left-1+q]=array[middle+1-left-i];
                    i--;
                }

            }
            */
            //PrintUtil.printArray(arrayNew);
            //PrintUtil.printArray(arrayRight);
            //PrintUtil.printArray(array);
            return arrayNew;
    }
}
