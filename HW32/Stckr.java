/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	Stack<String> cakes = new ALStack<String>();
	//Stack<String> cakes = new LLStack<String>();
	System.out.println("Starting with empty cakes...");
	System.out.println("Is cakes empty? " + cakes.isEmpty());
	System.out.println("Now let's push some stuff");
	cakes.push("head");
	cakes.push("my");
	cakes.push("in");
	cakes.push("what's");
	cakes.push("out");
	cakes.push("all");
	cakes.push("it");
	cakes.push("get");
	cakes.push("to");
	cakes.push("just");
	cakes.push("bed");
	cakes.push("in");
	cakes.push("lying");
	cakes.push("I'm");
	cakes.push("when");
	cakes.push("sometimes");
	cakes.push("cry");
	cakes.push("I");
	cakes.push("so");
	cakes.push("and");

	System.out.println("Is cakes empty? " + cakes.isEmpty());
	while(! cakes.isEmpty())
	    {
		System.out.println(cakes.pop());
	    }
	System.out.println("************************");
	cakes.push("drop the beat");
	cakes.push("d-d-d-d-");
	System.out.println(cakes.peek());
	System.out.println(cakes.pop());
        System.out.println(cakes.peek());
	
    }//end main

}//end class

