import java.io.*;
public class RunInfixToPrePost {

	public static void main(String args[])throws IOException
	{  
		String s,check = "y";
		int n;
		InfixToPrePost ip;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(check.equals("y"))
		{
			System.out.println("Welcome to Rian's Polish Notations Converter!");
			System.out.println(" ");
			System.out.println("Choose one: (Enter 1 or 2)");
			System.out.println("1. Infix to Prefix");
			System.out.println("2. Infix to Postfix");

			//FERRER, MARION CARYL R.
			//2ITF
			
			n = Integer.parseInt(br.readLine());
			
			switch(n)
			{
				case 1: 
				System.out.print("Enter the infix expression: ");
				s = br.readLine();
				ip = new InfixToPrePost(s);
				System.out.println("Converting...");
				System.out.println("Prefix expression: " + ip.inToPre());     
				break;
				
				case 2: 
				System.out.print("Enter the infix expression: ");
				s = br.readLine();
				ip = new InfixToPrePost(s);
				System.out.println("Converting...");
				System.out.println("Postfix expression: " + ip.inToPost()); 
				break;
				
				default:
				System.out.println("Only choose 1 or 2.");
			}
			System.out.println("Another conversion? (Press y to continue)");
			check = br.readLine();
		}
	}
}
