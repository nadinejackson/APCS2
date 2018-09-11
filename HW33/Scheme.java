/*****************************************************
Nadie Jackson
APCS2 pd2
HW33 -- What a Racket
2018-04-12

 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   0. Split String by whitespace into an array of Strings
 *   1. Copy each String into one Stack from right to left
 *   2. Pop the first paren
 *   3. Store the operation 
 *   4. Set the answer to the first number
 *   5. Move on to the next String
 *   6a. If you encounter an open paren start from step 2, 
 *       then perform operation on result and go to step 5
 *   6b. If you encounter a number, perform operation on it and go to step 5
 *   6c. If you encounter a closing paren, return the result
 * STACK OF CHOICE: LLStack by Mr. Brown Mykolyk
 * b/c Having a LinkedList as an underlying container means that there will never be any pointers to unncessary data as there would be in an ArrayList or simple array, the underlying containers of ALStack and Latkes. LinkedLists are especially suited to being Stacks, with connections between each consecutive element and no fixed size.
 ******************************************************/

public class Scheme
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	Stack<String> stacc = new LLStack<String>();
	String[] data = expr.split("\\s+");
	int ctr = data.length - 1;
	while(ctr >= 0)
	    {
		stacc.push(data[ctr]); //copy the data in reverse order
		ctr -= 1;
	    }
	stacc.pop();
	int oper = toOp(stacc.pop());
	return unload(oper, stacc); //perform the operation on the stack
    }//end evaluate()

    public static int toOp(String op)
    {
	if (op.equals("+")) //check which one we're dealing with
	    return 1;
	if (op.equals("-"))
	    return 2;
	return 3;
    }
    
    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	Integer ans; //return value
	if (isNumber(numbers.peek())) 
	    ans = Integer.parseInt(numbers.pop());
	else //this is for this situation: ( + ( * 2 3 ) 5 )
	    {
		numbers.pop();
		int oper = toOp(numbers.pop());
		ans = Integer.parseInt(unload(oper, numbers));
		while(! numbers.pop().equals(")")){}
	    }
	while(! numbers.peek().equals(")")) //until you've reached the end of evaluation
	    {
		if(isNumber(numbers.peek())){ //if number, do specified operation
		    if(op == 1)
			ans += Integer.parseInt(numbers.pop());
		    else if(op == 2)
			ans -= Integer.parseInt(numbers.pop());
		    else
			ans *= Integer.parseInt(numbers.pop());
		    }
		else //you've reached another open paren
		    {
			numbers.pop();
			int oper = toOp(numbers.pop());
			ans += Integer.parseInt(unload(oper, numbers));
			while(! numbers.pop().equals(")")){}
		    }
	    }
	return ans.toString(); //Integer wrapper class has this
    }//end unload()


  
    //optional check-to-see-if-its-a-number helper fxn:
    //okay thanks
    public static boolean isNumber( String s ) {
	try {
	    Integer.parseInt(s);
	    return true;
	}
	catch( NumberFormatException e ) {
	    return false;
	}
    }
  


    //main method for testing
    public static void main( String[] args )
    {

	
	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4

	  String brkr = "( * ( + 1 2 ) 5 )"; //I made this to break my code because parens in first operand
	  System.out.println(brkr);
	  System.out.println("brkr eval'd: " + evaluate(brkr) );
	  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
