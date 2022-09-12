package com.platzi.javatests.util;

public class FizzBuzz {

    public static String fizzBuzz(int n) {
        String result = "";
        if (n % 3 == 0) result = "Fizz";
        if (n % 5 == 0) result += "Buzz";
        if (result == "") result = String.valueOf(n);
        return result;
    }

}
