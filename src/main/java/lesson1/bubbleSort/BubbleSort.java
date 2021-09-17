package lesson1.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    int[] array = {10, 5, 7, 15, 3, 25, 2};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.array));
        bubbleSort.buubleSort();
        System.out.println(Arrays.toString(bubbleSort.array));

    }

    public void buubleSort (){
        for (int i = 0; i < array.length-1; i++){
            for (int j = array.length-1; j > i; j--){
                if (array[j-1] > array[j]){
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
