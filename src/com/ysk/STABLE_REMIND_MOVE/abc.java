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
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@ 
		// �ǤJ�� value 
		String MPNO = getValue("MPNO").trim();
		//���o�~�W�ά�����ƨó]�w
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
