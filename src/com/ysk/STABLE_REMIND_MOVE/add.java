package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

import com.ysk.STABLE_REMIND_MOVE.OA329FlowService;
import com.ysk.field.Mail;
public class add extends _hproc {
	String tablename = "STABLEREMIND_MOVE";
	OA329FlowService flowService;
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		flowService = new OA329FlowService(this);
		talk t = getTalk();
		//���o�U��쪺��
		String PNO = getValue("PNO");
		String MPNO = getValue("MPNO");
		String EMPID = getValue("EMPID");
		String name = getName(EMPID);
		String DEP_NAME = getValue("DEP_NAME");
		String DATE = getValue("DATE");
		String CAUSE = getValue("CAUSE");
		
		//���otable����
		String[][] getData = getTableData("table1");
		for(int i=0;i<getData.length;i++){
			String MOVE_TYPE = getData[i][0];
			//�d�ߩM�]�w��������
			String sql = "select TYPE from STABLEREMIND_MOVE_TYPE_LIST where MOVE_TYPE='"
					+ MOVE_TYPE + "'";
			String r[][] = t.queryFromPool(sql);
			String TYPE = r[0][0];
			//���o���ʤ��e�������
			String HURRY_PEOPLE = getData[i][1];
			String VERIFICATION = getData[i][2];
			String SAMPLE_POINT = getData[i][3];
			String[] field = { "PNO","MPNO", "EMPID", "DATE", "CAUSE", "MOVE_TYPE",
					"HURRY_PEOPLE", "VERIFICATION", "SAMPLE_POINT" };
			String[] field_data = { MPNO, EMPID, DATE, CAUSE, TYPE, HURRY_PEOPLE,
					VERIFICATION, SAMPLE_POINT };
			String[] forget_data = { MPNO, EMPID, DATE, CAUSE, MOVE_TYPE};
			String[] forget_data_name = { "�渹", "���u�s��", "�ӽФ��", "�ӽЭ�]", "�������O" };
			// �w��forget�A������줣�o����
			Boolean forget = forget_field(forget_data,forget_data_name);
			if(forget==false) return value;
			// �s�W�ܸ�Ʈw
			String ret[][] = add_data(tablename,field,field_data);
		}
		//�o�email
		String content = "";
		content = "\r\n"
				// + "SMTP�G"+smtp+"\r\n"
				+ "�жi�J�t��("
				+ Mail.getOaSystemUrl()
				+ ") ñ��"
				// + "SENDER�G"+sender+"\r\n"
				+ "\r\n" + "���u�s���G" + EMPID + "  " + name + "\r\n" + "�ӽФ���G"
				+ convert.FormatedDate(DATE, "/") + "\r\n" + "�����G"
				+ DEP_NAME + "\r\n";
		sendMail(t,EMPID,flowService,content);
		String clear_field[] = {"DATE","MPNO","PRODUCT_NAME","CAUSE","MOVE_TYPE","HURRY_PEOPLE","HURRY_NAME","VERIFICATION","SAMPLE_POINT"};
		Clear_field(t, clear_field);
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u63d0\u4ea4\u7533\u8acb).html_action()----------------";
	}
}
