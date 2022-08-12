package com.samples.domain;

public class Product {
	 
	 int id;
	 String PName ;
	 int Pcost;
	 String Pcategory;
	  public Product() {}
	
	
	  public Product(int id, String pName, int pcost, String pcategory) {
		super();
		this.id = id;
		this.PName = pName;
		this.Pcost = pcost;
		this.Pcategory = pcategory;
	}

	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPcost() {
		return Pcost;
	}
	public void setPcost(int pcost) {
		Pcost = pcost;
	}
	public String getPcategory() {
		return Pcategory;
	}
	public void setPcategory(String pcategory) {
		Pcategory = pcategory;
	}
	
	public String toString() {
		return "Product [id=" + id + ", PName=" + PName + ", Pcost=" + Pcost + ", Pcategory=" + Pcategory + "]";
	}
	

}
