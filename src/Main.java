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
        // String temp = "Dr Martin Luther King";

        //Test cases
        //Hello, world! size 13, correct new size 15
        //String temp = "Hello, World!";

        //This is an interview question! size 30 new size 38
        String temp = "This is an interview question!";


        for (int i = 0; i < temp.length(); i++) {
            buffer[i] = temp.charAt(i);
        }
        size = temp.length();
        // check the "before" buffer and size via println
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);

        // call your method here


        // create variable to hold the new size of the buffer.
        int newSize = replaceSpaces(buffer, size);
        System.out.println(Arrays.toString(buffer));

        // check the "after" buffer contents via println
        System.out.println("Size: " +  newSize);

        // check to see if the new buffer's size is correct


    }

    // write your method here
    /*
     * This method will count the total of spaces available in the buffer
     * And eventually calculate the maximum of spaces needed for the replacement
     * and by using the for loop, the method will be going from the end of the buffer
     * write
     * */
    public static int replaceSpaces (char[] buffer, int size) {

        int spaceCount = 0;
        int newLength;
        int i;
        /*
        create a for loop to count the number of spaces
        use size for the comparison
        */
        for (i = 0; i < size; i++) {
            if (buffer[i] == ' ') {
                spaceCount++;
            }
        }
        /* calculate new string size
        because we need 2 extra space for '2' and '0'
        '%' will take over the available ' ' we will * the space count with 2
         */
        newLength = size + spaceCount * 2;

        /*
         * This for loop will find the spaces
         * and filling in the character '0' '2' '%'
         * once the character is fill in*/
        for (i = size - 1; i >= 0; i--) {// when a space is found, the for loop will
            if (buffer[i] == ' ') {
                buffer[newLength - 1] = '0';
                buffer[newLength - 2] = '2';
                buffer[newLength - 3] = '%';
                newLength = newLength - 3; //we need this statement because the newLength is of the buffer is reduced by 3
            } else {// if space is not found, the current character will be moved to the new spot of the buffer
                buffer[newLength - 1] = buffer[i];
                newLength = newLength - 1;
            }
        }
        //Return the new size of the buffer
        newLength = size + spaceCount * 2;
        return newLength;
    }

}