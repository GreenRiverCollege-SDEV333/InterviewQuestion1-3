import java.util.Arrays;

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
public class Main {
    /**
     * The maximum capacity of the current buffer
     */
    public static final int BUFFER_CAPACITY = 50; //32768;

    public static void main(String[] args) {
        // set up empty buffer
        char[] buffer = new char[BUFFER_CAPACITY];

        // add some data to buffer
        String temp = "Dr Martin Luther King";
        for (int i = 0; i < temp.length(); i++) {
            buffer[i] = temp.charAt(i);
        }

        // track buffer length
        int size = temp.length();

        // check the "before" buffer and size via println
        System.out.println("Before");
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);
        System.out.println();

        // call your method here

        // update size
        int newSize = calculateNewSize(buffer, size);

        // run through given buffer backwards
        for (int i = size; i > 0; i--) {
            // if the current character is a space
            if(buffer[i] == ' ') {
                // run through buffer backwards, up till index where space was found
                for(int j = size + 3; j >= i; j--) {
                    // get value at previous index and place in current index
                    buffer[j] = buffer[j - 1];
                }

                // set space replacement values: '%' '2' '0'
                buffer[i] = '%';
                buffer[i + 1] = '2';
            }
        }

        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
        System.out.println("After");
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + newSize);
    }

    // write your method here

    /**
     * Calculates the number of spaces in the given buffer, and returns the size that would be necessary to urlify it
     * @param buffer the buffer being searched
     * @param size the current size of the given buffer
     * @return the newly calculated size
     */
    private static int calculateNewSize(char[] buffer, int size) {
        // setup tracker for new size
        int newSize = size;

        // run through the given buffer
        for(char currChar : buffer) {
            // if the current character is a space
            if(currChar == ' ') {
                // increase new size by two as we are adding three chars,
                // one of which replaces the spot taken up by space character
                newSize += 2;
            }
        }

        return newSize;
    }
}