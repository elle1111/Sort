package sort;

import java.util.Arrays;

public class Choose{
    public static void main(String[] args){
        int[] array=new int[]{1,5,3,45,26};
        int[] array1=Main.createRandomArray(10000);

        int[] array2=Arrays.copyOf(array1,10000);
        Choose sort=new Choose();
        //System.out.println("排序前的数组为：");
        //PrintUtil.printArray(array1);
        long start1=System.currentTimeMillis();
        sort.chooseSort((array1));
        long end1=System.currentTimeMillis();
        System.out.println("选择排序时间为"+(end1-start1));
        long start2=System.currentTimeMillis();
        Arrays.sort(array2);
        long end2=System.currentTimeMillis();
        //System.out.println("排序后的数组为：");
        //PrintUtil.printArray(array1);
        System.out.println("系统排序时间为"+(end2-start2));
        System.out.println(ArrayUtil.isTwoArrayEqual(array1,array2));
    }
    public void chooseSort(int[] array){
        for(int i=0;i<array.length;i++){
            int tmp=array[i];
            int flag=0;
            //System.out.println(tmp);
            for(int j=i+1;j<array.length;j++){
                //System.out.println(array[j]);
                if(array[j]<tmp)
                {  tmp=array[j];
                flag=j;

                array[flag]=array[i];
                array[i]=tmp;}
            }
        }
    }
}