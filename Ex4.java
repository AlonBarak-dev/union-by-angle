package ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Ex4 {
	public static List<int[]> ThreeSum(int[] arr, int target) {
		
			List<int[]> list = new ArrayList<int[]>();
			Arrays.sort(arr);
			for(int i = 0; i< arr.length-2;i++) {
				
	            HashSet<Integer> set = new HashSet<Integer>();
	            int sum = target - arr[i];
	            for(int j = i+1;j<arr.length;j++) {
	            	int sum2 = sum - arr[j];
	            	if(set.contains(sum2) && arr[i] != arr[j] && arr[j] != sum2 && arr[i] != sum2 && !set.contains(arr[j])) {
	            		int[] newArr = {arr[i], sum2 , arr[j]};
	            		if(!list.contains(newArr)) {
	            			list.add(newArr);
	            		}
	            	}
	            	set.add(arr[j]);
	            }

				
			}
			
			
			return list;
		
	}

	public static void main(String[] args) {
		// Update your code below (here you can test you solution)
	}

}
