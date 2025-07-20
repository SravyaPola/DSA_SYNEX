package array;

//WAP(WRITE A PROGRAM) to print all the prime numbers  combination of the given number

//input n=80
//output =
//80=7+73
//80=13+67
//80=19+61
//80=37+43

public class primeNumber {

	public static void main(String[] args) {
		int n = 72;
		int count = 0;
		for (int i = 1; i <= n / 2; i++) {// n/2 -- avoids the duplicate values
			if (isPrime(i) && isPrime(n - i)) {
				count++;
				System.out.println(n + " = " + i + " + " + (n - i));
			}
		}
		if (count == 0) {
			System.out.println("No prime number combination exists");
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {// except 2, all prime numbers are odd
			return false;
		}
		int limit = (int) Math.sqrt(num);
		for (int i = 3; i <= limit; i += 2) {// becaude we dont need to look for 4, 6, 8 .....
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

//The only even prime number is 2
//Sum of two primes to get an odd number is trivial or impossible