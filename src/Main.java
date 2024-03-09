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
        System.out.println("before:");
        shiftRight2(buffer, size);
        int newSize = replaceSpace(buffer, size);
        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct

        System.out.println("after:");
        shiftRight2(buffer, newSize);
    }

    // write your method here
    public static int replaceSpace(char[]buffer, int size){
        int numOfSpace =0;
        //count number of space
        for(int i =0; i<size; i++){
            if(buffer[i]== ' '){
                numOfSpace++;
            }
        }
        //new size replaced with %20
        int newSize =size+(2*numOfSpace);

        for(int i = size-1; i>=0; i--){
            if (buffer[i]==' '){
                buffer[i+2*numOfSpace]='0';
                buffer[i+2*numOfSpace-1]='2';
                buffer[i+2*numOfSpace-2]='%';
                numOfSpace--;
            }else{
                buffer[i+2*numOfSpace]=buffer[i];
            }

        }
        return newSize;
    }

    //print buffer and size
    public static void shiftRight2(char[]buffer, int size){
        StringBuilder output = new StringBuilder();
        for(int i =0; i<size;i++){
            output.append(buffer[i]);

        }
        //display the buffer and size
        System.out.println("output:"+output);
        System.out.println("size:"+size);
    }
}