/**
 * Node: elements within a linked list
 * The program must implement a linked list to store the
 * ints read by the Target program from in.txt.
 * Node has a value and the reference to the
 * next element on the list.
 * Ervin Mitra
 */


public class Node
{

    // Node's value and reference to next node
    protected int value;
    protected Node next;

    // constructor
    public Node(int x)
    {
        value = x;
        next = null; // null by default
    }

    // aux method to get next Node
    Node getNext()
    {
        return this.next;
    }

    // aux method to set next pointer of Node
    void setNext(Node n)
    {
        this.next = n;
    }

    // get value of node, useful for recursion
    int getValue()
    {
        return this.value;
    }

}