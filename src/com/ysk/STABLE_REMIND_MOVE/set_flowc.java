package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class set_flowc extends _hproc {
	String tablename = "STABLEREMIND";
	String tablename2 = "STABLEREMIND_MOVE_TYPE_LIST";

	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		try{
			talk t = getTalk();
			String EMPID = getValue("EMPID");
			String MPNO = getValue("MPNO");
			String field[] = { "PRODUCT_NAME" };
			selectfield(tablename, field, MPNO);
			user_info_view(EMPID);
			String MOVE_TYPE = getValue("MOVE_TYPE");
			String sql = "select MOVE_TYPE from STABLEREMIND_MOVE_TYPE_LIST where TYPE='"
					+ MOVE_TYPE + "'";
			String ret[][] = t.queryFromPool(sql);
			String HURRY_PEOPLE = getValue("HURRY_PEOPLE");
			String[][] HURRY_NAME =user_info_view2(HURRY_PEOPLE);
			setValue("TYPE", ret[0][0]);
			if (MOVE_TYPE.equals("A")) {
				setVisible("HURRY_PEOPLE", true);
				setVisible("HURRY_NAME", true);
				setValue("HURRY_NAME",HURRY_NAME[0][0]);
			} else if (MOVE_TYPE.equals("B")) {
				setVisible("VERIFICATION", true);
				setValue("NO_CONFIRM","Y");
			} else if (MOVE_TYPE.equals("C")) {
				setVisible("SAMPLE_POINT", true);
			}
		}catch(Exception e){
			
		}
		return value;
	}

	public String getInformation() {
		return "---------------text2(FLOWC_STATE).html_action()----------------";
	}
}