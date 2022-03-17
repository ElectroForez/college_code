public class LineProgram {
    public static void main(String[] args) {
	printableLine l = new printableLine(0,0,1,1);
	l.x1 = 10;
	l.print();
    }
}

class line {
    protected float x1,y1,x2,y2;
    private float length;
 
    public line(float x1, float y1, float x2, float y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        calculateLength();
    }
 
    private void calculateLength()
    {
        length=(float) Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
 
    public void setX1(float x1) {
        this.x1 = x1;
        calculateLength();
    }
 
    public void setY1(float y1) {
        this.y1 = y1;
        calculateLength();
    }
 
    public void setX2(float x2) {
        this.x2 = x2;
        calculateLength();
    }
 
    public void setY2(float y2) {
        this.y2 = y2;
        calculateLength();
    }
 
    public float getLength() {
        return length;
    }
}

class printableLine extends line {
 
    public printableLine(float x1, float y1, float x2, float y2) {
        super(x1, y1, x2, y2);
    }
    public void print()
    {
        System.out.println("point 1 - ("+this.x1+","+this.y1+")");
        System.out.println("point 2 - ("+this.x2+","+this.y2+")");
    }
}
