package problems;

// LC – 2384. Largest Palindromic Number
public class Problem_15 {

	public String largestPalindromic(String num) {
		int[] freq = new int[10]; // freq[d] will count how many times digit d appears
		for (char c : num.toCharArray()) { // for each character in the input string
			freq[c - '0']++; // increment the count for that digit
		}

		StringBuilder left = new StringBuilder(); // we'll build the left half of the palindrome here
		for (int d = 9; d >= 0; d--) { // consider digits from 9 down to 0
			int pairs = freq[d] / 2; // how many full pairs of this digit we can use
			for (int j = 0; j < pairs; j++) { // append the digit once per pair
				left.append((char) ('0' + d)); // e.g. if d=7, append '7' once per pair
			}
			freq[d] -= pairs * 2; // remove the used digits from the frequency
		}

		String center = ""; // will hold the single middle digit, if any
		for (int d = 9; d >= 0; d--) { // scan from 9 down to 0 to maximize the center
			if (freq[d] > 0) { // if there’s at least one leftover of this digit
				center = String.valueOf((char) ('0' + d)); // pick it as the center
				break; // and stop—only one center digit allowed
			}
		}

		String right = left.reverse().toString(); // mirror the left half to become the right half
		left.reverse(); // reverse back `left` so it remains intact if needed

		String result = left.toString() + center + right; // assemble full palindrome

		// if the result has more than one digit but starts with '0',
		// that means all our pairs were zeros (or no nonzero pair at front),
		// so the only valid answer is just the center (or "0" if no center).
		if (result.length() > 1 && result.charAt(0) == '0') {
			return center.isEmpty() ? "0" : center; // return the nonzero center, or "0" if none
		}

		return result; // otherwise, return the full palindrome
	}

}
