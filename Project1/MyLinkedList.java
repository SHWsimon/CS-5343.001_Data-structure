/**
 * LinkedList class implements a doubly-linked list.
 * @author simonwang
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
	public static MyLinkedList<Integer> lst = new MyLinkedList<>( );
	public static MyLinkedList<Integer> lst2 = new MyLinkedList<>( );
	// ooooo main()
	public static void main(String[ ] args )
    {
        for( int i = 0; i < 10; i++ )
            lst.add( i );
        for( int i = 20; i < 30; i++ )
        	lst.add( 0, i );
        for( int i = 39; i < 50; i++ )
            lst2.add( i );

        lst.remove( 0 );
        lst.remove( lst.size( ) - 1 );
        System.out.println("The list is :" + lst );
        
        //----------------My code-------------------//
        //Swap
        Scanner scanner = new Scanner(System.in);
        System.out.print("The position 1 that you want to swap with position 2 is :");
        int swapPos1 = scanner.nextInt();
        System.out.print("The position 2 is :");
        int swapPos2 = scanner.nextInt();
        lst.swap(swapPos1, swapPos2);
        System.out.println("The list1 after swap is : " + lst );
        
        //Shift
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("The step to shift is : ");
        int shiftStep = scanner2.nextInt();
        lst.shift(shiftStep);
        System.out.println("The list1 after shift is : " + lst );
         
        //Erase
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("The position to start erase is : ");
        int erasePos = scanner3.nextInt();
        System.out.print("How many number to erase : ");
        int eraseNum = scanner3.nextInt();
        lst.erase(erasePos, eraseNum);
        System.out.println("The list1 after erase is :" + lst );
      
        //insertList
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("The list2 is :" + lst2 );
        System.out.print("The position to insert list2 in list1 is : ");
        int insertPos = scanner4.nextInt();
        lst.insertList(lst2, insertPos);
        System.out.println("The list1 after insert is :" + lst );
        
        
        //----------------Author's code-------------------//
        /*
        java.util.Iterator<Integer> itr = lst.iterator( ); //lst.iterator( ) ->  return new LinkedListIterator( )
        												   //LinkedListIterator( ) 	implement in java.util.Iterator
        while( itr.hasNext( ) )
        {
                itr.next( );
                itr.remove( );
                System.out.println( lst );
        }
        */
    }
	
	//----------------My code-------------------//
	public void swap(int idx1, int idx2)
	{
		Node<AnyType> left = getNode(idx1);
		Node<AnyType> right = getNode(idx2);
		Node<AnyType> leftL = left.prev;
		Node<AnyType> rightR = right.next;
		Node<AnyType> rightL = right.prev;
		
		//left = right do nothing
		if(left == right)
			;
		//left , right do next to each other
		else if(right == left.next)
		{
			left.next = rightR;
			right.prev = leftL;
			leftL.next = right;
			right.next = left;
			left.prev = right;

		}
		//left , right do not next to each other
		else 
		{
			right.prev = leftL;
			right.next = left.next;
			left.prev = rightL;
			left.next = rightR;

			//new right and left, update the position before and after them 
			if (right.next != null)
				right.next.prev = right;
			if (right.prev != null)
				right.prev.next = right;
			if (left.next != null)
				left.next.prev = left;
			if (left.prev != null)
				left.prev.next = left;
			
		}
	}
	
	public void shift(int shift)
	{
		if(shift == 0);
		//shift right >=0
		else if(shift >= 0)
		{
			//Begin [Left1,'''' , Right1, Left2, '''', Right2] End
			Node<AnyType> Begin = beginMarker;
			Node<AnyType> End = endMarker;
			Node<AnyType> Left1 = Begin.next;
			Node<AnyType> Right2 = End.prev;
			Node<AnyType> Right1 = Left1.next;
			Right1 = beginMarker;
			for(int i=0; i < shift; i++)
			{
				Right1 = Right1.next;
			}
			Node<AnyType> Left2 = Right1.next;
			Left2.prev = Begin;
			Begin.next = Left2;
			Right2.next = Left1;
			Left1.prev = Right2;
			Right1.next = End;
			End.prev = Right1;
		}
		//shift left < 0
		else
		{
			//Begin [Left1,'''' , Right1, Left2, '''', Right2] End
			Node<AnyType> Begin = beginMarker;
			Node<AnyType> End = endMarker;
			Node<AnyType> Left1 = Begin.next;
			Node<AnyType> Right2 = End.prev;
			Node<AnyType> Left2 = Right2.prev;
			Left2 = endMarker;
			for(int i=0; i < Math.abs(shift); i++)
			{
				Left2 = Left2.prev;
			}
			Node<AnyType> Right1 = Left2.prev;
			Right1.next = End;
			End.prev = Right1;
			Left1.prev = Right2;
			Right2.next = Left1;
			Begin.next = Left2;
			Left2.prev = Begin;
		}
	}
	
	public void erase(int idx, int num)
	{
		/*
		for(int i=0; i < num; i++)
			lst.remove(idx);
		*/
		//return a node p.
		Node<AnyType> era = getNode(idx);
		for(int i=0; i < num; i++)
		{
			Node<AnyType> eraA = era.prev;
			Node<AnyType> eraB = era.next;
			eraA.next = eraB;
			eraB.prev = eraA;
			era = era.next;
		}
			
	}
	
	public void insertList(MyLinkedList<AnyType> lst2, int idx)
	{
		//Node<AnyType> isrtS = getNode(idx);
		Node<AnyType> isrtS = beginMarker.next;
		for(int i=1; i < idx; i++)
		{
			isrtS = isrtS.next;
		}
		// insert in index=0
		if(idx == 0)
			isrtS = isrtS.prev;
		
		Node<AnyType> isrtE = isrtS.next;
		//lst2Begin point to lst2 first element
		Node<AnyType> lst2Begin = lst2.getNode(0); 
		//lst2End point to lst2 last element
		Node<AnyType> lst2End = lst2.getNode(lst2.size()-1); 
		isrtS.next = lst2Begin;
		lst2Begin.prev = isrtS;
		isrtE.prev = lst2End;
		lst2End.next = isrtE;
	}
	
	
	//----------------Author's code-------------------//
    /**
     * oooooConstruct an empty LinkedList.
     */
    public MyLinkedList( )
    {
        doClear( );
    }
    
    private void clear( )
    {
        doClear( );
    }
    
    /**
     * oooooChange the size of this collection to zero.
     */
    public void doClear( )
    {
        beginMarker = new Node<>( null, null, null );
        endMarker = new Node<>( null, beginMarker, null );
        beginMarker.next = endMarker;
        
        theSize = 0;
        modCount++;
    }
    
    /**
     * ooooo Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * ooooo Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x ) //add element and return true
    {
        add( size( ), x );   
        return true;         
    }
    
    /**
     * ooooo Adds an item to this collection, at specified position.
     * Items at or after that position are slid one position higher.
     * @param x any object.
     * @param idx position to add at.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    public void add( int idx, AnyType x ) // insert number
    {
        addBefore( getNode( idx, 0, size( ) ), x );
    }
    
    /**
     * ooooo Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */    
    private void addBefore( Node<AnyType> p, AnyType x ) // Insert in the most front, p is the getNode space
    {
        Node<AnyType> newNode = new Node<>( x, p.prev, p );
        newNode.prev.next = newNode;
        p.prev = newNode;         
        theSize++;
        modCount++;
    }   
    
    
    /**
     * ooooo Returns the item at position idx.
     * @param idx the index to search in.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx ) //getNode( idx ) will get newNode p
    {
        return getNode( idx ).data;
    }
        
    /**
     * ooooo Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal ) // Changes the item at position idx.
    {
        Node<AnyType> p = getNode( idx ); // getNode( idx ) return idx position p
        AnyType oldVal = p.data;
        
        p.data = newVal;   //insert newVal
        return oldVal;
    }
    
    /**
     * ooooo Gets the Node at position idx, which must range from 0 to size( ) - 1.
     * @param idx index to search at.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size( ) - 1, inclusive.
     */
    private Node<AnyType> getNode( int idx ) //input idx position and call getNode(idx, lower, upper)
    {
        return getNode( idx, 0, size( ) - 1 );
    }

    /**
     * ooooo Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */    
    private Node<AnyType> getNode( int idx, int lower, int upper )
    {
        Node<AnyType> p; //object
        
        if( idx < lower || idx > upper ) //out of range
            throw new IndexOutOfBoundsException( "getNode index: " + idx + "; size: " + size( ) );
            
        if( idx < size( ) / 2 ) //insert in the middle
        {
            p = beginMarker.next;
            for( int i = 0; i < idx; i++ ) //add new space from i=0 ~ idx-1
                p = p.next;            
        }
        else //insert from the end to middle
        {
            p = endMarker;
            for( int i = size( ); i > idx; i-- )
                p = p.prev;
        } 
        
        return p;
    }
    
    /**
     * ooooo Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
        return remove( getNode( idx ) ); // get position idx's node p
    }
    
    /**
     * ooooo Removes the object contained in Node p.
     * @param p the Node containing the object.
     * @return the item was removed from the collection.
     */
    private AnyType remove( Node<AnyType> p )
    {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        
        return p.data;
    }
    
    /**
     * ooooo Returns a String representation of this collection.
     */
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( "[ " );

        for( AnyType x : this )
            sb.append( x + " " );
        sb.append( "]" );

        return new String( sb ); //return a String with full list data
    }

    /**
     * ooooo Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new LinkedListIterator( ); //Obtains an Iterator object
    }

    /**
     * This is the implementation of the LinkedListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyLinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<AnyType>
    {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        
        // check is there still have elements in the node
        public boolean hasNext( )
        {
            return current != endMarker;
        }
        
        //move to next node, and return current node's data
        public AnyType next( )
        {
        	//return error
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException( ); 
                   
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }
        //remove
        public void remove( )
        {
        	//check error
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyLinkedList.this.remove( current.prev );//point to now MyLinkedList's object
            expectedModCount++;
            okToRemove = false;       
        }
    }
    
    /**
     * oooooThis is the doubly-linked list node.
     */
    private static class Node<AnyType>
    {
        public Node( AnyType d, Node<AnyType> p, Node<AnyType> n )
        {
            data = d; prev = p; next = n;
        }
        
        public AnyType data;
        public Node<AnyType>   prev;
        public Node<AnyType>   next;
    }
    
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;
}
