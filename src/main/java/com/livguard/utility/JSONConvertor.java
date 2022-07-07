package com.livguard.utility;

import com.livguard.model.DTOModel.DscRequest;

public class JSONConvertor 
{
	public static DscRequest getDSCode(DscRequest dsCode) {    
		dsCode.setDcode(dsCode.getDcode());
		dsCode.setJobType("get_mydistributor_score");
        return dsCode;    
        }   
}
