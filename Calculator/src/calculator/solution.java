/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author hemant
 */
import java.util.Stack;

class solution{
     public String string ;
     public Stack<String>stack = new Stack<>() ;
     public Stack<String>st = new Stack<>() ;
     
     solution(String str){
        string = str ;
}

     public void fun(){
            if(st.size()>=1 && !stack.isEmpty()&& precedence(stack.peek())>=14){
            	String s1 = st.peek();
            	st.pop();
            	String op = stack.peek();
            	stack.pop();
            	int val = Integer.parseInt(s1);
            	int result = 0;

		if (op.equals("+")) result = +val;              
		else if (op.equals("-")) result = -val;         
		else if (op.equals("~")) result = ~val;         
		else if (op.equals("++")) result = val + 1;      
		else if (op.equals("--")){ 
                    result = val*-1;
                    stack.push("-");}     
		else if (op.equals("p++")) result = val;       
		else if (op.equals("p--")) result = val;         
		else {
    			System.out.println("Unsupported unary operator: " + op);
		}

            	st.push(result+"");
            	}
            else {
            if(st.size()>=2 && !stack.isEmpty()){
            String s1 = st.peek();
            st.pop();
            String s2 = st.peek();
            st.pop();
            String op = stack.peek();
            String s3 = "";
            int c1 = Integer.parseInt(s1);
            int c2 = Integer.parseInt(s2);
           int result = 0;

    	if (op.equals("+")) result = c1 + c2;
    	else if (op.equals("-")) result = c1 - c2;
    	else if (op.equals("*")) result = c1 * c2;
    	else if (op.equals("/")) result = c1 / c2;
    	else if (op.equals("%")) result = c1 % c2;
    	else if (op.equals("&")) result = c1 & c2;
    	else if (op.equals("|")) result = c1 | c2;
    	else if (op.equals("^")) result = c1 ^ c2;
    	else if (op.equals("<<")) result = c1 << c2;
    	else if (op.equals(">>")) result = c1 >> c2;
    	else if (op.equals(">>>")) result = c1 >>> c2;	
    	else if (op.equals("&&")) result = ((c1 != 0) && (c2 != 0)) ? 1 : 0;
    	else if (op.equals("||")) result = ((c1 != 0) || (c2 != 0)) ? 1 : 0;
    	

    	else {
        	System.out.println("Unsupported operator: " + op);
    	}
            st.push(result+"");
            stack.pop();}
            
            }
     
     }
     public String getnumber(String str , int index){
        String s = "";
        while(index<str.length() && Character.isDigit(str.charAt(index))){
            s+=str.charAt(index);        index++;}
        return s;
        
     }
      public String getoperator(String str , int index){
        String s = "";
       while(index<str.length() && isoperator(str.charAt(index))){
           s+=str.charAt(index);        index++;}
        return s;}
      
     
     
      public static boolean isoperator(char ch) {
        return "+-*/%=!<>|&^~".indexOf(ch) != -1;
   }
     public String function(){
     int i = 0 ;
        while( i < string.length()){
            if(Character.isDigit(string.charAt(i))){
                st.push(getnumber(string,i));
            	i += getnumber(string,i).length();}
            else if(stack.isEmpty()){
            	stack.push(getoperator(string,i));
            	i += getoperator(string,i).length();}
            else {
            	String str = getoperator(string,i);
            	i += getoperator(string,i).length();
                while(!stack.isEmpty() && !st.isEmpty() && precedence(str)<precedence(stack.peek())){
                    fun();
                  }
                  stack.push(str);
             }
         }
      while(!stack.isEmpty()){
      fun();
      }
      
      return st.peek();

}

public static void main(String args[]){
  

}
static int precedence(String op) {
        switch (op) {
            case "++":
            case "--":
                return 15 ;
            case "+u":
            case "-u":
            case "!":
            case "~":
            case "++p":
            case "--p":
                return 14 ;
            case "*":
            case "/":
            case "%":
                return 13 ;
            case "+":
            case "-":
                return 12;
            case "<<":
            case ">>":
            case ">>>":
                return 11;
            case "<":
            case ">":
            case "<=":
            case ">=":
                return 10;
            case "==":
            case "!=":
                return 9;
            case "&":
                return 8;
            case "^":
                return 7;
            case "|":
                return 6;
            case "&&":
                return 5;
            case "||":
                return 4;
            case "?":
                return 3; 
            case "=":
            case "+=":
            case "-=":
            case "*=":
            case "/=":
            case "%=":
                return 2; 
            case ",":
                return 1;
            default:
                return 0;
        }
    }

}