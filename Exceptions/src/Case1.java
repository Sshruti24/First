
public class Case1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try 
		 {
	            int p = 40, q = 0;
	            int r = p/q; 
	            System.out.println ("Result = " + r);
	     } 
		 catch(ArithmeticException e) 
		 {
	            System.out.println (e.getMessage());
	            System.out.println(e);
	     }

	}

}
