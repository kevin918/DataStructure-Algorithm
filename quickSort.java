import java.util.Arrays;
import java.io.*;

class quicksort{
	public static void main(String[] args){
		int[] arr = {2, 3, 1, 7, 5, 6, 20, 8, 4, 9};
		System.out.println((Arrays.toString(findKSamllest(arr,10))));
	}
	public static void quicksorts(int[] input, int front, int end){
		
		if(front>=end) return;
		int pivot = partition(input,front,end);
		quicksorts(input,front,pivot);
		quicksorts(input,pivot+1,end);
	}

	public static int partition(int[] input, int front, int end){
		int pivot = input[front];
		while(front < end){
			while(input[front]<pivot)
				front++;
			while(input[end]>pivot)
				end--;
			swap(input,front,end);
		}
		return front;
	}
	public static void swap(int[] input, int s, int l){
		int temp = input[s];
		input[s] = input[l];
		input[l] = temp;
	}

	public static int[] findK(int[] input, int front, int end, int k){
		if(front>=end) return input;
		int pivot = partition(input,front,end);
		//System.out.println(pivot);
		if(k==pivot){
			return Arrays.copyOfRange(input,0,pivot);
		}
		else {
			if(k<pivot) 
				return findK(input,front,pivot,k); 
			return findK(input,pivot+1,end,k);
		}
	}
	public static int[] findKSamllest(int[] input, int k){
		return findK(input, 0, input.length-1, k);
	}
}