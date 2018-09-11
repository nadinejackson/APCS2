/*****************************************************
Nadine Jackson
APCS2 pd2
HW31 -- Stack: What Is It Good For?
2018-04-10
* class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	String r = s;
	Latkes flipr = new Latkes(s.length());
	String ret = new String();
	while(r.length() > 0)
	    {
		flipr.push(r.substring(0,1));
		if(r.length() > 1)
		    r = r.substring(1);
		else
		    r = "";
	    }
	while(! flipr.isEmpty())
	    ret += flipr.pop();
	return ret;
    }//end flip()

    public static boolean opens(String s)
    {
	return (s.equals("(")||s.equals("[")||s.equals("{"));
    }

    public static boolean match(String close, String open)
    {
	return (open.equals("(")&&close.equals(")")||
		open.equals("[")&&close.equals("]")||
		open.equals("{")&&close.equals("}"));
    }

    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	String r = s;
	Latkes unmatched = new Latkes(r.length());
	String charac = new String();
	while(r.length() > 0)
	    {
		charac = r.substring(0,1);
		if(opens(charac))
		    unmatched.push(r.substring(0,1));
		else
		    if(! match(charac, unmatched.pop()))
			return false;
		r = r.substring(1);
	    }
	return unmatched.isEmpty();
    }//end allMatched()
    

    //main method to test
    public static void main( String[] args )
    {
	
	  System.out.println(flip("stressed"));
	  System.out.println(allMatched( "({}[()])" )); //true
	  System.out.println(allMatched( "([)]" ) ); //false
	  System.out.println(allMatched( "(){([])}" ) ); //true
	  System.out.println(allMatched( "](){([])}" ) ); //false
	  System.out.println(allMatched( "(){([])}(" ) ); //false
	  System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	 /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
