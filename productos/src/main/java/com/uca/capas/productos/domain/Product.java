package com.uca.capas.productos.domain;

public class Product {
	private Integer id;
	private String name;
	private Integer quantity;
	
	public Product(Integer id, String name, Integer quantity) {
		
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
