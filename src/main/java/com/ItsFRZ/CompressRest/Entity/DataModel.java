package com.ItsFRZ.CompressRest.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "compressdata")
public class DataModel {
	
	public DataModel() {
	}
	
	

	public DataModel(byte[] data) {
		super();
		this.data = data;
	}



	@Id
	private Long id;
	
	private String name;
	@Lob
	private byte[] data;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public byte[] getData() {
		return data;
	}



	public void setData(byte[] data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "DataModel [id=" + id + ", name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
	
	
	
	
}
