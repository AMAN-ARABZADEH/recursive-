package se.miun.main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(findBinary(233, ""));
        System.out.println(recursiveSummation(10));
        System.out.println(fib(5));




        int[] list = new int[]{-2,20, 3,4,-2,33,2,33,6,77,-22, 555,9,8,7,6,5,4,3,2};
         mergeSort(list, 0, list.length -1);
         for(int listd : list){
             System.out.print(listd + " ");
         }
        System.out.println();
        System.out.println("STOP");











    }
    // Reverse String recursivlly

    public  static String reverseString(String input){
        if(input.equals("")) {
            return  "";
        }
        return reverseString( input.substring(1)) + input.charAt(0);
    }


    // Palindrome

    public static Boolean isPalindrome(String input){
        if(input.length() == 0 || input.length() == 1){
            return  true;
        }
        if(input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }

    // Decimal to binary
    public  static  String findBinary(int decimal, String result){
        if(decimal == 0){
            return result;
        }
        result = decimal % 2 + result;
        return findBinary(decimal / 2, result);
    }

   // Sum function recursivlly
    public static  int recursiveSummation(int inputNumber){
        if(inputNumber <= 1){
            return inputNumber;
        }
        return inputNumber + recursiveSummation(inputNumber -1);
    }

    // Divide and conquer problem
    public  static int binarySearch(int[] list, int left, int right, int length){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;

        if(length == list[mid]){
            return  mid;
        }
        if(length < list[mid]){
            return  binarySearch(list, left, mid -1, length);
        }
        return binarySearch(list, mid +1, right, length);
    }

    // The fibonacci sequences
    public  static long fib(long n){
        if((n == 0) || (n == 1)){
            return n;
        }else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    // Merge sort
    public static void mergeSort(int[] list, int start, int end){
      if(start < end){
          int mid = (start + end ) / 2;
          mergeSort(list, start, mid);
          mergeSort(list, mid + 1 , end);
          merge(list, start, mid, end);
      }

    }

    private static void merge(int[] list, int start, int mid, int end) {
        // build a temp array  to avoid modifying the original contents
        int[] temp = new int[ end - start +  1];


        int leftSubArray = start, rightSubArray = mid + 1, tacker  = 0;
        while (leftSubArray <= mid && rightSubArray <= end){
            if(list[leftSubArray] <= list[rightSubArray]){
                temp[tacker++] = list[leftSubArray++];
                //leftSubArray++;
                //tacker++;
            }else {
                temp[tacker++] = list[rightSubArray++];
                // tacker++
                // rightSubArray++;
            }
        }

        // Add the rest of the values from the left sub-array into the result
        while (leftSubArray <= mid){
            temp[tacker++] = list[leftSubArray++];
        }

        // Add the rest of the values from the right sub-array into the result
        while (rightSubArray <= end){
            temp[tacker++] = list[rightSubArray++];
        }
        for(leftSubArray = start; leftSubArray <=  end; leftSubArray++){
            list[leftSubArray] = temp[leftSubArray - start];
        }
    }


}
