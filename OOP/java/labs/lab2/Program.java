public class Program {
    public static void main(String args[]) {
	Firm firm = new Firm();
	Department dep = new Department();
	dep.setNameFirm("ISIP");
	System.out.println(dep.getNameFirm());
	System.out.println(dep.getNameDepartment());
	System.out.println(dep.numEmployees);
    }
}


class Firm {
    private String nameFirm;
	
    void setNameFirm(String nameFirm) {
	this.nameFirm = nameFirm;
    }
    
    String getNameFirm() {
	return nameFirm;
    }
}

class Department {
    private String nameDepartment;
    static int numEmployees = 0;
    private Firm firm;
    
    void setFirm(Firm firm) {
	this.firm = firm;
    }
    
    String getNameFirm() {
	return firm.getNameFirm();
    }
		       
    void setNameDepartment(String nameDepartment) {
	this.nameDepartment = nameDepartment;
    }
    
    String getNameDepartment() {
	return nameDepartment;
    }
}

class Employess {
    private String FIO;
    private Department department;
     void setDepartment(Department department) {
	this.department = department;
    }
    
    String getNameDepartment() {
	return department.getNameDepartment;
    }
    
    void setFIO(String FIO) {
	this.FIO = FIO;
    }
    
    String getFIO() {
	return FIO;
    }
}
