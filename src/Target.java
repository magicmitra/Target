/**
 * Target.java
 * Reads a file in in.txt that contains a list of positive ints.
 * Duplicates are possible, separated by spaces. Zero not included.
 * Programs reads ints, then saves them in a singly linked list in
 * the same order that they appear in the input file. Program then
 * prints whether a partition of the list whose sums have a GCD of
 * another target value.
 * Ervin Mitra
 */

import java.io.*;
import java.util.StringTokenizer; // allowed per instructions
import java.math.BigInteger;      // allowed per instructions

public class Target
{

    // main method
    public static void main(String[] args)
    {
        // java buffered reader along with the file to be read: "in.txt"
        // assuming "in.txt" is in the same folder as this program
        // then build a linked list of nodes
        String nameOfFile = "in.txt";
        String buffer = null; // edit this accordingly
        NodeLinkedList nll = new NodeLinkedList();

        // try opening the file
        try
        {
            // Use FileReader to read text files
            FileReader fr = new FileReader(nameOfFile);

            // BufferedReader will wrap FileReader
            BufferedReader br = new BufferedReader(fr);

            // text from in.txt is now in var called 'blanks'
            buffer = br.readLine();

            //System.out.println(buffer);

            // Use StringTokenizer to tokenize what is read from in.txt
            StringTokenizer st = new StringTokenizer(buffer);

            // place the buffer values in a linked list: Node class which
            // resides in the same folder as the one this file resides
            while(st.hasMoreTokens())
            {
                // cast the tokenized string into int
                int x = Integer.parseInt(st.nextToken());

                // proceed to add this int to the linked list
                nll.add(x);
            }

            // at this point, the linked list should have been created
            // test: uncomment code below to check if linked list worked
            //nll.printList();
            //System.out.println(nll.getLinkedListCount());

            // close the file
            br.close();
        }

        // catch exceptions if the file does not exist
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Unable to open file '" + nameOfFile + "'");
        }
        catch(IOException ioex)
        {
            System.out.println("Error reading file '" + nameOfFile + "'");
        }

        // Prompt the user then procees to check if the user prompt is equal to the
        // GCD . A lot of the functions in action are defined below
        int target = targetPrompt();
        int listLength = nll.getCount();
        int total = nll.getLinkedListTotal();
        boolean exists = partitionExists(nll, 1, listLength, 0, target, total);
        System.out.println("target: " + target);
        if(exists)
        {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

    /* create subsets of the list
     * PARAMS:
     * @n -> the linked list object
     * @counter -> the counter to be compared to control
     * @control -> the control to make sure the recursion eventually stops
     * @subset -> the subset will be returned
     * @target -> target value
     * @total -> total value of linked list
     */
    public static boolean partitionExists(NodeLinkedList n, int counter, int control, int subset1, int target, int total)
    {

        // base case
        if(counter > control)
        {
            // call gcdTargetEqual
            // output the sums of all possible subsets
            // return a true if it matches with target, false otherwise
            int subset2 = total - subset1;
            boolean result = gcdTargetEqual(target, subset1, subset2);

            System.out.println(subset1);

            if(result)
            {
                return true;
            }
            return false;
        }

        /* 2 recursive cases: one to include current value on the subset
         * and the other one to exclude it. Complexity if O(n^2), with n
         * equal to the number of Nodes in the linked list. This is so
         * because for every Node, its value enters recursion twice, one
         * to clone the empty set, and another one to include it within
         * the set. This assures that all possible subsets are partitioned.
         */

        return partitionExists(n, counter + 1, control, subset1 + n.ithNode(counter).getValue(), target, total)
                || partitionExists(n, counter + 1, control, subset1, target, total);

    }

    // Check if the GCD is equal to the target value.
    // Calls on the gcd method provided by instructor.
    public static boolean gcdTargetEqual(int valueTarget, int value1, int value2)
    {
        // invoke gcd function
        int gcdValue = gcd(value1, value2);

        if(valueTarget != gcdValue)
        {
            // equivalent to false
            return false;
        }
        else
        {
            // equivalent to true
            return true;
        }
    }

    // function to prompt the user for the target
    public static int targetPrompt()
    {
        int targetValue;
        java.util.Scanner key = new java.util.Scanner(System.in);
        System.out.println("Enter a target value (integer): ");
        targetValue = key.nextInt();
        return targetValue;

    }

    // GCD method in here, credit to Professor Thomas-Rogers or whoever wrote this
    // method to make the student's life easier.
    private static int gcd(int input1, int input2)
    {
        BigInteger x1 = new BigInteger(String.valueOf(input1));
        BigInteger x2 = new BigInteger(String.valueOf(input2));
        return x1.gcd(x2).intValue();
    }

    // GOAL: gcd == target value?
}


