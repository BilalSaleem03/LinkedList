import java.util.Scanner;
public class LL_remove_nth_node {
    Node head;
    private int size;
    
    LL_remove_nth_node()
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

    //swap

    public Node swapPairs(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node tail = swapPairs(head.next.next);
        
        Node temp = head;
        head = head.next;
        head.next = temp;
        temp.next = tail;
        
        return head;
    }
    

    //swap by iteration

    public void swapIterative()
    {
        if((head == null) || (head.next == null))
        {
            return;
        }

        Node previousNode = head;
        Node currentNode = head.next;
        while((previousNode!=null)||(currentNode != null))
        {
           // Node nextNode = currentNode.next;
            //previousNode.next.next = previousNode;
            //previousNode.next = nextNode;

            //previousNode = nextNode;
            //currentNode = previousNode.next;
            
            Node temp = previousNode;
            previousNode = previousNode.next;
            previousNode.next = temp;
            temp.next = previousNode.next.next;
            
            previousNode = previousNode.next.next;
            currentNode = previousNode.next; 

        }
        //head.next = null;
        //head = previousNode;

    }


    //remove nth node

    public Node remove(Node head , int n)
    {
        if(head.next==null)
        {
            return null;
        }
        int size =0;
        Node currNode = head;
        while(currNode !=null)
        {
            currNode = currNode.next;
            size++;
        }
        if(size==n)
        {
            return head.next;
        }
        int searched = size-n;
        Node preNode = head;
        int i =1;
        while(i<searched)
        {
            preNode = preNode.next;
            i++;
        }
        preNode.next = preNode.next.next;
        return head;
    }



    

    public static void main(String[] args)
    {
        LL_remove_nth_node list = new LL_remove_nth_node();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("enter");
        //String s = sc.nextLine();
        //list.print();
        list.addFirst("a");
        list.addFirst("is");
        //list.print();
        list.addLast("list");
        list.addLast("of");
        list.addLast("eng");
        list.addLast("and");
        list.addLast("math");
        list.addLast("books");
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
        //System.out.println("reversed ......");
        //list.reverseIterative();
        //list.print();
        //System.out.println("Reversed again.....");
        //list.head = list.reverseRecursive(list.head);
        //list.head = list.swapPairs(list.head);
        //list.print();

        list.head = list.remove(list.head , 2);
        list.print();
    }
}
