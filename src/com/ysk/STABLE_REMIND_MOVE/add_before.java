package com.ysk.STABLE_REMIND_MOVE;
import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_before extends _hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		user_info_view(EMPID);
		setValue("MOVE_TYPE","1.跟催人員異動");
		setEditable("HURRY_PEOPLE",true);
		return value;
	}
	public String getInformation(){
		return "---------------button1(\u65b0\u589e).html_action()----------------";
	}
}
