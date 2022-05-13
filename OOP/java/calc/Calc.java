import java.util.regex.*;
import java.util.Stack;
import java.util.HashMap;


public class Calc {
    final static char NUMBER = 'N';
    final static char OPERATOR = '0';
    final static char BRACE_C = ')';
    final static char BRACE_O = '(';
    final static char UNDEFINED = 'U';
    final static HashMap<String, Integer> PRIORITY= getPriority();
    
    public static void main(String args[]) {
	String expr = "1 + 2 * 7 + 4 / 2 - 10"; // 7
	System.out.println(expr);
	System.out.println(exprCalc(expr));
    }

    public static int exprCalc(String expr) {
	String tokens[] = expr.split(" ");
	Stack<Integer> stackNum = new Stack<Integer>();
	Stack<String> stackOp = new Stack<String>();
	if (!isCorrect(tokens))
	    return 0;
	
	
	for (String token: tokens) {
	    if (isNum(token)) {
		stackNum.push(Integer.parseInt(token));
		
	    } else if (token.equals("(")){
		stackOp.push(token);
	    } else if (token.equals(")")){
		while (!stackOp.peek().equals("(")) {
		    calcUpper(stackNum, stackOp);
		}
		stackOp.pop();
	    } else {
    		if (stackOp.empty() || stackOp.peek().equals("(")) {
		    stackOp.push(token);
		    continue;
		}
		
		int curPrior = PRIORITY.get(token);
		int lastPrior = PRIORITY.get(stackOp.peek());
		if (lastPrior < curPrior)
		    stackOp.push(token);
		else {
		    calcUpper(stackNum, stackOp);
		    stackOp.push(token);
		}
	    }

	}
	
	while (!stackOp.empty()) {
	    calcUpper(stackNum, stackOp);
	}
	return stackNum.pop();
    }

    public static boolean isCorrect(String tokens[]) {
	char lastType = UNDEFINED;
	Stack<String> stackToken = new Stack<String>();
	stackToken.push("");
	Stack<String> braces = new Stack<String>();
	for (String token: tokens) {
	    char tokenType = getTokenType(token);

	    if (tokenType == UNDEFINED) {
		System.out.println("Неизвестный символ - " + token);
		return false;
	    } else if (tokenType == NUMBER) {
		if (lastType == NUMBER || lastType == BRACE_C) {
		    System.out.println("Неправильный порядок: " + stackToken.pop() + " " + token);
		    return false;
		}
	    }  else if (tokenType == BRACE_O) {
		if (lastType == BRACE_C || lastType == NUMBER) {
		    System.out.println("Неправильный порядок: " + stackToken.pop() + " " + token);
		    return false;
		}
		braces.push(token);
	    } else if (tokenType == BRACE_C) {
		if (lastType == OPERATOR || lastType == UNDEFINED || lastType == BRACE_O) {
		    System.out.println("Неправильный порядок: " + stackToken.pop() + " " + token);
		    return false;
		}

		if (braces.empty()) {
		    System.out.println("Не хватает скобочки (");
		    return false;
		}
		braces.pop();
	    } else if (tokenType == OPERATOR) {
		if (lastType != NUMBER && lastType != BRACE_C) {
		    System.out.println("Неправильный порядок: " + stackToken.pop() + " " + token);
		    return false;
		}
	    }
	    lastType = tokenType;
	    stackToken.push(token);
	}
	if (!braces.empty()) {
	    System.out.println("Не хватает скобочки )");
	    return false;
	}
	return true;
    }

    public static char getTokenType(String token) {
	
	if (isNum(token))
	    return NUMBER;
	if (token.equals(")"))
	    return BRACE_C;
	if (token.equals("("))
	    return BRACE_O;
	if (PRIORITY.containsKey(token))
	    return OPERATOR;
	return UNDEFINED;
    }
    public static HashMap<String, Integer> getPriority() {
	HashMap<String, Integer> PRIORITY= new HashMap<String, Integer>();
	PRIORITY.put("+", 1);
	PRIORITY.put("-", 1);
	PRIORITY.put("*", 2);
	PRIORITY.put("/", 2);
	return PRIORITY;
    }

    public static void calcUpper(Stack<Integer> stackNum, Stack<String> stackOp) {
	int r_op = stackNum.pop();
	int l_op = stackNum.pop();
	int result = binCalc(l_op, r_op, stackOp.pop());
	stackNum.push(result);
    }
    
    public static boolean isNum(String str) {
	return str.matches("[-+]?\\d+");
    }
    
    public static int binCalc(int a, int b, String op) {
	int result;
	switch (op) {
	case "+":
	    result = a + b;
	    break;
	case "-":
	    result = a - b;
	    break;
	case "*":
	    result = a * b;
	    break;
	case "/":
	    result = a / b;
	    break;
	default:
	    result = 0;
	}
	return result;
    }
}
