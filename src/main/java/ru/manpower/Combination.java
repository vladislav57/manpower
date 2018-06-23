package ru.manpower;

/**
 * По русски - число сочетаний
 * https://en.wikipedia.org/wiki/Combination
 */
public class Combination {
    public static void main(String[] args) {
        System.out.println(numberOfCombinations(6, 3));
    }

    public static int numberOfCombinations(int all, int part) {
        int result = 1;
        for(int i=0; i<part; i++) {
            result *= (all - i);
        }
        for(int i=1; i<=part; i++) {
            result /= i;
        }
        return result;
    }
}
