package com.ysk.STABLE_REMIND_MOVE;
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
	String tablename = "STABLEREMIND_MOVE";
	String tablename2 = "STABLEREMIND";
	public String getDefaultValue(String value)throws Throwable{
		String table_PNO = getValue("table1.PNO");
		String[] field = {"MPNO","EMPID","DATE","CAUSE","MOVE_TYPE","HURRY_PEOPLE","VERIFICATION","SAMPLE_POINT"};
		//���oSTABLEREMIND_MOVE�Ҧ�����setValue�Ҧ����
		setDetail(tablename, field, table_PNO);
		//���oEMPID�m�W�A������setValue�m�W�A����
		String MPNO = getValue("MPNO").trim();
    	//���o�~�W�ó]�w
		String sql = "select PRODUCT_NAME from STABLEREMIND where PNO='"+MPNO+"'";
		talk t = getTalk();
		String r[][] = t.queryFromPool(sql);
		setValue("PRODUCT_NAME",r[0][0]);
		//�d�߲��������W��
		String MOVE_TYPE = getValue("MOVE_TYPE");
		String HURRY_PEOPLE = getValue("HURRY_PEOPLE");
		String type = "select MOVE_TYPE from STABLEREMIND_MOVE_TYPE_LIST where TYPE='"+MOVE_TYPE+"'";
		String TYPE[][] = t.queryFromPool(type);
		setValue("TYPE",TYPE[0][0]);
		if(MOVE_TYPE.equals("A")){
			setVisible("HURRY_PEOPLE", true);
			setVisible("HURRY_NAME", true);
			_hproc h = new _hproc();
			String name[][] = user_info_view2(HURRY_PEOPLE);
			setValue("HURRY_NAME",name[0][0]);
		}else if(MOVE_TYPE.equals("B")){
			setVisible("VERIFICATION", true);
		}else if(MOVE_TYPE.equals("C")){
			setVisible("SAMPLE_POINT", true);
		}
		

		return value;
	}
	public String getInformation(){
		return "---------------null(null)..defaultValue()----------------";
	}
}
