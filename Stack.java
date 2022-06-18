//Student 1 full name:
//Student 2 full name:
//==================================================


/**
 * Stack interface is used to provide an interface to the class LinkedStack which implements
 *	this interface for functionality of stack
 *	-> documentation of functions is provided in LinkedStack.java
 *
 */

public interface Stack {
	boolean isEmpty( );
	void push( int o );
	int pop( );
	int peek( );
	int size( );
}