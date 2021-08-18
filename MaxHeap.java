package ex4;
import java.util.Arrays;

/**
 * 
 * @author Asaly Saed Maximum heap class - Data structures course, Ariel
 *         University - 2020.
 */

public class MaxHeap {
	
//	public static void main(String[] args) {
//		MaxHeap h1 = new MaxHeap(7);
//		h1.Add(30);
//		h1.Add(13);
//		h1.Add(20);
//		h1.toString();
//		
//	}
	
	
	int[] arr;
	int last;
	int size;

	public MaxHeap(int size) {
		this.size = size;
		arr = new int[size];
		last = -1;
	}

	public boolean Add(int data) {
		if (last == size - 1)
			return false;
		arr[++last] = data;
		Heapify_Up(last);
		return true;
	}

	private void Heapify_Up(int pos) {
		if (pos == 0)
			return;
		int parent = (int) (Math.floor((pos - 1) / 2));
		if (arr[pos] > arr[parent]) {
			swap(arr, pos, parent);
			Heapify_Up(parent);
		}

	}

	private void swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	public int Delete() {
		if (last != 0) {
			int tmp = arr[0];
			swap(arr, 0, last--);
			Heapify_down(0);
			return tmp;
		} else if (last == 0) {
			int tmp = arr[0];
			last = -1;
			return tmp;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	private void Heapify_down(int pos) {
		int left, right;
		left = 2 * pos + 1;
		right = 2 * pos + 2;
		if ((left == last) && ((arr[pos] < arr[left]))) {
			swap(arr, pos, left);
			return;
		}
		if ((right == last) && (arr[right] > arr[left]) && (arr[pos] < arr[right])) {
			swap(arr, pos, right);
			return;
		} else if ((right == last) && (arr[right] < arr[left]) && (arr[pos] < arr[left])) {
			swap(arr, pos, left);
			return;
		}
		if (left >= last || right >= last) {
			return;
		}
		if ((arr[left] > arr[right]) && (arr[pos] <= arr[left])) {
			swap(arr, pos, left);
			Heapify_down(left);
		} else if (arr[pos] < arr[right]) {
			swap(arr, pos, right);
			Heapify_down(right);
		}
	}

	public static void HeapSort(int[] arr) {
		MaxHeap h = new MaxHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			h.Add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			h.Delete();
			System.out.println(Arrays.toString(h.arr));
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = h.arr[i];
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * QUESTION 1.2
	 * this method merge two max heaps to one, using merge sort for the merge of 
	 * the arrays so the Dispersal in the array will be good.
	 * Run the heapify up function on all the internal vertices of the new heap represented
	 * by the merged array.
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static MaxHeap mergeTwoHeaps(MaxHeap h1, MaxHeap h2) {
		
		int n = h1.size+h2.size;
		MaxHeap hres = new MaxHeap(n);		//creating the new heap -> h1 + h2
		
		
		int i = 0, j = 0,p = 0;
		while(i < h1.size && j < h2.size) {
			if(h1.arr[i] >= h2.arr[j]) {
				hres.arr[p] = h1.arr[i];
				p++;
				i++;
			}
			else {									 
				hres.arr[p] = h2.arr[j];
				p++;
				j++;
			}
		}
		while(i < h1.size) {
			hres.arr[p] = h1.arr[i];
			p++;
			i++;
		}
		while(j < h2.size) {
			hres.arr[p] = h2.arr[j];
			p++;
			j++;
		}
		
		for(int k = (int)hres.size-1; k >= 0; k--) {
			hres.Heapify_Up(k);
		}
		return hres;
	}

	
	/////QUESTION 1.3
	/**
	 * 	this method receive a MAX heap and return a Min heap from the same elements.
	 * it using heapify up for minimum heaps.
	 * 
	 * @param h
	 * @return
	 */
	public static int[] getMinHeap(MaxHeap h) {
		
		for(int i = h.size-1;i>=0;i--) {
			h.Heapify_Up_Min(i);
		}
		return h.arr;
	}
	//////////////////////////////////////////////////////////////////////////////////////////


	
	///auxiliary method
	private void Heapify_Up_Min(int pos) {
		if (pos == 0)
			return;
		int parent = (int) (Math.floor((pos - 1) / 2));
		if (arr[pos] < arr[parent]) {
			swap(arr, pos, parent);
			Heapify_Up_Min(parent);
		}

	}
}




















