package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._bNotify;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class table_add_data extends _bNotify{
	public void actionPerformed(String value)throws Throwable{
		// ����槹 Transaction ��,�|���楻�q�{��
		//�i�ΥH�H�oEmail�q���άO�۰ʦA�B�z�۩wTransaction
		String[][] getData = getTableData("table1");
		String MOVE_TYPE = getValue("MOVE_TYPE");
		String[] check_field = new String[4];
		if(MOVE_TYPE.equals("1.��ʤH������")){
			check_field[0] = "MOVE_TYPE";
			check_field[1] = "HURRY_PEOPLE";
			check_field[2] = "";
			check_field[3] = "";
		}else if(MOVE_TYPE.equals("2.�L�����T�{")){
			check_field[0] = "MOVE_TYPE";
			check_field[1] = "";
			check_field[2] = "VERIFICATION";
			check_field[3] = "";
		}else if(MOVE_TYPE.equals("3.�������ˤ��")){
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