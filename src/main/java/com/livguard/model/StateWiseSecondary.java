package com.livguard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "statewise_secondary")

@DynamicInsert
@DynamicUpdate
public class StateWiseSecondary 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="state")
	private String state;
	
	@Column(name="ib_ups_category")
	private int ibUpsCategory;
	
	@Column(name="fourw_category")
	private int fourwCategory;
	
	@Column(name="erick_category")
	private int erickCategory;
	
	public StateWiseSecondary()
	{}

	public StateWiseSecondary(Long id, String state, int ibUpsCategory, int fourwCategory, int erickCategory) {
		//super();
		this.id = id;
		this.state = state;
		this.ibUpsCategory = ibUpsCategory;
		this.fourwCategory = fourwCategory;
		this.erickCategory = erickCategory;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the ibUpsCategory
	 */
	public int getIbUpsCategory() {
		return ibUpsCategory;
	}

	/**
	 * @param ibUpsCategory the ibUpsCategory to set
	 */
	public void setIbUpsCategory(int ibUpsCategory) {
		this.ibUpsCategory = ibUpsCategory;
	}

	/**
	 * @return the fourwCategory
	 */
	public int getFourwCategory() {
		return fourwCategory;
	}

	/**
	 * @param fourwCategory the fourwCategory to set
	 */
	public void setFourwCategory(int fourwCategory) {
		this.fourwCategory = fourwCategory;
	}

	/**
	 * @return the erickCategory
	 */
	public int getErickCategory() {
		return erickCategory;
	}

	/**
	 * @param erickCategory the erickCategory to set
	 */
	public void setErickCategory(int erickCategory) {
		this.erickCategory = erickCategory;
	}

	@Override
	public String toString() {
		return "StateWiseSecondary [id=" + id + ", state=" + state + ", ibUpsCategory=" + ibUpsCategory
				+ ", fourwCategory=" + fourwCategory + ", erickCategory=" + erickCategory + "]";
	}
	
	
}
