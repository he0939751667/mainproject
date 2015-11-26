package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

import com.ysk.OA314.OA314FlowService;
import com.ysk.field.Mail;
public class add extends _hproc {
	String tablename = "FQ_INSTRUMENT_REMIND";
	OA314FlowService flowService;
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		flowService = new OA314FlowService(this);
		talk t = getTalk();
		//���o�U��쪺��
		String PNO = getValue("PNO");
		String EMPID = getValue("EMPID");
		String name = getName(EMPID);
		String DEP_NAME = getValue("DEP_NAME");
		String DATE = getValue("DATE");
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		String TYPE = getValue("TYPE");
		String STATUS = getValue("STATUS");
		String SCRAP_DATE = getValue("SCRAP_DATE");	
		//��g�g�J��Ʈw�����
		String[] field = { "PNO","EMPID", "DATE", "INSTRUMENT_NAME", "INSTRUMENT_NO",
				"STATUS", "SCRAP_DATE" };
		String[] field_data = { EMPID, DATE, INSTRUMENT_NAME, INSTRUMENT_NO, STATUS,
				SCRAP_DATE };
		//��g�n���������
		String[] forget_data = { PNO, EMPID, DATE, INSTRUMENT_NAME, INSTRUMENT_NO,STATUS};
		String[] forget_data_name = { "�渹", "���u�s��", "�ӽФ��", "�]�ƦW��", "�]�ƽs��","���A�O" };
		// �w��forget�A������줣�o����
		Boolean forget = forget_field(forget_data,forget_data_name);
		if(forget==false) return value;
		// �s�W�ܸ�Ʈw
		add_data(tablename,field,field_data);
		//email���e
		String content = "" + "�жi�J�t��(" + Mail.getOaSystemUrl() + ") ñ��"
				+ "\r\n";
		content += "��        ���G" + PNO.trim() + "\r\n";
		content += "���u�s���G" + EMPID.trim() + "\r\n";
		content += "�m�@�@�W�G" + name.trim() + "\r\n";
		content += "���@�@���G" + DEP_NAME.trim() + "\r\n";
		content += "�ӽФ���G" + DATE.trim() + "\r\n";
		content += "�]�ƦW�١G" + INSTRUMENT_NAME.trim() + "\r\n";
		content += "�����s���G" + INSTRUMENT_NO.trim() + "\r\n";
		if(STATUS.equals("1")){
			content += "���A�O�G 1.���`�ϥ�\r\n";
		}else{
			content += "���A�O�G 2.���o\r\n";
		}
		sendMail(t,EMPID,flowService,content);
		//��g�n�M�Ū����
		String clear_field[] = {"DATE","INSTRUMENT_NAME","INSTRUMENT_NO","STATUS"};
		Clear_field(t, clear_field);
		Process_PNO(t,tablename);
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u63d0\u4ea4\u7533\u8acb).html_action()----------------";
	}
}
