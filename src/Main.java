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


        // set up empty buffer, size of 0
        char[] buffer = new char[BUFFER_CAPACITY];
        int size;

        System.out.println("Hello and welcome!");
        // initialize the buffer and size variables with some data
        String temp1 = "Hello and welcome!";
        for (int i = 0; i < temp1.length(); i++) {
            buffer[i] = temp1.charAt(i);
        }
        size = temp1.length();

        whiteSpaceReplacer(size, buffer);
        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
        System.out.println(buffer);


        // initialize the buffer and size variables with some data
        System.out.println("Dr Martin Luther King");
        String temp2 = "Dr Martin Luther King";
        for (int i = 0; i < temp2.length(); i++) {
            buffer[i] = temp2.charAt(i);
        }
        size = temp2.length();

        // check the "before" buffer and size via println
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);

        // call your method here
        whiteSpaceReplacer(size, buffer);
        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct
        System.out.println(buffer);

        //Above should be pushed into a method. but the files didn't establish them that way.

    }

    // write your method here
    private static void whiteSpaceReplacer(int size, char[] buffer){
        int countSpace = 0;
        for(int i = 0; i<size; i++){
            if(buffer[i]==' '){
                countSpace += 2;
            }
        }


        //size = 15
        // 3 white space = 6 more to size
        //21
//        int newSize = size + countSpace;
        int newPosition = size + countSpace;
        //By knowing the new Size, start moving letters to the new spots until you reach a white space.
        for (int i = size; i >= 0; i--){
            //if buffer position is a white space add % to newPosition, 2 to newPosition -1, % to new position -3
            //Move the new position by 3 points INSTEAD of 1.
            if(buffer[i] ==  ' '){
                buffer[newPosition] = '0';
                buffer[newPosition-1] = '2';
                buffer[newPosition-2] = '%';
                //move new position by 3 positions.
                newPosition -= 3;
            }
            else if (newPosition != 0){
                //move characters from old index positions to new index positions.
                buffer[newPosition] = buffer[i];
                //shift new position by 1 value to fill in the next box
                newPosition--;
            }
        }
    }


}