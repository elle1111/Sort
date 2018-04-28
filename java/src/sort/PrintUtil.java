package sort;

public class PrintUtil {
    public static void printArray(int[] array){
        System.out.printf("数组为：");
        for(int i = 0;i < array.length;i++){
            System.out.printf("%d ",array[i]);
        }
        System.out.printf("\n");
    }
}
