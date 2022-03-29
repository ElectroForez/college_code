package Entities;

public class Lecture {
    private String name, data, aud, time, group, info;
    
    public static void main(String args[]) {
    }

    public void create(String name, String data, String aud, String time, String group) {
	this.name = name;
	this.data = data;
	this.aud = aud;
	this.time = time;
	this.group = group;
    }

    public void removeLek() {
	this.name = null;
	this.data = null;
	this.aud = null;
	this.time = null;
	this.group = null;
    }

    public void getInfo() {
	System.out.println(info);
    }

    public void setInfo(String info) {	
	this.info = info;
    }

    public Lecture copy() {
	return this;
    }    
}
