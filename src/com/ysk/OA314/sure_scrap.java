package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

import com.ysk.OA314.OA314FlowService;
import com.ysk.field.Mail;
public class sure_scrap extends _bProcFlow{
	OA314FlowService flowService;
	public boolean action(String value)throws Throwable{
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭���o"
		flowService = new OA314FlowService(this);
		talk t = getTalk();
		String PNO = getValue("PNO");
		setValue("STATUS","2");
		String STATUS = getValue("STATUS");
		String sql = "update FQ_INSTRUMENT_REMIND set STATUS='" + STATUS + "' where PNO='" + PNO + "'";
		t.execFromPool(sql);
		message("���o����");
		//�e�Xmail
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		String[][] get_tot_user = getFlowHistory();
		String title = flowService.getMailSubject(empid, name);
		String content = "4Q���Ҥλ����w���O�i��������o�q��"
				+ "\r\n";
		content += "��        ���G" + PNO.trim() + "\r\n";
		content += "���u�s���G" + empid.trim() + "\r\n";
		content += "�m�@�@�W�G" + name.trim() + "\r\n";
		content += "���@�@���G" + DEPT_NAME.trim() + "\r\n";
		content += "�ӽФ���G" + M_DATE.trim() + "\r\n";
		content += "�]�ƦW�١G" + INSTRUMENT_NAME.trim() + "\r\n";
		content += "�����s���G" + INSTRUMENT_NO.trim() + "\r\n";
		content += "���A�O�G 2.���o\r\n";
		content += "ñ�ַN���G" + getMemo() + "\r\n";
		sendallmail(t, get_tot_user, title, content, flowService);
		return true;
	}
	public String getInformation(){
		return "---------------\u6838\u51c6\u5831\u5ee2.preProcess()----------------";
	}
}
