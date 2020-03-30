package Session2.InfixEval;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Bhavesh
 *
 */

public class InfixEvaluation {
	
	private Map<String , Integer> operators ;
	private StackImpl<String> stack;
	private String postfix[];
	private String[] infix;
	private int postInd;
	
	
	public InfixEvaluation(String infix) {
//		infix = "( "+infix + " )";
		this.infix = infix.split(" ");
		this.operators = new HashMap<String , Integer> ();
		this.stack = new StackImpl<String>(1000);
		this.postfix = new String[1000];
		this.postInd = 0;

		this.operators.put("(",-1 );  
		this.operators.put("{",-1 );  
		this.operators.put("||",1 );  
		this.operators.put("&&",2 );  
		this.operators.put("|",3 );   
		this.operators.put("^",4 );   
		this.operators.put("&",5 );   
		this.operators.put("==",6 );  
		this.operators.put("!=",6 );  
		this.operators.put("<",7 );   
		this.operators.put("<=",7 );  
		this.operators.put(">",7 );   
		this.operators.put(">=",7 );  
		this.operators.put(">>",8);   
		this.operators.put("<<",8 );  
		this.operators.put("+",9);    
		this.operators.put("-",9 );   
		this.operators.put("*",10 );  
		this.operators.put("/",10 );  
		this.operators.put("%",10);   
		this.operators.put("!",11);   

	}
	
	/**
	 * 
	 * @return Array of string continaing Postfix Expression
	 */
	public String[] infixToPostfixOperation() {                          
		int countparenthsis = 0;                                                        
		for (int i=0; i<infix.length; i++){  
			String op = infix[i];     
			if((op.equals("=") || op.equals("|") || op.equals("&") || op.equals("!") || op.equals("<") || op.equals(">"))
				&& i < infix.length-1) {
				String second = infix[i+1];
				if(second.equals("=") || second.equals("|") || second.equals("&")) {
					op += second;
					i += 1;
				}
			}
			System.out.println("Operator is : "+op);
			if (Character.isDigit(op.charAt(0)))                                                  
				postfix[postInd++]= op;                                                    
			else{                                                                       
				if (op.equals("(")){                                                         
					stack.push(op);                                                           
					countparenthsis++;                                                  
				}                                                                       
				else if (op.equals("")){                                                    
					while (!stack.isStackEmpty() && !stack.peek().equals("("))                           
						postfix[postInd++] = stack.pop();                                         
					stack.pop();                                                              
					countparenthsis--;                                                  
				}                                                                       
				else{                                                                   
					while (!stack.isStackEmpty() && operators.get(op) <=
							operators.get(getLastOperator())) {  
						System.out.print("poping : ");
						int value = operators.get(getLastOperator());
						if(value  == 6 || value == 7 || value == 1 || value == 2) {
							postfix[postInd++] = stack.pop();
						}
						postfix[postInd++] = stack.pop(); 
					}
					stack.push(op);                                                           
				}                                                                       
			}                                                                           
		}                                                                               
		while (!stack.isStackEmpty())                                                        
			postfix [postInd++] =  stack.pop();                                                     
	                                                                                    
		if (countparenthsis != 0){                                                      
			System.out.println("invalid expression");                                   
			return null;                                                                  
		}                                                                               
		return postfix;                                                           
	}                                                                                   
	
	
	/**
	 * 
	 * @return The Last top
	 */
	private String getLastOperator() {
		// TODO Auto-generated method stub
		String op = "";
		op += stack.peek();
		String first = stack.peek();
		
		if(stack.size() > 1 && (first.equals("=") || first.equals("|") || first.equals("&"))) {
			String second = stack.secondPeek();
			if(second.equals("=")|| second.equals("<") || second.equals(">") || second.equals("<"))
				op += stack.secondPeek();
		}
		return op;
	}
	
	/**
	 * 
	 * @return Evaluate Expression from its PostFix Expression
	 */
	public Integer evaluate() {
		
		StackImpl<Integer> valueStack = new StackImpl<Integer>(1000){};
		for(int i=0; i<postInd; i++)
			System.out.print(postfix[i]+", ");
		
		System.out.println();
		
		for (int i=0; i<postInd; i++){
			String value = postfix[i];
			if (Character.isDigit(value.toCharArray()[0]))
				valueStack.push(Integer.valueOf(value));
			else{
				int val1 = valueStack.pop();
				int val2 = valueStack.pop();
				System.out.println(val2 + " "+value+" " + val1 );
				if (value.equals("+"))
					valueStack.push(val2 + val1);
				else if (value.equals("-"))
					valueStack.push(val2 - val1);
				else if (value.equals("*"))
					valueStack.push(val2 * val1);
				else if (value.equals("/"))
					valueStack.push(val2/val1);
				else if (value.equals("%"))
					valueStack.push(val2%val1);
				else if (value.equals("==")) {
					if(val2==val1)
						valueStack.push(1);
					else
						valueStack.push(0);
				}
				
				else if (value.equals("!=")){
					if(val2==val1)
						valueStack.push(0);
					else
						valueStack.push(1);
				}
				else if (value.equals("||")){
					if(val1 > 0 || val2 > 0)
						valueStack.push(1);
					else
						valueStack.push(0);
				}
				else if (value.equals("&&")){
					if(val1 > 0 && val2 > 0)
						valueStack.push(1);
					else
						valueStack.push(0);
				}
				else if (value.equals(">=")){
					if(val2 >= val1)
						valueStack.push(1);
					else
						valueStack.push(0);
				}
				else if (value.equals("<=")){
					if(val2 <= val1)
						valueStack.push(1);
					else
						valueStack.push(0);
				}
//				else if (value.equals("|")){
//					valueStack.push(val2 | val1);
//				}
//				else if (value.equals("&")){
//					valueStack.push(val2 & val1);
//				}
				else if (value.equals("!")) {
					valueStack.push(val2);
					if(val1 > 0)
						valueStack.push(0);
					else
						valueStack.push(val1);
				}
			}
		}
		return valueStack.pop();
	}


	public static void main(String args[]) {
		
		String infix = "1 + 2 - 2 % 6 == 1";
		InfixEvaluation obj = new InfixEvaluation(infix);
		System.out.println(obj.infixToPostfixOperation().toString());
		System.out.println("RESULT = "+obj.evaluate());
	}

}
