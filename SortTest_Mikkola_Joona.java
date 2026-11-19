import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortTest_Mikkola_Joona {



    static void merge(int arr[], int left, int mid1, int mid2, int right) {
        
        // Sizes of three subarrays
        int size1 = mid1 - left + 1;
        int size2 = mid2 - mid1;
        int size3 = right - mid2;
        
        // Temporary arrays for three parts
        int[] leftArr = new int[size1];
        int[] midArr = new int[size2];
        int[] rightArr = new int[size3];
        
        // Copy data to temporary arrays
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < size2; i++) {
            midArr[i] = arr[mid1 + 1 + i];
        }
        for (int i = 0; i < size3; i++) {
            rightArr[i] = arr[mid2 + 1 + i];
        }
        
        // Merge three sorted subarrays
        int i = 0, j = 0, k = 0, index = left;
        while (i < size1 || j < size2 || k < size3) {
            int minValue = Integer.MAX_VALUE, minIdx = -1;
            
            // Find the smallest among the three current elements
            if (i < size1 && leftArr[i] < minValue) {
                minValue = leftArr[i];
                minIdx = 0;
            }
            if (j < size2 && midArr[j] < minValue) {
                minValue = midArr[j];
                minIdx = 1;
            }
            if (k < size3 && rightArr[k] < minValue) {
                minValue = rightArr[k];
                minIdx = 2;
            }
            
            // Place the smallest element in the merged array
            if (minIdx == 0) {
                arr[index++] = leftArr[i++];
            } else if (minIdx == 1) {
                arr[index++] = midArr[j++];
            } else {
                arr[index++] = rightArr[k++];
            }
        }
    }
    
    static void threeWayMergeSort(int arr[], int left, int right) {
        
        // Base case: If single element, return
        if (left >= right) {
            return;
        }
        
        // Finding two midpoints for 3-way split
        int mid1 = left + (right - left) / 3;
        int mid2 = left + 2 * (right - left) / 3;
        
        // Recursively sort first third
        threeWayMergeSort(arr, left, mid1);
        
        // Recursively sort second third
        threeWayMergeSort(arr, mid1 + 1, mid2);
        
        // Recursively sort last third
        threeWayMergeSort(arr, mid2 + 1, right);
        
        // Merge the sorted parts
        merge(arr, left, mid1, mid2, right);
    }
    


    // partition function (PITI OPTIMOIDA KOSKA KAATUI NOUSEVASSA/LASKEVASSA JÄRJESTYKSESSÄ)
    static int partition(int[] arr, int low, int high)
    {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);

        swap (arr, randomIndex, high);
        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void printData(int[] data) {
        for (int x : data) System.out.print(x + " ");
        System.out.println("--------------------------");
        System.out.println();
    }

    public static int[] createAscendingData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) data[i] = i;
        return data;
    }

    public static int[] createRandomData(int n) {
        int[] data = new int[n];
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) data[i] = gen.nextInt(n);
        return data;
    }

    public static int[] CreateDescendingdata(int n) {
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) data[i] = (n - 1) - i;
        return data;
    }

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
    }

    public static void sekoitaTaulukko(int[] taulukko) {
        Random rand = new Random();
        for (int i = taulukko.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = taulukko[i];
            taulukko[i] = taulukko[j];
            taulukko[j] = temp;
        }
    }
    
    public static void modulaarisempi(String nimi, int[] data, Consumer<int[]> lajittelualgoritmi)

    {
        int[] kopio = data.clone();
        
        long start = System.nanoTime();
        lajittelualgoritmi.accept(kopio);
        long stop = System.nanoTime();
        
        System.out.println(nimi + ": " + (stop - start) / 1e9 + " s");
    }
    
    public static void main(String[] args) {
        int size = 100000;

        int[] random = createRandomData(size);
        int[] ascending = createAscendingData(size);
        int[] descending = CreateDescendingdata(size);


        modulaarisempi("Insertion sort (random)", random, SortTest::insertionSort);
        modulaarisempi("bubble sort (random)", random, SortTest::bubbleSort);
        modulaarisempi("Array sort (random)", random, Arrays::sort);
        modulaarisempi("Shell sort (random)", random, SortTest::shellSort);
        modulaarisempi("Quick sort (random)", random, arr -> quickSort(arr, 0, arr.length - 1));
        modulaarisempi("Merge sort (random)", random, arr -> threeWayMergeSort(arr, 0, arr.length - 1));

        modulaarisempi("Insertion sort (ascending)", ascending, SortTest::insertionSort);
        modulaarisempi("bubble sort (ascending)", ascending, SortTest::bubbleSort);
        modulaarisempi("Array sort (ascending)", ascending, Arrays::sort);
        modulaarisempi("Shell sort (ascending)", ascending, SortTest::shellSort);
        modulaarisempi("Quick sort (ascending)", ascending, arr -> quickSort(arr, 0, arr.length - 1));
        modulaarisempi("Merge sort (ascending)", ascending, arr -> threeWayMergeSort(arr, 0, arr.length - 1));

        modulaarisempi("Insertion sort (descending)", descending, SortTest::insertionSort);
        modulaarisempi("bubble sort (descending)", descending, SortTest::bubbleSort);
        modulaarisempi("Array sort (descending)", descending, Arrays::sort);
        modulaarisempi("Shell sort (descending)", descending, SortTest::shellSort);
        modulaarisempi("Quick sort (descending)", descending, arr -> quickSort(arr, 0, arr.length - 1));
        modulaarisempi("Merge sort (descending)", descending, arr -> threeWayMergeSort(arr, 0, arr.length - 1));
    }
}