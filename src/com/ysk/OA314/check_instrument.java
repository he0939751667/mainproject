package com.ysk.OA314;
import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_instrument extends _hproc{
	String tablename = "FQ_INSTRUMENT_REMIND";
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的onChange 的動作 
		// 傳入值 value 
		String PNO = getValue("PNO");
		String[] field = {"INSTRUMENT_NAME","INSTRUMENT_NO"};
		 return value;
	}
	public String getInformation(){
		return "---------------PNO(\u55ae\u865f\uff1a).html_action()----------------";
	}
}
