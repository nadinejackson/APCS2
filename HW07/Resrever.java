//Nadie Jackson
//APCS2 pd2
//HW07 -- A Man, A PLan, A Canal: A Panama!
//2018-06-03

public class Resrever{
    //O(n) time
    /*Algo: 
      0. If input String length < 2, return input String and skip all other steps.
      1. Return the last character, and repeat algo on the other characters.*/
    public static String reverseN(String str){
	if (str.length() < 2)
	    return str;
	else
	    return str.substring(str.length() - 1) + reverseN(str.substring(0,str.length() - 1));
    }
    
    //O(nlogn) time
    /*Algo:
      0. If input String length < 2, return input String and skip all other steps.
      1. Complete algo on right half and left half, add the resultant Strings in that order*/
    public static String reverseNLogN(String str){
	if (str.length() < 2)
	    return str;
	else{
	    String left = str.substring(0, str.length() / 2);
	    String right = str.substring(str.length() / 2);
	    return reverseNLogN(right) + reverseNLogN(left);
	}
    }
    public static void main(String[] args)
    {
	System.out.println(reverseN("nac"));
	System.out.println(reverseNLogN("uoy"));
	System.out.println(reverseN("raeh"));
	System.out.println(reverseNLogN("reh"));
	System.out.println(reverseN("worht"));
	System.out.println(reverseNLogN("nepo"));
	System.out.println(reverseN("eht"));
	System.out.println(reverseNLogN("wodniw"));
	System.out.println(reverseNLogN("ew"));
	System.out.println(reverseN("t'nod"));
	System.out.println(reverseNLogN("deen"));
	System.out.println(reverseN("latrom"));
	System.out.println(reverseNLogN("srats"));
	System.out.println(reverseN("ro"));
	System.out.println(reverseNLogN("doG"));
	System.out.println(reverseN("ew"));
	System.out.println(reverseNLogN("evah"));
	System.out.println(reverseN("eht"));
	System.out.println(reverseNLogN("dniw"));
	System.out.println(reverseN("a"));
	System.out.println(reverseNLogN("elbirret"));
	System.out.println(reverseN("dniw"));
    }
}
