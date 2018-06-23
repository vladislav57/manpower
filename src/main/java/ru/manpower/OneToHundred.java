package ru.manpower;

public class OneToHundred {
    public static void main(String[] args) {
        print();
    }

    public static void print() {
        for(int iter=1; iter<=100; iter++) {
            System.out.println(replace(iter));
        }
    }

    private static String replace(int iter) {
        String result = String.valueOf(iter);
        if(iter%2 == 0) {
            result = "Two";
        }
        if(iter%7 == 0) {
            result = "Seven";
        }
        if(iter%14 == 0) {
            result = "TwoSeven";
        }
        return result;
    }
}
