/**
  * Collection of sorting algorithms for use in HW07 - Silicon Valley
  * @version 1.0
  * @author iwebb6
  */
@SuppressWarnings("unchecked")
public class Sorting {
    /**
      * Sorts an array of Comparables using an insertion sort method.
      *
      * @param tenXers The array of Comparables to sort
      */
    public static void insertionSort(Comparable[] tenXers) {
        for (int i = 2; i < tenXers.length; i++) {
            Comparable key = tenXers[i];
            int j = i - 1;
            while (j > 0 && tenXers[j].compareTo(key) > 0) {
                tenXers[j + 1] = tenXers[j];
                j--;
            }
            tenXers[j + 1] = key;
        }
    }

    /**
      * Sorts an array of Comparables using a merge sort method.
      *
      * @param arr The array of Comparables to sort
      */
    public static void mergeSort(Comparable[] arr) {
        mergeSort(arr, new Comparable[arr.length], 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] temp,
                                  int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] temp,
                              int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            temp[k] = arr[k];
        }
        int lo = low;
        int hi = mid + 1;
        for (int k = low; k <= high; k++) {
            if (lo > mid) {
                arr[k] = temp[hi++];
            } else if (hi > high) {
                arr[k] = temp[lo++];
            } else if (temp[lo].compareTo(temp[hi]) <= 0) {
                arr[k] = temp[lo++];
            } else {
                arr[k] = temp[hi++];
            }
        }
    }
}
