package com.ysk.OA314;
import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_before extends _hproc{
	String tablename = "FQ_INSTRUMENT_REMIND";
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		user_info_view(EMPID);
		Process_PNO(t,tablename);
		return value;
	}
	public String getInformation(){
		return "---------------button1(\u65b0\u589e).html_action()----------------";
	}
}
