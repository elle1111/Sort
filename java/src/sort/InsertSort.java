package sort;

import sort.Configure;
import sort.PrintUtil;

public class InsertSort {
    /**
     * 把数组从小到大排序
     * @param array
     */
    public static void sort(int[] array){
        for(int i = 2;i <= array.length;i++){
            //查看待插入的数
            if(Configure.IS_LOG_DEBUG){
            System.out.printf("第%d个数为%d\n",i,array[i-1]);}
            //准备一个新的空间
            int key=array[i-1];
            //和前面的数一一比较
            int j=i-2;
            if(Configure.IS_LOG_DEBUG){
            PrintUtil.printArray(array);}
            //如果前面的数更大则后移
            //前面的数向后移动一个单位
            while(j >= 0 && array[j] > key){
                //数组前面的数后移一个单位
                array[j+1] = array[j];
                if(Configure.IS_LOG_DEBUG){
                System.out.printf("把第%d个数向后移动一位后为",j+1);
                PrintUtil.printArray(array);}
                //继续向前移动
                j--;
            }
            if (Configure.IS_LOG_DEBUG) {
                PrintUtil.printArray(array);
            }
            //在此处插入数
            array[j+1] = key;
            if(Configure.IS_LOG_DEBUG){
            PrintUtil.printArray(array);}

 }

    }

}
