/**
 *
 * @author Ashton Hoeft
 * @version 3/22/2023
 * 
 */
public class ArithmeticOperations {
    /**
     * 
     * @param expression arithmetic expression to calculate
     * @return results of arithmetic expression
     * 
     * This method using the Shunting Yard approach to calculate an arithmetic expression
     */
    public static String infixToPostfix(String expression) {
        //Make sure the expression is valid
        checkExpression(expression);
        
        //Store the values from the expression into the right stack
        String [] array = expression.split(" ");
        LinkedStack <String> right = new LinkedStack();
        for(int i = array.length - 1; i >= 0; i--) {
            right.push(array[i]);
        }
        
        //Declare left and middle stacks
        LinkedStack <String> middle = new LinkedStack();
        LinkedStack <String> left = new LinkedStack();
        
        //Enter loop for algorithm and keep looping until righ stack and middle stack are empty
        while(!right.isEmpty()) {
            //Move numbers in left stack to the right stack
            if(isNumber(right)) {
                left.push(right.pop());
            }
            
            //Store left brackets in middle stack
            else if(isOpenBracket(right)) {
                middle.push(right.pop());
            }
            
            //Cancel out right brackets
            else if(isClosedBracket(right)) {
                if(isOpenBracket(middle)) {
                    middle.pop();
                    right.pop();
                }
                else {
                    left.push(middle.pop());
                }
            }
            
            //Store operators in correct stacks
            else if(isOperator(right)) {
                if(middle.top() == null || isOpenBracket(middle) || compareOperators(right, middle)) {
                    middle.push(right.pop());
                }
                else if(!compareOperators(right, middle)) {
                    left.push(middle.pop());
                }
            }
        }
        
        //Move the rest of the elements from middle stack to left stack
        while(!middle.isEmpty()) {
            left.push(middle.pop());
        }
        
        //Move left stack over to right stack
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        
        //Store expression as a String in post-fix notation
        String results = right.pop();
        while(!right.isEmpty()) {
            results += " " + right.pop();
        }
        
        //Return post-fix of expression
        return results;
    }
    
    /**
     * 
     * @param expression arithmetic expression in post-fix notation
     * @return evaluation of expression
     * 
     * This method calculates the value of an arithmetic expression in post-fix notation
     */
    public static float postfixEvaluation(String expression) {
        //Declare stacks
        LinkedStack <String> right = new LinkedStack();
        LinkedStack <String> middle = new LinkedStack();

        //Store the values from the expression into the right stack
        String [] array = expression.split(" ");
        for(int i = array.length - 1; i >= 0; i--) {
            right.push(array[i]);
        }

        //Enter loop to calculate results and keep looping until the final value has been calculated
        while(!right.isEmpty()) {
            //Move numbers in left stack to the middle stack
            if(isNumber(right)) {
                middle.push(right.pop());
            }
            
            //Check what operator is in the right stack
            else {
                //Add the two top numbers of middle stack if operator in right stack is (+)
                if(right.top().equals("+")) {
                    float rightNumber = Float.parseFloat(middle.pop());
                    float leftNumber = Float.parseFloat(middle.pop());
                    middle.push("" + (leftNumber + rightNumber));
                    right.pop();
                }
                //Subtract the two top numbers of middle stack if operator in right stack is (-)
                else if(right.top().equals("-")) {
                    float rightNumber = Float.parseFloat(middle.pop());
                    float leftNumber = Float.parseFloat(middle.pop());
                    middle.push("" + (leftNumber - rightNumber));
                    right.pop();
                }
                //Multiply the two top numbers of middle stack if operator in right stack is (*)
                else if(right.top().equals("*")) {
                    float rightNumber = Float.parseFloat(middle.pop());
                    float leftNumber = Float.parseFloat(middle.pop());
                    middle.push("" + (leftNumber * rightNumber));
                    right.pop();
                }
                //Divide the two top numbers of middle stack if operator in right stack is (/)
                else if(right.top().equals("/")) {
                    float rightNumber = Float.parseFloat(middle.pop());
                    float leftNumber = Float.parseFloat(middle.pop());
                    middle.push("" + (leftNumber / rightNumber));
                    right.pop();
                }
            }
        }
        
       //Return results
       return Float.parseFloat(middle.pop());
    }
    
    /**
     * 
     * @param postfixExpression post-fix expression
     * @return binary expression tree representation of postfixExpression
     * 
     * This method converts a post-fix expression into a binary expression tree
     */
    public static LinkedBinaryTree<String> postfixToBinaryTree(String postfixExpression) {
        //Declare stacks
        LinkedStack <String> postfix = new LinkedStack();
        LinkedStack <LinkedBinaryTree> expression = new LinkedStack();

        //Store the values from the expression into the postfix stack
        String [] array = postfixExpression.split(" ");
        for(int i = array.length - 1; i >= 0; i--) {
            postfix.push(array[i]);
        }
        
        while(!postfix.isEmpty()) {
            //Make numbers in postfix stack into one-node trees and push them onto expression stack
            if(isNumber(postfix)) {
                LinkedBinaryTree <String> temp = new LinkedBinaryTree();
                temp.addRoot(postfix.pop());
                expression.push(temp);
            }
            //Make binary tree with operator as root and top two trees on expression as left and right children
            else {
                LinkedBinaryTree <String> temp = new LinkedBinaryTree();
                temp.addRoot(postfix.pop());
                LinkedBinaryTree right = expression.pop();
                LinkedBinaryTree left = expression.pop();
                temp.attach(temp.root(), left, right);
                expression.push(temp);
            }
        }
        
        //Return completed binary expression tree
        return expression.pop();
    }
    
    /**
     * 
     * @param expression arithmetic expression
     * 
     * This method checks to see if the expression is valid or not and throws an error if it is not valid
     */
    private static void checkExpression(String expression) {
        //Check if brackets are in order
        if(!LinkedStack.isMatched(expression)) {
            throw new IllegalArgumentException ("Invalid Expression");
        }
        
        //Declare stack
        LinkedStack <String> stack = new LinkedStack();

        //Store the values from the expression into the stack
        String [] array = expression.split(" ");
        for(int i = array.length - 1; i >= 0; i--) {
            stack.push(array[i]);
        }
        
        //Check if expression starts with an operator
        if(isOperator(stack)) {
            throw new IllegalArgumentException ("Invalid Expression");
        }
        
        //Enter loop to check if expression is valid
        while(stack.size() != 1) {
            //Check for errors such as "4 4" and "4 ("
            if(isNumber(stack)) {
                stack.pop();
                if(isNumber(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
                if(isOpenBracket(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
            }
            
            //Check for errors such as "+ /" and "* )"
            else if(isOperator(stack)) {
                stack.pop();
                if(isOperator(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
                if(isClosedBracket(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
            }
            
            //Check for errors such as ") 3"
            else if (isClosedBracket(stack)) {
                stack.pop();
                if(isNumber(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
            }
            
            //Check for errors such as "( +"
            else if (isOpenBracket(stack)) {
                stack.pop();
                if(isOperator(stack)) {
                    throw new IllegalArgumentException ("Invalid Expression");
                }
            }
        }
        
        if(isOperator(stack)) {
            throw new IllegalArgumentException ("Invalid Expression");
        }
    }
    
    /**
     * 
     * @param stack stack to check the top of
     * @return if the top of the stack is an operator or not
     */
    private static boolean isOperator(Stack <String> stack) {
        return stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/");
    }
    
    /**
     * 
     * @param stack stack to check the top of
     * @return if the top of the stack is an open bracket or not
     */
    private static boolean isOpenBracket(Stack <String> stack) {
        return stack.top().equals("(") || stack.top().equals("{") || stack.top().equals("[");
    }
    
    /**
     * 
     * @param stack stack to check the top of
     * @return if the top of the stack is a closed bracket or not
     */
    private static boolean isClosedBracket(Stack <String> stack) {
        return stack.top().equals(")") || stack.top().equals("}") || stack.top().equals("]");
    }
    
    /**
     * 
     * @param stack stack to check the top of
     * @return if the top of the stack is a number or not
     */
    private static boolean isNumber(Stack <String> stack) {
            try{
                Float.parseFloat(stack.top());
                return true;
            } catch(NumberFormatException e){}
            
            return false;
    }
    
    /**
     * 
     * @param right stack to check the top of
     * @param middle stack to check to top of
     * @return if operator in right has higher precedence than the operator in middle or not
     */
    private static boolean compareOperators(Stack <String> right, Stack <String> middle) {
        int rightNumber = 0;
        int middleNumber = 0;
        
        switch(right.top()) {
            case "+", "-" -> rightNumber = 1;
            case "*", "/" -> rightNumber = 2;
        }
        
        switch(middle.top()) {
            case "+", "-" -> middleNumber = 1;
            case "*", "/" -> middleNumber = 2;
        }
        
        return rightNumber > middleNumber;
    }
}