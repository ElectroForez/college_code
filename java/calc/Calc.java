import java.util.regex.*;
import java.util.Stack;
import java.util.HashMap;


public class Calc {
    final static char NUMBER = 'N';
    final static char OPERATOR = '0';
    final static char BRACE_C = ')';
    final static char BRACE_O = '(';
    final static char UNDEFINED = 'U';
    static HashMap<String, Integer> priority= getPriority();
    
    public static void main(String args[]) {
	String expr = "1 + 2 * 7 + 4 / 2 - 10"; // 7
	System.out.println(expr);
	System.out.println(calc(expr));
    }

    public static int calc(String expr) {
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
		    calc_upper(stackNum, stackOp);
		}
		stackOp.pop();
	    } else {
		int cur_prior = priority.get(token);
		if (stackOp.empty() || stackOp.peek().equals("(")) {
		    stackOp.push(token);
		    continue;
		}
		
		int last_prior = priority.get(stackOp.peek());
		if (last_prior < cur_prior)
		    stackOp.push(token);
		else {
		    calc_upper(stackNum, stackOp);
		    stackOp.push(token);
		}
	    }

	}
	
	while (!stackOp.empty()) {
	    calc_upper(stackNum, stackOp);
	}
	return stackNum.pop();
    }

    public static boolean isCorrect(String tokens[]) {
	char lastType = UNDEFINED;
	Stack<String> all_token = new Stack<String>();
	all_token.push("");
	Stack<String> braces = new Stack<String>();
	for (String token: tokens) {
	    char tokenType = getTokenType(token);

	    if (tokenType == UNDEFINED) {
		System.out.println("Неизвестный символ - " + token);
		return false;
	    } else if (tokenType == NUMBER) {
		if (lastType == NUMBER || lastType == BRACE_C) {
		    System.out.println("Неправильный порядок: " + all_token.pop() + " " + token);
		    return false;
		}
	    }  else if (tokenType == BRACE_O) {
		if (lastType == BRACE_C || lastType == NUMBER) {
		    System.out.println("Неправильный порядок: " + all_token.pop() + " " + token);
		    return false;
		}
		braces.push(token);
	    } else if (tokenType == BRACE_C) {
		if (lastType == OPERATOR || lastType == UNDEFINED || lastType == BRACE_O) {
		    System.out.println("Неправильный порядок: " + all_token.pop() + " " + token);
		    return false;
		}

		if (braces.empty()) {
		    System.out.println("Не хватает скобочки (");
		    return false;
		}
		braces.pop();
	    } else if (tokenType == OPERATOR) {
		if (lastType != NUMBER && lastType != BRACE_C) {
		    System.out.println("Неправильный порядок: " + all_token.pop() + " " + token);
		    return false;
		}
	    }
	    lastType = tokenType;
	    all_token.push(token);
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
	if (priority.containsKey(token))
	    return OPERATOR;
	return UNDEFINED;
    }
    public static HashMap<String, Integer> getPriority() {
	HashMap<String, Integer> priority= new HashMap<String, Integer>();
	priority.put("+", 1);
	priority.put("-", 1);
	priority.put("*", 2);
	priority.put("/", 2);
	return priority;
    }

    public static void calc_upper(Stack<Integer> stackNum, Stack<String> stackOp) {
	int r_op = stackNum.pop();
	int l_op = stackNum.pop();
	int result = calculate_2(l_op, r_op, stackOp.pop());
	stackNum.push(result);
    }
    
    public static boolean isNum(String str) {
	return str.matches("[-+]?\\d+");
    }
    
    public static int calculate_2(int a, int b, String op) {
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
