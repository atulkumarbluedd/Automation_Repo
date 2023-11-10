package dataStructure;

import java.util.HashSet;

public class longestConsecutiveSequence {

	/*
	 * ALGO Create an empty hash. Insert all array elements to hash. Do following
	 * for every element arr[i] Check if this element is the starting point of a
	 * subsequence. To check this, simply look for arr[i] – 1 in the hash, if not
	 * found, then this is the first element a subsequence. If this element is the
	 * first element, then count the number of elements in the consecutive starting
	 * with this element. Iterate from arr[i] + 1 till the last element that can be
	 * found. If the count is more than the previous longest subsequence found, then
	 * update this.
	 **/

	static int findLongestseq(int arr[], int n) {

		int ans = 0;
		// to remove duplicates in the array by hashset;
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i : arr) {
			h.add(i);
		}
		// check each possible sequence from the start then update optimal length

		for (int i = 0; i < n; ++i) {
			// if current element is the starting element of a sequence

			if (!h.contains(arr[i] - 1)) {
				// Then check for next elements in the sequence
				int j = arr[i];
				while (h.contains(j))
					j++;

				// update optimal length if this length is more

				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;

	}

	public static void main(String args[]) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is " + findLongestseq(arr, n));
	}
}
