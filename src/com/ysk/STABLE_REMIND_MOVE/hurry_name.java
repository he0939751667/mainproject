package com.ysk.STABLE_REMIND_MOVE;
import jcx.jform.hproc;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class hurry_name extends _hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的onChange 的動作 
		// 傳入值 value 
		String EMPID = getValue("HURRY_PEOPLE");
		String ret[][] = user_info_view2(EMPID);
		setValue("HURRY_NAME",ret[0][0]);
		 return value;
	}
	public String getInformation(){
		return "---------------HURRY_PEOPLE(\u8ddf\u50ac\u4eba\u54e1\uff1a).html_action()----------------";
	}
}
