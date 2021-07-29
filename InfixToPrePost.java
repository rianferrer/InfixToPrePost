
public class InfixToPrePost {
	
	private Stacks2 x;
	private String input;
	private String output = "";

	public InfixToPrePost(String str)
	{
		input = str; 
		x = new Stacks2(str.length());
	}

	// INXFIX TO PREFIX
	public String inToPre()
	{
		int i;

		for(i = (input.length()-1); i >= 0; i--)
		{
			char ch = input.charAt(i);
			switch(ch)
			{
				case '+':
				case '-': gotOperator(ch,1,')');
				break;
				
				case '*':
				case '/': gotOperator(ch,2,')');
				break;
				
				case ')': x.push(ch);
				break;
				
				case '(': gotParenthesis(')');
				break;
				
				default: output = ch + output;
			}
		}

		while(!x.isEmpty())
			output = x.pop() + output;
		
		return output;
	}

	// INFIX TO POSTFIX
	public String inToPost()
	{
		
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			switch(ch)
			{
				case '+':
				case '-': gotOperator(ch,1,'(');
				break;
				
				case '*':
				case '/': gotOperator(ch,2,'(');
				break;
				
				case '(': x.push(ch);
				break;
				
				case ')': gotParenthesis('(');
				break;
				
				default: output = output + ch;
			}
		}

		while(!x.isEmpty())
			output = output + x.pop();
		
		return output;
	}

	private void gotOperator(char opThis, int prec1, char y)
	{
		
		while(!x.isEmpty())
		{
			char opTop = x.pop();
			
			if(opTop == y)
			{
				x.push(opTop);
				break;
			}
			else
			{
				int prec2;
				
				if(opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				
				if(prec2 < prec1 && y == '(')
				{
					x.push(opTop);
					break;
					
					//FERRER, MARION CARYL R.
					//2ITF
				}
				else if(prec2 <= prec1 && y == ')')
				{
					x.push(opTop);
					break;
				}
				else
				{
					if(y == ')')
					output = opTop + output;
					else
					output = output + opTop;
				}
			}
		}
		
		x.push(opThis);
	}

	private void gotParenthesis(char y)
	{
		while(!x.isEmpty())
		{
			char ch = x.pop();
			if(ch == y)
			break;
			else
			{
				if(y == ')')
				output = ch + output;
				else
				output = output + ch;
			}
		}
	}
	
}