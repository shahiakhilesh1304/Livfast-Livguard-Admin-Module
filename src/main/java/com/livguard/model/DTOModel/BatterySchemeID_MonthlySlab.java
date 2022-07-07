package com.livguard.model.DTOModel;

import org.springframework.stereotype.Component;

@Component
public class BatterySchemeID_MonthlySlab 
{
	
	
	private int id;

	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	
	/**
	 * @param id
	 */
	public BatterySchemeID_MonthlySlab(int id) {
		this.id = id;
	}

	
	
	/**
	 * 
	 */
	public BatterySchemeID_MonthlySlab() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "BatterySchemeID_MonthlySlab [id=" + id + "]";
	}
	
}
