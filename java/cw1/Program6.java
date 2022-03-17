public class Program6 {
    public static void main(String atgs[]) {
	Abstact obj = new Abstact();
	obj.setVars(4, 5);
	obj.printVars();
	System.out.println("Sum = " + obj.sumVars());
	System.out.println("Max var = " + obj.maxVar());	
    }
}

class Abstact {
    private int var1, var2;
    
    void printVars() {
	System.out.println("Var1 = " + var1); 
	System.out.println("Var2 = " + var2);
    }
    void setVars(int var1, int var2) {
	this.var1 = var1;
	this.var2 = var2;
    }
    
    int sumVars() {
	return var1 + var2;
    }

    int maxVar() {
	if (var1 > var2)
	    return var1;
	else
	    return var2;
    }	
}
