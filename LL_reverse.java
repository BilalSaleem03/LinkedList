import java.util.Scanner;
public class LL_reverse {
    Node head;
    private int size;
    
    LL_reverse()
    {
        this.size=0;
    }

    class Node
    {
        String data;
        Node next;

        public Node(String data)
        {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add element at first

    public void addFirst(String data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //add element at last

    public void addLast(String data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;   
            return;     
        }

        Node currNode = head;
        while(currNode.next != null)
        {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //delete first element

    public void delFirst()
    {
        if(head==null)
        {
            System.out.println("List is Empty");
            return;
        }
        size--;
        head = head.next;
    }

    //delete last element

    public void delLast()
    {
        if(head==null)
        {
            System.out.println("List is Empty");
            return;
        }
        size--;
        if(head.next==null)
        {
            head = null;
            return;
        }

        Node lastNode = head.next;
        Node secLastNode = head;

        while(lastNode.next!=null)
        {
            lastNode = lastNode.next;
            secLastNode = secLastNode.next;
        }
        secLastNode.next = null;
    }

    //print linkedList
    
    public void print()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null)
        {
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
        }
        System.out.println("null");

    }

    //print size of linkedList Nodes

    public int nodeSize()
    {
        return size;
    }

    //reverse a link list by itrative approach

    public void reverseIterative()
    {
        if((head == null) || (head.next == null))
        {
            return;
        }

        Node previousNode = head;
        Node currentNode = head.next;
        while(currentNode != null)
        {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode; 
        }
        head.next = null;
        head = previousNode;

    }

    //reverse linked list by recursion

    public Node reverseRecursive(Node head)
    {
        if((head==null) || (head.next == null))
        {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next =  head;
        head.next = null;

        return newHead;

    }

    public static void main(String[] args)
    {
        LL_reverse list = new LL_reverse();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("enter");
        //String s = sc.nextLine();
        //list.print();
        list.addFirst("a");
        list.addFirst("is");
        //list.print();
        list.addLast("list");
        //list.print();
        list.addFirst("This");
        list.print();
        //list.delFirst();
        //list.print();
        //list.delLast();
        //list.print();
        //System.out.println(list.nodeSize());
        //list.addFirst("This");
        //System.out.println(list.nodeSize());
        System.out.println("reversed ......");
        list.reverseIterative();
        list.print();
        System.out.println("Reversed again.....");
        list.head = list.reverseRecursive(list.head);
        list.print();
    }
}
