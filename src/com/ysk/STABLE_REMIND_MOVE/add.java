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
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		flowService = new OA329FlowService(this);
		talk t = getTalk();
		//取得各欄位的值
		String PNO = getValue("PNO");
		String MPNO = getValue("MPNO");
		String EMPID = getValue("EMPID");
		String name = getName(EMPID);
		String DEP_NAME = getValue("DEP_NAME");
		String DATE = getValue("DATE");
		String CAUSE = getValue("CAUSE");
		
		//取得table的值
		String[][] getData = getTableData("table1");
		for(int i=0;i<getData.length;i++){
			String MOVE_TYPE = getData[i][0];
			//查詢和設定異動類型
			String sql = "select TYPE from STABLEREMIND_MOVE_TYPE_LIST where MOVE_TYPE='"
					+ MOVE_TYPE + "'";
			String r[][] = t.queryFromPool(sql);
			String TYPE = r[0][0];
			//取得異動內容相關資料
			String HURRY_PEOPLE = getData[i][1];
			String VERIFICATION = getData[i][2];
			String SAMPLE_POINT = getData[i][3];
			String[] field = { "PNO","MPNO", "EMPID", "DATE", "CAUSE", "MOVE_TYPE",
					"HURRY_PEOPLE", "VERIFICATION", "SAMPLE_POINT" };
			String[] field_data = { MPNO, EMPID, DATE, CAUSE, TYPE, HURRY_PEOPLE,
					VERIFICATION, SAMPLE_POINT };
			String[] forget_data = { MPNO, EMPID, DATE, CAUSE, MOVE_TYPE};
			String[] forget_data_name = { "單號", "員工編號", "申請日期", "申請原因", "異動類別" };
			// 預防forget，提醒欄位不得為空
			Boolean forget = forget_field(forget_data,forget_data_name);
			if(forget==false) return value;
			// 新增至資料庫
			String ret[][] = add_data(tablename,field,field_data);
		}
		//發送mail
		String content = "";
		content = "\r\n"
				// + "SMTP："+smtp+"\r\n"
				+ "請進入系統("
				+ Mail.getOaSystemUrl()
				+ ") 簽核"
				// + "SENDER："+sender+"\r\n"
				+ "\r\n" + "員工編號：" + EMPID + "  " + name + "\r\n" + "申請日期："
				+ convert.FormatedDate(DATE, "/") + "\r\n" + "部門："
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
