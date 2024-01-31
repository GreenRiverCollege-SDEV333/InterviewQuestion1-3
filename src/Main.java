/*
 URLify: Write a method to replace all spaces (" ") in
 a character buffer (array) with "%20". You may assume
 that the buffer has sufficient space at the end to hold
 the additional characters, and that you are given the "true"
 size of the buffer (which is different from the length or capacity
 of the buffer).

 Constraint: perform the operation in place (in the existing
 buffer), without creating a new or temporary buffer or string.

 Example:
            buffer                             size
            -------------------------------    ----
 Input      Hello, world!                      13
 Output     Hello,%20world!                    15

 Input      Dr Martin Luther King              21
 Output     Dr%20Martin%20Luther%20King        27


 Learning Objectives:
  * To practice an interview question.
  * To recognize the difference between size and length when working
    with a buffer (similar to how a resizable ArrayList, and/or a
    StringBuilder's internals would work).
  * To create and implement an algorithm to manipulate contents of an array.
  * To analyze the runtime performance of the algorithm.

 Source:
 Gayle Laakmann McDowell. 2016. Cracking the Coding Interview (6th ed.)
 CareerCup, Palo Alto, CA.
 */


import java.util.Arrays;

public class Main {
    public static final int BUFFER_CAPACITY = 32768;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // set up empty buffer, size of 0
        char[] buffer = new char[BUFFER_CAPACITY];
        int size = 0;

        // initialize the buffer and size variables with some data
        String temp = "Dr Martin Luther King";
        for (int i = 0; i < temp.length(); i++) {
            buffer[i] = temp.charAt(i);
        }
        size = temp.length();

        // check the "before" buffer and size via println
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);

        // call your method here

        System.out.println("size: " + changeSpace(buffer, size));

        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
    }

    // write your method here
    public static int changeSpace(char[] charArray, int size) {
        // For each index in the charArray
        for (int i = 0; i < charArray.length; i++) {
            // If the char in index i is an empty space
            if (Character.isSpaceChar(charArray[i])) {
                // We first would increase the size by 2 since the empty space would be replaced by % and then 2 more for 2 and 0
                size += 2;

                // Starting from the size index which should be the end, we would copy the index -2 which basically means that we would move everything to the right by 2 from the index
                for (int j = size; j > i; j--) {
                    charArray[j] = charArray[j - 2];
                }

                // After the move, we would fill the 3 empty indexes with %, 2, and 0
                charArray[i] = '%';
                charArray[i + 1] = '2';
                charArray[i + 2] = '0';

                // increase i by 2 since we already know that the next 2 indexes are going to be 2 and 0
                i += 2;
            }
        }

        System.out.println(Arrays.toString(charArray));
        return size;
    }
}