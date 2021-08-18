package ex4;
import java.awt.color.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;




public class Main {

	

		public static void main (String[] args) {
			
		}
		
		



	////////////////////////////////////////////////////////
	
	
//	public static List<int[]> triples(int[] a, int target) {
//		int n = a.length;
//		for(int i = 0; i<n;i++) {
//			int sum = target - a[i];
//			int[] arr = Arrays.copyOf(pairs2(a,sum,i), 3);
//			if(arr.length == 2) {
//				int[] ret2 = {arr[0],arr[1],i};
//				
//			}
//		}
//		return false;
//	}
//	
//	public static int[] pairs2(int[] a, int s, int l) {
//		
//		int low = l, high = a.length-1;
//		
//		while(low<high) {
//			if(a[low] + a[high] == s) {
//				int[] ret1 = {low, high};
//				return ret1;
//			}
//			else if(a[low] + a[high] > s)
//				high--;
//			else
//				low++;
//		}
//		int[] ret0 = {};
//		return ret0;
//	}
	
	
	
	
	
	public static List<int[]> threeSum(int[] arr, int target){
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

	private static List<int[]> removeDuplicates(List<int[]> list) {
			
		
	  
	        // Create a new LinkedHashSet
	        Set<int[]> set = new LinkedHashSet<int[]>();
	  
	        // Add the elements to set
	        set.addAll(list);
	  
	        // Clear the list
	        list.clear();
	  
	        // add the elements of set
	        // with no duplicates to the list
	        list.addAll(set);
	  
	        // return the list
	        return list;
	    
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
