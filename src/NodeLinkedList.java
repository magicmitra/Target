/**
 * NodeLinkedList:
 * This is the linked list structure that the Node
 * objects will be within under.
 * It will have a head pointer that points to
 * first element(Node) in the linked list
 * Ervin Mitra
 */


public class NodeLinkedList
{
    private Node head;  // the head reference
    private int count;  // keep count of Node elements

    // constructor
    public NodeLinkedList()
    {
        // should refer to the head Node since when this constructor
        // is invoked, this list will be empty. Head will have '0'
        // as its value because the Node constructor needs a value.
        head = new Node(0);
        count = 0;
    }


    // a method to add to the end of the  linked list
    public void add(int n)
    {
        // create a new Node object
        Node temp = new Node(n);

        // start at the head of this linked list
        Node current = head;

        // find your way towards the end of the list
        while(current.getNext() != null)
        {
            current = current.getNext();
        }

        // the last node is now found, set this to point to
        // the new element that was added
        current.setNext(temp);

        // increment list
        count++;
    }

    // a method to print contents of the linked list
    public void printList()
    {
        Node current = head;

        // No need to print head, so move to non head Node.
        current = current.getNext();

        while(current.getNext() != null)
        {
            System.out.println(current.value + " ");

            // move current
            current = current.getNext();
        }
    }

    // a method to get he list count
    public int getLinkedListCount()
    {
        // count - 1 because head pointer excluded
        return this.count - 1;
    }

    // method to return ith Node in the Linked List
    // must make sure that the ith Node argument does
    // not exceed linked list count, head is node 0
    // and does not need to be referenced by main
    public Node ithNode(int i)
    {
        Node current = head;
        current = current.getNext();
        int j;
        for(j = 1; j < i; j++)
        {
            current = current.getNext();
        }
        return current;
    }

    public int getCount()
    {
        return this.count;
    }

    // this function will return the total value of the
    // linked list
    public int getLinkedListTotal()
    {
        int total = 0;
        Node current = head;

        for(int i = 1; i <= this.getCount(); i++)
        {
            current = current.getNext();
            total += current.getValue();
        }

        return total;
    }
}