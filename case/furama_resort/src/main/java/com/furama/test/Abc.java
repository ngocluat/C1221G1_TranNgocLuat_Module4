package com.furama.test;

public class Abc {

    public static void main(String[] args) {
        int array[] = {1, 5, 9, 2, 6, 15, 19, 35, 51, 53};
        int sum = 0;
        for (int number : array) {
            if (isPrime(number)) {
                sum += number;
            }
        }

    }

    public static boolean isPrime(Integer number) {
        boolean isPrime = true;
        if (number < 2) {
            isPrime = false;
        } else if (number > 2) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}
