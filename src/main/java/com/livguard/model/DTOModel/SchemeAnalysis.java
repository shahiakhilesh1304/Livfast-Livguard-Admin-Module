package com.livguard.model.DTOModel;

import org.springframework.stereotype.Component;

@Component
public class SchemeAnalysis 
{
	private String schemeType;
	private int numberOfScheme;
	/**
	 * @return the schemeType
	 */
	public String getSchemeType() {
		return schemeType;
	}
	/**
	 * @param schemeType the schemeType to set
	 */
	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}
	/**
	 * @return the numberOfScheme
	 */
	public int getNumberOfScheme() {
		return numberOfScheme;
	}
	/**
	 * @param numberOfScheme the numberOfScheme to set
	 */
	public void setNumberOfScheme(int numberOfScheme) {
		this.numberOfScheme = numberOfScheme;
	}

	
	
	@Override
	public String toString() {
		return "SchemeAnalysis [schemeType=" + schemeType + ", numberOfScheme=" + numberOfScheme + "]";
	}

	
	public SchemeAnalysis() {}
	
	
	
	public SchemeAnalysis(String schemeType, int numberOfScheme) {
		super();
		this.schemeType = schemeType;
		this.numberOfScheme = numberOfScheme;
	}
}
