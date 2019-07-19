package com.tedu.jt.web;
/**
 * ��Ʒ��Ϣ��
 */
public class Product {
	private int id;	//��Ʒ���
	private String name;	//��Ʒ����
	private String category;	//��Ʒ����
	private double price;	//��Ʒ����
	private int pnum;	//��Ʒ�������
	private String description;	//��Ʒ����
	
	public Product(){}
	public Product(int id, String name, String category, double price, int pnum, String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.pnum = pnum;
		this.description = description;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", pnum=" + pnum
				+ ", description=" + description + "]";
	}
}
