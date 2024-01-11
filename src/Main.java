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
        System.out.println("Before");
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size + "\n");

        // call your method here
        Main main = new Main();
        main.replaceSpace(buffer, size);

        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
        System.out.println("After");
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);

    }

    // write your method here
    public void replaceSpace(char[] buffer, int size) {
        for (int i = 0; i < size; i++) {
            if (buffer[i] == ' ') {
                shiftOver(buffer, size, i+1);

            }
        }
    }

    // helper method
    private static void shiftOver(char[] buffer, int size, int index) {
        size+=5;
        for (int i = 0; i < 2; i++) {
            for (int j = size; j >= index; j--) {
                buffer[j] = buffer[j-1];
            }
        }
        buffer[index-1] = '%';
        buffer[index] = '2';
        buffer[index+1] = '0';

    }

}