import java.util.*;

class quicksort{
	public static void main(String[] args){

	}
	public static void quicksort(int[] input, int front, int end){
		if(front>=end) return;
		int pivot = partition(input,front,end);
		quicksort(input,front,pivot);
		quicksort(input,pivot+1,end);
	}
	public int partition(int[] input, int front, int end){
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
	public void swap(int[] input, int s, int l){
		int temp = input[s];
		input[s] = input[l];
		input[l] = temp;
	}
}