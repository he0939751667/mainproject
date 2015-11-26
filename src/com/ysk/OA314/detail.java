package com.ysk.OA314;
import javax.swing.*;

import setFuntion._bproc;
import setFuntion._hproc;
import jcx.jform.bproc;

import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class detail extends _bproc{
	String tablename = "FQ_INSTRUMENT_REMIND";
	public String getDefaultValue(String value)throws Throwable{
		String table_PNO = getValue("table1.PNO");
		String[] field = {"PNO","EMPID","DATE","INSTRUMENT_NAME","INSTRUMENT_NO","STATUS"};
		//取得STABLEREMIND_MOVE所有欄位並setValue所有欄位
		setDetail(tablename, field, table_PNO);
		String STATUS = getValue("STATUS");
		if(STATUS.equals("1")){
			setValue("TYPE","1.正常使用");			
		}else{
			setValue("TYPE","2.報廢");
		}
		return value;
	}
	public String getInformation(){
		return "---------------null(null)..defaultValue()----------------";
	}
}
