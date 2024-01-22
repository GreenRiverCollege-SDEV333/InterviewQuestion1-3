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

/**
 * The main class to run the main method
 * @author Huy Nguyen
 * @version 1.0
 */

public class Main {
    public static final int BUFFER_CAPACITY = 32768;

    /**
     * The main method of java
     * @param args string arguments of main method
     */
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
       urlify(buffer, size);
        // check the "after" buffer contents via println
        System.out.println(Arrays.toString(buffer));
        // check to see if the new buffer's size is correct
        size=0;
        for (int i = 0; i < buffer.length; i++) {
            //not equals to null
            if (buffer[i] != '\u0000'){
                size++;
            }
        }
        System.out.println("Size: " + size);
    }


    // write your method here

    /**
     * The urlify method to add '%20' at every space and increment the size
     *
     * @param buffer the char[] which is being manipulated
     * @param size current size of the buffer
     * @return
     */
    public static char[] urlify(char[] buffer, int size){
        int spaceSize = 0;
        for (int i = 0; i < size; i++) {
            if (buffer[i] == ' ') {
                spaceSize++;
            }
        }

        // Calculate the size after adding in %20 in blank spaces
        int maxSizePointer = size + spaceSize * 2;
        System.out.println("Buffer Size: " + maxSizePointer);
        for (int i = size - 1; i >= 0; i--) {
            if (buffer[i] == ' ') {
                //if there is a blank space, replace with %20 relative to the maxSizePointer at the back
                buffer[maxSizePointer - 1] = '0';
                buffer[maxSizePointer - 2] = '2';
                buffer[maxSizePointer - 3] = '%';
                maxSizePointer -= 3;
            } else {
                //if letter, place within their location relative to maxSizePointer at the back
                buffer[maxSizePointer - 1] = buffer[i];
                maxSizePointer--;
            }
        }
        return buffer;
    }
}