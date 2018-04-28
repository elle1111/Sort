package sort;

public class ArrayUtil {
    public static boolean isTwoArrayEqual(int[] array1,int[] array2){
        for(int i=0;i<array1.length;i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }
}
