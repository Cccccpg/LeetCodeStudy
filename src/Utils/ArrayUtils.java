package Utils;

public class ArrayUtils {

    public void showArray(Object[] arr){
        for (Object a : arr) {
            System.out.print(a + " ");
        }
    }

    /**
     * 快排
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int left = start, right = end, position = arr[left];
        while (left < right){
            while (left < right && arr[right] >= position){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= position){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = position;
        quickSort(arr, start, left - 1);
        quickSort(arr,left + 1, end);
    }

}
