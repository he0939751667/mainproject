package com.ysk.OA314;
import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class update_maintain extends _hproc{
	String tablename = "FQ_INSTRUMENT_DETAIL";
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value
		String PNO = getValue("MPNO");
		String[] field = {"INS_NO", "MAINTAIN_TYPE",
				"MAINTAIN_PERSON", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
				"LASTTIME_MA_DATE", "NEXT_MA_DATE"};
		String[] field_data = new String[field.length];
		for(int i=0;i<field_data.length;i++){
			field_data[i]=getValue(field[i]);
		}
		update_data(tablename, field, field_data, PNO);
		 return value;
	}
	public String getInformation(){
		return "---------------button1(\u4fee\u6b63).html_action()----------------";
	}
}
