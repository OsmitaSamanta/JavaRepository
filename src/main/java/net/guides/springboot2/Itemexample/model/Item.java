package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	private long id;
	private String itemDesc;
	private long quantity;
	private long unit;
	private long price;
	
	public Item() {
		
	}
	
	public Item(String itemDesc, long quantity, long unit) {
		this.itemDesc = itemDesc;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "item_desc", nullable = false)
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	@Column(name = "quantity", nullable = false)
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "unit", nullable = false)
	public long getUnit() {
		return unit;
	}

	public void setUnit(long unit) {
		this.unit = unit;
	}
	@Column(name = "price", nullable = false)
	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	

	

	

	
	
}
