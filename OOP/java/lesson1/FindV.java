class FindV{
    public static void main(String args[]) {
	// Расстояние между объектами (км):
	double S1=100;
	double S2=200;
	// Скорость на первом участке (км/ч):
	double V1=80;
	// Средняя скорость (км/ч):
	double V=48;
	/* Скорость на втором участке, общее время движения
	   и время движения на первом участке:*/
	double V2,T,t;
	// Общее время движения (час):
	T=(S1+S2)/V;
	// Время движения на первом участке (час):
	t=S1/V1;
	// Скорость движения на втором участке (км/ч):
	V2=T>t?(S1+S2)/(T-t):-1;
	System.out.println("Скорость на втором участке:");
	// Результат:
	System.out.println(V2<0?"Это невозможно!":V2+" км/ч");
    }
}
