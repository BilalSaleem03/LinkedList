import java.util.*;


class LL_preBuild {
   public static void main(String args[]) {
       LinkedList<String> list = new LinkedList<String>();
       list.add("is");
       list.add("a");
       System.out.println(list);
       list.addLast("list");
       list.addFirst("this");
       System.out.println(list);
       list.add(3, "linked");
       System.out.println(list);


       System.out.println(list.get(0));
       System.out.println(list.size());   
       list.remove(3);
       System.out.println(list);
       list.removeFirst();
       System.out.println(list);
       list.removeLast();
      
       System.out.println(list);
   }
}
