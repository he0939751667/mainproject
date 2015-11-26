package com.ysk.STABLE_REMIND_MOVE;

import jcx.jform.hproc;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_PNO extends _hproc {
	String tablename = "STABLEREMIND";
	String tablename2 = "STABLEDETAIL";

	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的onChange 的動作
		// 傳入值 value
		try{
		talk t = getTalk();
		String MPNO = getValue("MPNO").trim();
		// 取得品名及相關資料並設定
		String field[] = { "PRODUCT_NAME", "HURRY_PEOPLE", "VERIFICATION" };
		String ret[][] = selectfield(tablename, field, MPNO);
		try {
			String getname[][] = user_info_view2(ret[0][1]);
			setValue("HURRY_NAME", getname[0][0]);
		} catch (Exception e) {

		}

		String field2[] = { "SAMPLE_POINT" };
		selectfield(tablename2, field2, MPNO);
		}catch(Exception e){
			
		}
		return value;
	}

	public String getInformation() {
		return "---------------PNO(\u55ae\u865f\uff1a).html_action()----------------";
	}
}
