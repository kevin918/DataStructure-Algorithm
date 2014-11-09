import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Untitled {
	public static void main(String[] args) {
		int[] arr= {2,3,1,1,4};
		//System.out.println(getShortestJumps(arr));
		System.out.println(minJump(arr));
		//System.out.println(min_DP(arr));
	}
	
	public static int minjumps(int[] arr, int source, int desti){
		if (source == desti) {
			return 0;
		}
		if(arr[source]==0) return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for (int i = source+1; i <= desti && i<= source + arr[source]; i++) {
			int jumps = minjumps(arr, i, desti);
			if(jumps!= Integer.MAX_VALUE && jumps+1<min){
				min = jumps+1;
			}
		}
		return min;
	}
	
	public static int minJump (int[] arr){
		int count =0;
		for (int i = 0; i+arr[i] < arr.length; i+=arr[i]) {
			++count;
		}
		return count;
	}
}