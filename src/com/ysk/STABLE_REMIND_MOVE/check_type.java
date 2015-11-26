package com.ysk.STABLE_REMIND_MOVE;
import jcx.jform.hproc;
import java.io.*;
import java.util.*;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_type extends hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的onChange 的動作 
		// 傳入值 value 
		talk t = getTalk();
		String TYPE = getValue("MOVE_TYPE");
		String sql = "select TYPE from STABLEREMIND_MOVE_TYPE_LIST a where a.MOVE_TYPE='"+TYPE+"'";
		String ret[][] = t.queryFromPool(sql);
		if(ret[0][0].equals("A")){
			setEditable("HURRY_PEOPLE",true);
			setEditable("VERIFICATION",false);
			setEditable("SAMPLE_POINT",false);
		}else if(ret[0][0].equals("B")){
			setEditable("HURRY_PEOPLE",false);
			setEditable("VERIFICATION",true);
			setEditable("SAMPLE_POINT",false);
			setValue("NO_CONFIRM","Y");
		}else if(ret[0][0].equals("C")){
			setEditable("HURRY_PEOPLE",false);
			setEditable("VERIFICATION",false);
			setEditable("SAMPLE_POINT",true);
		}
		 return value;
	}
	public String getInformation(){
		return "---------------MOVE_TYPE(\u7570\u52d5\u985e\u5225\uff1a).html_action()----------------";
	}
}
