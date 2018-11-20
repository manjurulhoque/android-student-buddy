package com.example.rumi.studentbuddy;

class CalculateFactorial {
    public static final int MAX = 1000;

    private int res_size;
    private int res[] = new int[MAX];

    CalculateFactorial() {
        res_size = 1;
    }

    public int getRes() {
        return res_size;
    }

    // This function finds factorial of large numbers and prints them
    public int[] factorial(int n) {
        // Initialize result
        res[0] = 1;

        // Apply simple factorial formula n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res_size);

        return res;
    }

    //     This function multiplies x with the number represented by res[].
//    res_size is size of res[] or number of digits in the number represented
//    by res[]. This function uses simple school mathematics for multiplication.
//    This function may value of res_size and returns the new value of res_size
    private int multiply(int x, int r) {
        int carry = 0;  // Initialize carry

        // One by one multiply n with individual digits of res[]
        for (int i = 0; i < r; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;  // Store last digit of 'prod' in res[]
            carry = prod / 10;    // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[r] = carry % 10;
            carry = carry / 10;
            r++;
        }
        return r;
    }
}
