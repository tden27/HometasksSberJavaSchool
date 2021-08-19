package lesson1.bubbleSort;

import java.util.Arrays;

public class BinarySearch {
    int[] array = {10, 5, 7, 15, 3, 25, 2};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(Arrays.toString(binarySearch.array));
        System.out.println("Есть ли в массиве число - 5 " + binarySearch.binarySearch(5));
        System.out.println("Есть ли в массиве число - 45 " + binarySearch.binarySearch(45));
    }

    public boolean binarySearch (int elementToSearch){
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == elementToSearch) return true;
            else if (array[middleIndex] < elementToSearch) firstIndex = middleIndex + 1;
            else if (array[middleIndex] > elementToSearch) lastIndex = middleIndex - 1;
        }

        return false;
    }
}
