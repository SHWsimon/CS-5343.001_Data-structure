
public class MyIntTree{ //binary tree not a search tree
   private Node root;
   private static class Node
   {
      int data;
      Node left;
      Node right;
      
      Node(int d, Node lt, Node rt)
      {
         data = d;
         left = lt;
         right = rt;
      }
   }

   public void makeSampleTree()
   {
	/*  10
	    / \
	  23    15
	  /  \  /
	  4  12 6
    */
	   
      Node ll = new Node(4, null, null);
      Node rl = new Node(12, null, null);
      Node l = new Node(23, ll, rl);
      Node rl2 = new Node(6, null, null);
      Node r = new Node(15, rl2, null);
      root = new Node(10, l, r);
   }

   
   public int sum()
   {
      return sum(root);
   }
   
   private int sum(Node t)
   {
      if (t == null)
         return 0;
      else
         return t.data + sum(t.left) + sum(t.right);
   }
   
   
   
//   public void printTree()
//   {
//      printTree(root);
//   }
//
//   private void printTree(Node t)
//   {
//      if (t != null)
//      {
//         printTree(t.left);
//         System.out.println(t.data);
//         printTree(t.right);
//      }   
//   }

  


   public int sumodd()
   {
      return sumodd(root);
   }
   
   private int sumodd(Node t)
   {
      if (t == null)
         return 0;
      else
         if (t.data%2 == 0)
            return sumodd(t.left) + sumodd(t.right);
         else
            return t.data + sumodd(t.left) + sumodd(t.right);
   }
//   
//   
//   public int sumleaves()
//   {
//      return sumleaves(root);
//   }
//   
//   private int sumleaves(Node t)
//   {
//      if (t == null)
//         return 0;
//      else
//         if (t.left == null && t.right == null)
//            return t.data;
//         else
//            return sumleaves(t.left) + sumleaves(t.right);         
//   
//   }
//   
  
   public static void main(String args[])
   {
      MyIntTree tree = new MyIntTree();
      
      tree.makeSampleTree();
      
//      tree.printTree();
//      
//      int mysum = tree.sum();
//      
//      System.out.println("Sum is: " + mysum);
//      
//      mysum = tree.sumodd();
//      
//      System.out.println("Sum of odd values is: " + mysum);
//
//      mysum = tree.sumleaves();
      
      System.out.println("Sum of leaf values is: " + tree.sum());
      System.out.println("Sum of leaf values is: " + tree.sumodd());

   }

}