package com.company;


import java.util.List;

/**
 * Overview: Provides procedure to detect if the ith element of a List is
 * the prime factor of the ith element of another List.
 * @author Sriman Abhishek Yengaldas
 */
public class FindPrimeFactor {

    /**
     * E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
     * (Note: 6 is a factor of 12, but is not prime,
     *  and 2 is prime, but is not a factor of 25.  However,
     *  3 is a prime factor of 18. Hence, index "2" is the correct
     *  answer.  index "3" is not a possible answer, because the
     *  third index is not the least index with the desired property.)
     * Also note that a[] and b[] need not be of the same length.
     * @param a List of Integers
     * @param b List of Integers
     * @return return the least index at which b[i] is a prime factor of a[i]
     * @throws NullPointerException if List 'a' or 'b' are null, or the current index of an
     * element in List 'a' or 'b' is null.  This is an unchecked exception.
     * @throws IndexOutOfBoundsException if no prime factor is found before the last element
     * of List a.  This is a checked exception.  Program continues as normal if thrown, but
     * will print Details on what index through the error.
     * @throws IllegalArgumentException if no prime factor is found within list 'b'. This
     * is a checked exception.
     */
    public static int findPrimeFactor (List<Integer> a, List<Integer> b) {

        for(int i = 0;i < b.size();i++){
            try{
                if(a.get(i) >= 2 && b.get(i)!=0 && a.get(i)%b.get(i) == 0){
                    if(isPrime(b.get(i))){
                        return i;
                    }
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Details "+ e.getMessage());
            }
        }

        throw new IllegalArgumentException("No prime factor was found");
    }

    private static boolean isPrime(int n) {
        if(n >= 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        } else{
            return false;
        }
        return true;
    }
}