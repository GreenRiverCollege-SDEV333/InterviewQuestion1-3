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
        int newSize = urlify(buffer, size);

        // check the "after" buffer contents via println
        System.out.println(Arrays.toString(buffer));
        // check to see if the new buffer's size is correct
        System.out.println("size: " + newSize);
    }

    // write your method here
    private static int urlify(char[] buffer, int size)
    {
        //keep track of whitespaces
        int spaces = 0;

        //count spaces in buffer char array
        for(char character:buffer)
        {
            if(character == ' ')
            {
                spaces++;
            }
        }

        //new size of string when replacing spaces with %20
        //multiply spaces by 2 to get two additional indices ' ' -> '%20'
        int newSize = size + (spaces * 2);
        int returnSize = newSize;

        //iterate through the array backwards and insert '%20' at the current newSize index
        //use newSize to account for the change in array sizes, it will equal out once there are no more '%20' to add
        for(int i = size - 1; i > 1; i--)
        {
            if(buffer[i] == ' ')
            {
                //%20 is written backwards because we are traversing backwards
                buffer[newSize - 1] = '0';
                buffer[newSize - 2] = '2';
                buffer[newSize - 3] = '%';
                //decrease newSize by 3 because we added 3 chars to the array
                newSize -= 3;
            }
            else
            {
                //since we didn't find whitespace, substitute the current index with buffer[i]
                buffer[newSize - 1] = buffer[i];
                //decrement newSize
                newSize--;
            }
        }

        //return size of new array
        return returnSize;
    }
}