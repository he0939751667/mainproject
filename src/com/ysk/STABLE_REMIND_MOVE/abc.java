package com.ysk.STABLE_REMIND_MOVE;
import jcx.jform.hproc;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class abc extends _hproc{
	String tablename = "STABLEREMIND";
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value 
		String MPNO = getValue("MPNO").trim();
		//取得品名及相關資料並設定
		String sql = "select PRODUCT_NAME from STABLEREMIND where PNO='"+MPNO+"'";
		talk t = getTalk();
		String r[][] = t.queryFromPool(sql);
		setValue("PRODUCT_NAME",r[0][0]);
		 return value;
	}
	public String getInformation(){
		return "---------------text2(text2).html_action()----------------";
	}
}
