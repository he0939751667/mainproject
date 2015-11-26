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
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		flowService = new OA314FlowService(this);
		talk t = getTalk();
		//取得各欄位的值
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
		//填寫寫入資料庫的欄位
		String[] field = { "PNO","EMPID", "DATE", "INSTRUMENT_NAME", "INSTRUMENT_NO",
				"STATUS", "SCRAP_DATE" };
		String[] field_data = { EMPID, DATE, INSTRUMENT_NAME, INSTRUMENT_NO, STATUS,
				SCRAP_DATE };
		//填寫要提醒的欄位
		String[] forget_data = { PNO, EMPID, DATE, INSTRUMENT_NAME, INSTRUMENT_NO,STATUS};
		String[] forget_data_name = { "單號", "員工編號", "申請日期", "設備名稱", "設備編號","狀態別" };
		// 預防forget，提醒欄位不得為空
		Boolean forget = forget_field(forget_data,forget_data_name);
		if(forget==false) return value;
		// 新增至資料庫
		add_data(tablename,field,field_data);
		//email內容
		String content = "" + "請進入系統(" + Mail.getOaSystemUrl() + ") 簽核"
				+ "\r\n";
		content += "單        號：" + PNO.trim() + "\r\n";
		content += "員工編號：" + EMPID.trim() + "\r\n";
		content += "姓　　名：" + name.trim() + "\r\n";
		content += "部　　門：" + DEP_NAME.trim() + "\r\n";
		content += "申請日期：" + DATE.trim() + "\r\n";
		content += "設備名稱：" + INSTRUMENT_NAME.trim() + "\r\n";
		content += "儀器編號：" + INSTRUMENT_NO.trim() + "\r\n";
		if(STATUS.equals("1")){
			content += "狀態別： 1.正常使用\r\n";
		}else{
			content += "狀態別： 2.報廢\r\n";
		}
		sendMail(t,EMPID,flowService,content);
		//填寫要清空的欄位
		String clear_field[] = {"DATE","INSTRUMENT_NAME","INSTRUMENT_NO","STATUS"};
		Clear_field(t, clear_field);
		Process_PNO(t,tablename);
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u63d0\u4ea4\u7533\u8acb).html_action()----------------";
	}
}
