package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._bNotify;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class table_add_data extends _bNotify{
	public void actionPerformed(String value)throws Throwable{
		// 當執行完 Transaction 時,會執行本段程式
		//可用以寄發Email通知或是自動再處理自定Transaction
		String[][] getData = getTableData("table1");
		String MOVE_TYPE = getValue("MOVE_TYPE");
		String[] check_field = new String[4];
		if(MOVE_TYPE.equals("1.跟催人員異動")){
			check_field[0] = "MOVE_TYPE";
			check_field[1] = "HURRY_PEOPLE";
			check_field[2] = "";
			check_field[3] = "";
		}else if(MOVE_TYPE.equals("2.無完成確認")){
			check_field[0] = "MOVE_TYPE";
			check_field[1] = "";
			check_field[2] = "VERIFICATION";
			check_field[3] = "";
		}else if(MOVE_TYPE.equals("3.延長取樣日期")){
			check_field[0] = "MOVE_TYPE";
			check_field[1] = "";
			check_field[2] = "";
			check_field[3] = "SAMPLE_POINT";
		}		
		if(getData[0][0].length()==0){
			set_first_table_data(check_field);
		}else{
			set_total_table_data(getData,check_field);
		}
		return;
	}
	public String getInformation(){
		return "---------------table1()appendTrigger()----------------";
	}
}