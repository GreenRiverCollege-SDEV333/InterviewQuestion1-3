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
 * Driver class that defines the length of a Buffer and calls
 * a main method
 */
public class Main {
    public static final int BUFFER_CAPACITY = 32768;

    /**
     * program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // set up empty buffer, size of 0
        char[] buffer = new char[BUFFER_CAPACITY];
        int size;

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
        size = urlify(buffer, size);


        // check the "after" buffer contents via println
        System.out.println(Arrays.toString(buffer));

        // check to see if the new buffer's size is correct
        System.out.println("size: " + size);

        int counter = 0;
        int index = 0;
        while (buffer[index] != '\u0000') {
            counter++;
            index++;
        }

        if (counter == size) {
            System.out.println("Size is accurate");
        } else {
            System.out.println("Size is not accurate");
        }
    }

    // write your method here

    /**
     * Method that adds a '%', a '2' and a '0' character for every space
     * character found in a char[] to %20 and shifts the remaining characters
     * over to include room for these new characters
     * @param buffer char[]
     * @param size Amount of non-empty indices in buffer char[]
     * @return updated size of buffer char[]
     */
    public static int urlify(char[] buffer, int size) {

        for (int i = 0; i < size; i++) {
            if (buffer[i] == ' ') {

                size += 2;

                for (int j = size; j > i; j--) {
                    buffer[j] = buffer[j - 2];
                }

                buffer[i] = '%';
                buffer[i + 1] = '2';
                buffer[i + 2] = '0';
                i = i + 2;
            }
        } return size;
    }
}