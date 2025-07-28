package problems;

/**
 * Problem_20
 *
 * Finds the length of the longest even‐length “symmetric” substring in which: -
 * Every '<' on the left side matches a '>' on the right side. - The wildcard
 * '?' can act as either '<' or '>', as needed.
 *
 * For example, in "<><??>>", the longest match is "?<?>", of length 4.
 *
 * Time Complexity: O(n) — three linear scans of the string Space Complexity:
 * O(n) — two auxiliary arrays of size n
 */
public class Problem_20 {

	/**
	 * Computes the length of the longest even‐length symmetric substring.
	 *
	 * @param s input string containing only '<', '>', and '?'
	 * @return the maximum length of a substring centered between two characters
	 *         such that the left half consists of '<'/'?' and the right half
	 *         consists of '>'/'?' and they mirror each other
	 */
	public static int longestSymmetricSubstring(String s) {
		int n = s.length();

		// right[i] = how many consecutive '>' or '?' we can take starting at i
		int[] right = new int[n];
		// Build right[] in one backward pass:
		// If s[i] is '>' or '?', then right[i] = 1 + right[i+1] (if in bounds),
		// else 0.
		for (int i = n - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == '>' || ch == '?') {
				right[i] = 1 + (i + 1 < n ? right[i + 1] : 0);
			} else {
				right[i] = 0;
			}
		}

		// left[i] = how many consecutive '<' or '?' we can take ending at i
		int[] left = new int[n];
		// Build left[] in one forward pass:
		// If s[i] is '<' or '?', then left[i] = 1 + left[i-1] (if in bounds),
		// else 0.
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '<' || ch == '?') {
				left[i] = 1 + (i - 1 >= 0 ? left[i - 1] : 0);
			} else {
				left[i] = 0;
			}
		}

		// Now consider every “split point” between characters i and i+1.
		// We can form an even‐length substring of size 2*k if:
		// • the left side (ending at i) can supply k chars: left[i] >= k
		// • the right side (starting at i+1) can supply k chars: right[i+1] >= k
		// Thus k = min(left[i], right[i+1]), and length = 2*k.
		//
		// We scan all i from 0 to n-2 and track the maximum length.
		int maxLen = 0;
		for (int i = 0; i < n - 1; i++) {
			int k = Math.min(left[i], right[i + 1]);
			maxLen = Math.max(maxLen, k * 2);
		}
		// it can be either way
//		for (int i = 1; i < n ; i++) {
//			int k = Math.min(left[i - 1], right[i]);
//			maxLen = Math.max(maxLen, k * 2);
//		}

		return maxLen;
	}

	public static void main(String[] args) {
		// Test cases and expected results:
		// "<><??>>" → 4 (matches "?<?>")
		// "??????" → 6 (all '?' can match symmetrically)
		// "<<?" → 2 (matches "<?")
		System.out.println(longestSymmetricSubstring("<><??>>")); // 4
		System.out.println(longestSymmetricSubstring("??????")); // 6
		System.out.println(longestSymmetricSubstring("<<?")); // 2
	}

	// ----------------------------------------
	// Complexity Analysis (for interview):
	//
	// 1. Building the `right[]` array:
	// - One backward loop over n characters → O(n) time.
	// - Uses O(n) extra space.
	//
	// 2. Building the `left[]` array:
	// - One forward loop over n characters → O(n) time.
	// - Uses O(n) extra space.
	//
	// 3. Scanning for the best “split”:
	// - One more loop over (n-1) positions → O(n) time.
	//
	// Overall: O(n) time and O(n) auxiliary space.
	//
	// This approach is simple to implement and avoids nested loops over
	// every potential center, yet still runs in linear time by precomputing
	// how many characters of each type can extend from every index.
}
