import java.util.Arrays;

/**
 * Created by allen on 16/7/19.
 */
public class MySort {
    public static void main(String[] args) {
        MySort sort = new MySort();
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        System.out.println(Arrays.toString(nums));
//        sort.fastSort(nums, 0, nums.length - 1);
//        sort.quick_sort(nums, 0, nums.length - 1);
//        sort.bubbleSort(nums);
        sort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void fastSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int tmp = arr[begin];
            int left = begin;
            int right = end;
            while (left < right) {
                while (left < right && arr[right] > tmp) {
                    right--;
                }
                if (left < right) {
                    arr[left++] = arr[right];
                }

                while (left < right && arr[left] < tmp) {
                    left++;
                }
                if (left < right) {
                    arr[right--] = arr[left];
                }
            }
            arr[left] = tmp;
//            System.out.println(Arrays.toString(arr));

            fastSort(arr, begin, left - 1);
            fastSort(arr, left + 1, end);
        }
    }

    public void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void heapSort(int[] arr) {
        buildHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeap(arr, i, 0);
        }
    }

    public void buildHeap(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }

    }

    public void maxHeap(int[] arr, int length, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            int tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            maxHeap(arr, length, largest);
        }

    }
}
