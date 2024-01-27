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
        int newSize = URLify(buffer, size);

        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + newSize);
    }

    // write your method here
    /*
        If a space is found in the buffer:
        -Increase the buffer size by 2
        -Scoot everything in an index higher than the index of the space up by 2 indexes
        -Replace the space with a %
        -Fill the two empty indexes above % with a 2 and a 0 respectively
     */
    public static int URLify(char[] buffer, int size)
    {
        //check buffer for spaces
        for (int i = 0; i < size; i++)
        {
            if (buffer[i] == ' ')
            {
                //store the index of the space
                int spaceIndex = i;

                //increment the size variable by 2
                size = size + 2;

                //scoot the other stuff
                for (int j = size; j >= spaceIndex + 2; j--)
                {
                    buffer[j] = buffer[j - 2];
                }

                //replacing the empty spaces with new characters
                buffer[spaceIndex] = '%';
                buffer[spaceIndex + 1] = '2';
                buffer[spaceIndex + 2] = '0';
            }
        }
        return size;
    }

}