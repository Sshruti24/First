
public class Case2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
		 {
	            int b[] = new int[6];
	            b[8] = 2; 
	      } 
		 catch(ArrayIndexOutOfBoundsException e)
		 {
			 System.out.println (e.getMessage());
	            System.out.println(e);
		 } 

	}

}
