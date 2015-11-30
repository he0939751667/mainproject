package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._bNotify;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class table_add_detail extends _bNotify{
	public void actionPerformed(String value)throws Throwable{
		// 當執行完 Transaction 時,會執行本段程式
		//可用以寄發Email通知或是自動再處理自定Transaction
		String[][] getData = getTableData("table1");
		String MPNO = getData[0][0];
		
		String[] field = { "MPNO","INS_NO", "MAINTAIN_TYPE", "MAINTAIN_PERSON",
				"MAINTAIN_ITEM", "MAINTAIN_CYCLE", "LASTTIME_MA_DATE",
				"NEXT_MA_DATE" };
		String[] cleardata = {"MAINTAIN_NAME", "MAINTAIN_TYPE", "MAINTAIN_PERSON",
				"MAINTAIN_ITEM", "MAINTAIN_CYCLE", "LASTTIME_MA_DATE",
				"NEXT_MA_DATE"};
		if(MPNO.length()==0){
			set_first_table_data(field);
			clear_field(cleardata);
		}else{
			set_total_table_data(getData,field);
			clear_field(cleardata);
		}
		return;
	}
	public String getInformation(){
		return "---------------table1()appendTrigger()----------------";
	}
}
