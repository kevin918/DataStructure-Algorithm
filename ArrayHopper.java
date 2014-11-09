import java.util.ArrayList;


class Untitled {
	public static void main(String[] args) {
		int[] arr = {5,6,0,4,2,4,1,0,0,4};
		ArrayList<Integer> alt = new ArrayList<Integer>();
		alt.add(5);
		alt.add(6);
		alt.add(0);
		alt.add(4);
		alt.add(2);
		alt.add(4);
		alt.add(1);alt.add(0);alt.add(0);alt.add(4);
		
		ArrayList<String> result = findHopsHelper(alt);
		System.out.println(result);
		
	}
	public static ArrayList<String> findHopsHelper(ArrayList<Integer> array) {
			ArrayList<String> hops = new ArrayList<String>();
			int lReach = 0, curReach = 0, selIndex = 0;
			int i;
			for (i = 0; i < array.size(); i++) {
				if (i > curReach) break;    // if the index is beyond current reach then just break out
				if (i > lReach) {
					lReach = curReach;    // update last reach
					hops.add(String.valueOf(selIndex));
				}
				int sum = i + array.get(i);    // update current reach
				if (sum > curReach) selIndex = i;
				curReach = Math.max(curReach, sum);
			}
			if ((i > lReach) && (hops.size() > 0) && (Integer.parseInt(hops.get(hops.size() - 1)) != selIndex)) {
				// if i was beyond last reach and hops are present then add the last selected index
				hops.add(String.valueOf(selIndex));
			}

			if (lReach >= array.size() - 1){ // if last reachable index was greater than or equal to last index of array
				// then return the hop indices as hopping is possible
				hops.add("out");
				return hops;
			}else{
				return null;
			}
		}
}