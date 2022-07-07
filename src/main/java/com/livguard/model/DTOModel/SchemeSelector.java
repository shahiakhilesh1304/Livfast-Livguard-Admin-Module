package com.livguard.model.DTOModel;

public class SchemeSelector {
	
	private String id;
	private String scheme_name;
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
	 * @return the scheme_name
	 */
	public String getScheme_name() {
		return scheme_name;
	}
	/**
	 * @param scheme_name the scheme_name to set
	 */
	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}
	public SchemeSelector(String id, String scheme_name) {
		this.id = id;
		this.scheme_name = scheme_name;
	}
	@Override
	public String toString() {
		return "SchemeSelector [id=" + id + ", scheme_name=" + scheme_name + "]";
	}
	public SchemeSelector() {
		// TODO Auto-generated constructor stub
	}
	

}
