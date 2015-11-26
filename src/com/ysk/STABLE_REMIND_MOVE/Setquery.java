package com.ysk.STABLE_REMIND_MOVE;


import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class Setquery extends _hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value 
		//當進入畫面，不為流程時則初始化queryPage
				if(POSITION!=5){
				talk t = getTalk();
				setNewView("queryPage");
				String EMPID = getUser();
				//取得EMPID姓名，部門並setValue姓名，部門
				user_info_view(EMPID);
				String DATE = getToday("YYYYmmdd");
				setValue("SDATE",DATE);
				setValue("EDATE",DATE);
				}
		 return value;
	}
	public String getInformation(){
		return "---------------text3(text3).html_action()----------------";
	}
}
