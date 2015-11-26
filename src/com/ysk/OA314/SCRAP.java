package com.ysk.OA314;

import java.io.*;
import java.util.*;

import com.ysk.field.Mail;
import com.ysk.util.DateTimeUtil;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

import com.ysk.OA314.OA314FlowService;
public class SCRAP extends _hproc {
	OA314FlowService flowService;
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		flowService = new OA314FlowService(this);
		talk t = getTalk();
		String PNO = getValue("PNO");
		String SCRAP_DATE = getValue("SCRAP_DATE");
		if (SCRAP_DATE.length() == 0) {
			message("請填寫報廢日期!");
			return value;
		}
		Vector SQL = new Vector();
		String sql = "update FQ_INSTRUMENT_REMIND set SCRAP_DATE='" + SCRAP_DATE + "' where PNO='" + PNO + "'";
		SQL.addElement(sql);

		String MUSER = getUser();
		String chief = "品保課主管";
		String now = getNow();
		String sc1 = "update FQ_INSTRUMENT_REMIND_FLOWC set F_INP_STAT='"+chief+"',F_INP_TIME='"+now+"',F_INP_INFO='報廢'";
		sc1 += " where PNO='"+PNO+"'";
		String sc2 = "insert into FQ_INSTRUMENT_REMIND_FLOWC_HIS (PNO,F_INP_STAT,F_INP_ID,F_INP_TIME,F_INP_INFO)";
		sc2 += "values ('" + PNO + "','報廢','" + MUSER + "','" + now
				+ "','保養計畫檔')";
		String now1 = DateTimeUtil.getApproveAddSeconds(1);
		String sc3 = "insert into FQ_INSTRUMENT_REMIND_FLOWC_HIS (PNO,F_INP_STAT,F_INP_ID,F_INP_TIME,F_INP_INFO)";
		sc3 += "values ('" + PNO + "','"+chief+"','" + MUSER + "','" + now1
				+ "','報廢')";

		SQL.addElement(sc1);
		SQL.addElement(sc2);
		SQL.addElement(sc3);
		String se[] = new String[SQL.size()];
		for (int i = 0; i < SQL.size(); i++) {
			String sqle = SQL.elementAt(i).toString();
			se[i] = sqle.trim();
		}
		t.execFromPool(se);
		//email
		String DATE = getValue("DATE");
		String EMPID = getValue("EMPID");
		String name = getName(EMPID);
		String DEP_NAME = getValue("DEP_NAME");
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		message("報廢日期填寫完成!");
		String content = "報廢通知" + "請進入系統(" + Mail.getOaSystemUrl() + ") 簽核"
				+ "\r\n";
		content += "單        號：" + PNO.trim() + "\r\n";
		content += "員工編號：" + EMPID.trim() + "\r\n";
		content += "姓　　名：" + name.trim() + "\r\n";
		content += "部　　門：" + DEP_NAME.trim() + "\r\n";
		content += "申請日期：" + DATE.trim() + "\r\n";
		content += "設備名稱：" + INSTRUMENT_NAME.trim() + "\r\n";
		content += "儀器編號：" + INSTRUMENT_NO.trim() + "\r\n";
		sendMail(t, EMPID, flowService, content);
		return value;
	}

	public String getInformation() {
		return "---------------button2(\u5831\u5ee2).html_action()----------------";
	}
}
