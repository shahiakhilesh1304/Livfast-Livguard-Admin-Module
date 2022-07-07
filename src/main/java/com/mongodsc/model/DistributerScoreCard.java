package com.mongodsc.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "DistributerScoreCard")
public class DistributerScoreCard 
{
	@Id
	private String id;
	private String key;
	private Object data;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DistributerScoreCard [id=" + id + ", key=" + key + ", data=" + data + "]";
	}
	public DistributerScoreCard(String id, String key, Object data) {
		this.id = id;
		this.key = key;
		this.data = data;
	}
	public DistributerScoreCard() {
		// TODO Auto-generated constructor stub
	}
	
}
