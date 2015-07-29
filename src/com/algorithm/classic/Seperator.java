package com.algorithm.classic;

public class Seperator {

	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] primeArray(int max) {
		int[] tmp = new int[max];
		int count = 0;
		for (int i = 2; i <= max; i++) {
			if (isPrime(i)) {
				tmp[count++] = i;
			}
		}
		int[] arr = new int[count];
		System.arraycopy(tmp, 0, arr, 0, count);
		return arr;
	}
	
	public static int[] split(int number) {
		int[] primes = primeArray(number);
		int[] splits = new int[primes.length];
		int count = 0;
		int i = 0;
		while (i < primes.length) {
			if (number % primes[i] == 0 && number != primes[i]) {
				splits[count++] = primes[i];
				number /= primes[i];
			} else if (number % primes[i] == 0 && number == primes[i]) {
				splits[count++] = primes[i];
				break;
			} else {
				i++;
			}
		}
		int[] result = new int[count];
		System.arraycopy(splits, 0, result, 0, count);
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = primeArray(5);
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		int[] result = split(14);
		for (int a : result) {
			System.out.print(a + " ");
		}
	}
}
