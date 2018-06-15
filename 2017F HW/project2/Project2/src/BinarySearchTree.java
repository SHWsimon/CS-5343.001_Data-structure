// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author simonwang
 */

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
	// Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t1 = new BinarySearchTree<>( );
        BinarySearchTree<Integer> t2 = new BinarySearchTree<>( );
        //copied tree
        BinarySearchTree<Integer> t3 = new BinarySearchTree<>( );
        //mirror tree
        BinarySearchTree<Integer> t4 = new BinarySearchTree<>( );
        //isMirror tree
        BinarySearchTree<Integer> t5 = new BinarySearchTree<>( );
        //Rotate tree
        BinarySearchTree<Integer> t6 = new BinarySearchTree<>( );
        //print level tree
        BinarySearchTree<Integer> t7 = new BinarySearchTree<>( );
        
        final int NUMS = 10;
        
        //create Tree t
        System.out.print("Create new Tree t1 is : ");
        for( int i = 1; i <= NUMS; i++ )
            t1.insert( i );
        if( NUMS < 40 )
        		t1.printTree( );
        
        //printCountNode
        System.out.print("\n" + "Total Node number : " + t1.CountNode());
        System.out.println("\n" + "################################################");
        
        //isFull tree?
        System.out.print("Is t1 a full tree? : " + t1.isFull());
        System.out.println("\n" + "################################################");
        
        //CompareStructure
        		//tree S
        System.out.print("Create new Tree t2 is : ");
        for( int i = 1; i <= NUMS; i++ )
            t2.insert( i );
        t2.insert(0);
        if( NUMS < 40 )
        		t2.printTree( );
        System.out.println("\n" + "Is the tree t2 match to tree t1 ? : " + t1.compareStructure(t2));
        System.out.println("################################################");
        
        //equalTree
        System.out.println("Is the tree t2 are as same as tree t1 ? : " + t1.equalTree(t2));
        System.out.println("################################################");
        
        //CopyTree
        System.out.print("Create new Tree t3 is : ");
        for( int i = 1; i <= NUMS; i+=2 )
            t3.insert( i );
        t3.printTree();
        t3.copyTree();
        System.out.print("\n" + "The result of copy tree t3 to a new tree is : ");
        t3.printTreePre();
        System.out.println("\n" + "################################################");
        
        //Mirror
        System.out.print("Create new Tree t4 is : ");
        for( int i = 1; i <= NUMS * 2; i+=3 )
            t4.insert( i );
        t4.printTree();
        t4.mirror();
        System.out.print("\n" + "The mirror tree of t4 is : ");
        t4.printTree();
        //t4.printTree();
        System.out.println("\n" + "################################################");
        
        //isMirror
        System.out.print("Create new Tree t5 is : ");
        for( int i = 4; i <= NUMS * 2; i+=3 )
            t5.insert( i );
        t5.mirror();
        t5.printTree();
        System.out.println("\n" + "t5 is t4's mirror ? : " + t4.isMirror(t5));
        System.out.println("################################################");
        
        //rotate Right
        System.out.print("Create new Tree t6, preorder is : ");
        t6.insert(5);
		t6.insert(4);
		t6.insert(3);
		t6.insert(2);
		t6.insert(1);
		t6.printTreePre();
		System.out.print("\n" + "t6 after rotate right, preorder is: ");
        t6.rotateWithLeftChild();
        t6.printTreePre();
        System.out.println("\n" + "################################################");
        
        //rotate Left
        System.out.print("Tree t6 preorder is : ");
		t6.printTreePre();
		System.out.print("\n" + "t6 after rotate left, preorder is: ");
        t6.rotateWithRightChild();
        t6.printTreePre();
        System.out.println("\n" + "################################################");
        
        //print level to level
        t7.insert(4);
		t7.insert(2);
		t7.insert(5);
		t7.insert(1);
		t7.insert(3);
		System.out.println("Tree t7 Level print is : ");
        t7.printLevel();
        
    }
    
  //-------------------------------My Code----------------------------------------------//
  //------------------------------------------------------------------------------------//
    
	//CountNode; use recursion 
	public int CountNode() 
	{
		return CountNode(root);
	}
	
	private int CountNode(BinaryNode<AnyType> t)
    {
        if( t == null )
            return 0;
        else
            return 1 + CountNode(t.left) + CountNode(t.right);    
    }
	
	//isFull
	public boolean isFull() 
	{
		return isFull(root);
	}
	
	private boolean isFull(BinaryNode<AnyType> t)
    {
		if(t != null)
		{
			if( t.right == null && t.left == null )
				return true;
		    if(t.right != null && t.left != null)
		    		return isFull(t.left) && isFull(t.right);
		}
		return false;  
    }
	
	//CompareStructure
	public boolean compareStructure(BinarySearchTree<AnyType> t2)
	{
		return compareStructure(root, t2.root);
	}
	
	private boolean compareStructure(BinaryNode<AnyType> t, BinaryNode<AnyType> t2)
	{
		//empty tree
		if(t == null && t2 == null)
			return true;
		
		//both non-empty tree
		if(t != null && t2 !=null)
			return compareStructure(t.left, t2.left) && compareStructure(t.right, t2.right);
		//different Tree
		return false;
	}
	
	//equalTree
	public boolean equalTree(BinarySearchTree<AnyType> t2)
	{
		return equalTree(root, t2.root);
	}
	
	private boolean equalTree(BinaryNode<AnyType> t, BinaryNode<AnyType> t2)
	{
		//both empty tree
		if(t == null && t2 == null)
			return true;
		//both non-empty tree
		if(t != null && t2 !=null)
		{
			if(t.element == t2.element)
				return equalTree(t.left, t2.left) && equalTree(t.right, t2.right);
		}
		//different Tree
		return false;
	}
	
	//copyTree
	public BinaryNode<AnyType> copyTree()
	{
		return copyTree(root.element, root);
	}
		
	private BinaryNode<AnyType> copyTree(AnyType x, BinaryNode<AnyType> t)
	{
		//empty tree
		if(t == null)
			return null;
		//non-empty tree
		else
		{
			BinaryNode<AnyType> cyTree = new BinaryNode<AnyType>(x, null, null);
			cyTree.left = copyTree(x, t.left);
			cyTree.right = copyTree(x, t.right);
			return cyTree;
		}
	}
	
	//Mirror
	public BinaryNode<AnyType> mirror()
	{
		return mirror(root);
	}
	
	private BinaryNode<AnyType> mirror(BinaryNode<AnyType> t)
	{
		//empty tree
		if(t == null)
			return t;
		//create new node copy original Left & Right then swap
		else
		{
			BinaryNode<AnyType> mirrorLeft = mirror(t.left);
			BinaryNode<AnyType> mirrorRight = mirror(t.right);		
			t.left = mirrorRight;
			t.right = mirrorLeft;
		}
		return t;		
	}
		
	//isMirror
	public boolean isMirror(BinarySearchTree<AnyType> t5)
	{
		return isMirror(root, t5.root);
	}
		
	private boolean isMirror(BinaryNode<AnyType> t1, BinaryNode<AnyType> t2)
	{
		//both empty tree
		if(t1 == null && t2 == null)
			return true;	
		//both non-empty tree
		if(t1 != null && t2 !=null)
		{
			if(t1.element == t2.element)
				return isMirror(t1.left, t2.left) && isMirror(t1.right, t2.right);
		}
		//different Tree
		return false;
	}
		
	//Single Rotate to Right
	public BinaryNode<AnyType> rotateWithLeftChild()
	{
		return rotateWithLeftChild(root);
	}
	
	private BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> k2) 
	{
		if( k2.left == null )
		{
			try {
				throw new Exception( );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BinaryNode<AnyType> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		root = k1;
		return k1;
	}
	
	//Single Rotate to left
	public BinaryNode<AnyType> rotateWithRightChild()
	{
		return rotateWithRightChild(root);
	}
	
	private BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> k1)
    {
		if( k1.right == null )
		{
			try {
				throw new Exception( );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BinaryNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        root = k2;
        return k2;
    }
	
	//print Level to level
	public void printLevel()
	{
		printLevel(root);
	}
	
	private void printLevel(BinaryNode<AnyType> t)
    {
		int height = Height(t);
		for(int i = 1 ; i <= height; i++)
		{
			printAsOrder(t, i);
			System.out.println();
		}
		
    }
	
		//recursion print
	private void printAsOrder(BinaryNode<AnyType> t, int i)
	{
		//end condition
		if(t == null)
			return ;
		//print
		if(i == 1)
			System.out.print(" " + t.element);
		if(i > 1)
		{
			printAsOrder(t.left, i-1);
			printAsOrder(t.right, i-1);
		}
	}
	
	//Height
	private int Height(BinaryNode<AnyType> t)
    {
		//empty
        if(t == null)
            return 0;
        else
        {
        		//Left & Right's Height
        		int hLeft = Height(t.left);
        		int hRight = Height(t.right);
        		//the highest level; with root so need to +1
            return hLeft > hRight ? hLeft + 1 : hRight + 1; 
        }
    }
	
	//Preorder
	public void printTreePre( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTreePre( root );
    }
	
	
	private void printTreePre( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            System.out.print( t.element + " ");
            printTreePre( t.left );
            printTreePre( t.right );
        }
        
    }

	//------------------------------------------------------------------------------------//
	//------------------------------------------------------------------------------------//
	
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
//        if( isEmpty( ) )
//            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
//        if( isEmpty( ) )
//            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.print( t.element + " ");
            printTree( t.right );
        }
        
    }
    

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;


    
        
        //--------------Author's Code-----------------//
//      final int GAP  =   37;

//      System.out.println( "Checking... (no more output means success)" );

//      for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
//          t.insert( i );        
//      for( int i = 1; i < NUMS; i+= 2 )
//      t.remove( i );
//        if( NUMS < 40 )
//            t.printTree( );
//        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
//            System.out.println( "FindMin or FindMax error!" );
//
//        for( int i = 2; i < NUMS; i+=2 )
//             if( !t.contains( i ) )
//                 System.out.println( "Find error1!" );
//
//        for( int i = 1; i < NUMS; i+=2 )
//        {
//            if( t.contains( i ) )
//                System.out.println( "Find error2!" );
//        }
//    }
}
