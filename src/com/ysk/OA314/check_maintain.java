package com.ysk.OA314;
import jcx.jform.hproc;
import java.io.*;
import java.util.*;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_maintain extends hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的onChange 的動作 
		// 傳入值 value 
		try{	
			talk t = getTalk();
			String EMPID = getValue("MAINTAIN_PERSON");
			String sql = "select hecname,dep_name from user_info_view where empid='"+EMPID+"'";
			String ret[][] = t.queryFromPool(sql);
			setValue("MAINTAIN_NAME",ret[0][0]);
		}catch(Exception e){
			
		}
		 return value;
	}
	public String getInformation(){
		return "---------------MAINTAIN_PERSON(\u7dad\u8b77\u4eba\u54e1\uff1a).html_action()----------------";
	}
}
