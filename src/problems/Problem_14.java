package problems;

public class Problem_14 {

	private static String plusMinus(String s) {
		StringBuilder str = new StringBuilder();
		int i = 0;
		int n = s.length();
		while (i < n) {
			// S.startsWith("plus", i) ====== >
			// S.charAt(i + 0) == 'p', S.charAt(i + 1) == 'l', S.charAt(i + 2) ==
			// 'u',S.charAt(i + 3) == 's'.
			if (i + 4 <= n && s.startsWith("plus", i)) {
				str.append("+");
				i = i + 4;
			} else if (i + 5 <= n && s.startsWith("minus", i)) {
				str.append("-");
				i = i + 5;
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(plusMinus("minusplusminus"));
		System.out.println(plusMinus("plusminusminusplus"));
		System.out.println(plusMinus("plusplusminusminus"));
		System.out.println(plusMinus("minusminusplus"));
	}
}
