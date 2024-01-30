//import org.w3c.dom.Node;

public class Linkedlists_merge {
    Node head;
    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    //add element at first

    public void addFirst(int data)
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
    

    public Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null && list2 == null)
        {
            return list1;
        }
        Node merged = new Node(-1);
        Node mergedList = merged;
        while(list1 != null && list2 != null)
        {
            if(list1.data < list2.data)
            {
                mergedList.next = list1;
                mergedList = mergedList.next;
                list1 = list1.next;
            }
            else
            {
                mergedList.next = list2;
                list2 = list2.next;
                mergedList = mergedList.next;
            }
        }

        while(list1 != null)
        {
            mergedList.next = list1;
            mergedList = mergedList.next;
            list1 = list1.next;
        }

        while(list2 != null)
        {
            mergedList.next = list2;
            mergedList = mergedList.next;
            list2 = list2.next;
        }

        return merged.next;
    }
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

    public static void main(String[] args)
    {
        
        Linkedlists_merge list1 = new Linkedlists_merge();
        list1.addFirst(4);
        list1.addFirst(2);
        list1.addFirst(1);
        list1.print();
        Linkedlists_merge list2 = new Linkedlists_merge();
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(0);
        list2.print();
        Node merge = list1.mergeTwoLists(list1.head,list2.head);
        list1.print();
    }
}
