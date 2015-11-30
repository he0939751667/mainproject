package com.ysk.STABLE_REMIND_MOVE;

import javax.swing.*;

import setFuntion._bTransaction;

import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class detail_add_before extends _bTransaction {
	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的作業
		// 回傳值為 false 表示接下來不執行任何指令
		String MOVE_TYPE = getValue("MOVE_TYPE");
		boolean check_null = false;
		if (MOVE_TYPE.equals("1.跟催人員異動")) {
			String[] field = { "HURRY_PEOPLE" };
			String[] field_name = { "跟催人員" };
			check_null = check_field(field, field_name);
		} else if (MOVE_TYPE.equals("2.無完成確認")) {
			String[] field = { "VERIFICATION" };
			String[] field_name = { "驗證總結" };
			check_null = check_field(field, field_name);
		} else if (MOVE_TYPE.equals("3.延長取樣日期")) {
			String[] field = { "SAMPLE_POINT" };
			String[] field_name = { "抽樣點" };
			check_null = check_field(field, field_name);
		}
		if(check_null==false) return false;
		return true;
	}

	public String getInformation() {
		return "---------------table1()appendProgram()----------------";
	}
}