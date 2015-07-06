import java.util.*;

public class QuickSort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
       
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {
           
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         
        QuickSort sorter = new QuickSort();
        
        Scanner scanner = new Scanner(System.in);

	System.out.println("Enter Elements for Sorting : ");

	int[] input = new int[10];
	int i = 0;

	while(i<10){
	
		input[i] = scanner.nextInt();
		i++;
	}


	System.out.println();
	System.out.print("Entrered Elements : ");
	i = 0;
	while(i<10){

		System.out.print(" "+input[i]);
		i++;
	}
	
	System.out.println();
	System.out.print("Sorted Array : ");
	
	sorter.sort(input);
        for(int j:input){
            System.out.print(j);
            System.out.print(" ");
        }
        
        System.out.println("");
    }
}
