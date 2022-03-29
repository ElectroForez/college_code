import java.util.Scanner;
import java.util.regex.*;

public class Program {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	String number = sc.nextLine();	
	if (!isCorrect(number))
	    return;
	System.out.println(getNextNum(number));
    }
    
    static boolean isNum(char sym) {
	if (sym >= '0' && sym <= '9')
	    return true;
	else
	    return false;
    }
    
    static boolean reMatch(String str, String regex) {
	return Pattern.compile(regex).matcher(str).matches();
    }
    
    static String specialCases(String str) {
	char[] tempArray = str.toCharArray();
	if (reMatch(str, "0*")) {
	    tempArray[tempArray.length - 1] = '1';
	} else if (reMatch(str, "Z*")) {
	    for (int j = 0; j < tempArray.length; j++)
		tempArray[j] = 'A';
	}
	str = new String(tempArray);
	return str;
    }
    
    static String getNextNum(String num) {
 	final char inNum = '1';
	final char inLetter = '0';	
	String newNum = "";
	char status = inNum;
	char[] chArray = num.toCharArray();
	String temp = "";
	char needChange = '1';
	boolean statusChanged = false;
	for (int i = chArray.length - 1; i >= 0; i--) {
	    if (status == inNum){
		if(!isNum(chArray[i])){
		    statusChanged = true;
		    status = inLetter;
		}
	    }  else if (status == inLetter) {
		if (isNum(chArray[i])){
		    statusChanged = true;
		    status = inNum;
		}
	    }
	    
	    char add_sym;
	    if (needChange == '1') {
		if (statusChanged)
		    temp = specialCases(temp);
		add_sym = getNextSym(chArray[i])[0];
		needChange = getNextSym(chArray[i])[1];
	    } else {
		add_sym = chArray[i];
		needChange = '0';
	    }

	    if (statusChanged) {
		statusChanged = false;
		newNum = temp + newNum;
		temp = "";
	    }
	    temp = add_sym + temp;
	}
	temp = specialCases(temp); 
	newNum = temp + newNum;
	return newNum;
    }
    
    static char[] getNextSym(char sym) {
	int code_sym = sym;
	if (isNum(sym)) {
	    if (sym == '9')
		return new char[] {'0', '1'};
	    return new char[] {(char)(code_sym + 1), '0'};
	}
	if (sym >= 'A' && sym <= 'Z') {
	    if (sym == 'Z')
		return new char[] {'A', '1'};
	    return new char[] {(char)(code_sym + 1), '0'};
	}
	return null;
    }
    
    static boolean isCorrect(String number) {
	String regex = "^\\d{2}[A-Z]{2}\\d{2}$";
	if (!reMatch(number, regex)) {
	    System.out.println("Неверный формат номера");
	    return false;
	}
	
	Pattern sub_pattern = Pattern.compile("\\d+");
	Matcher sub_matcher = sub_pattern.matcher(number);
	while(sub_matcher.find()) {
	    String group = sub_matcher.group();
	    String nulls_reg = "0+";
	    if (reMatch(group, nulls_reg)) {
		System.out.println(group + " недопустимо");
		return false;
	    }
	}
	return true;
    }
}    
