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
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准報廢"
		flowService = new OA314FlowService(this);
		talk t = getTalk();
		String PNO = getValue("PNO");
		setValue("STATUS","2");
		String STATUS = getValue("STATUS");
		String sql = "update FQ_INSTRUMENT_REMIND set STATUS='" + STATUS + "' where PNO='" + PNO + "'";
		t.execFromPool(sql);
		message("報廢完成");
		//送出mail
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		String[][] get_tot_user = getFlowHistory();
		String title = flowService.getMailSubject(empid, name);
		String content = "4Q驗證及儀器定期保養提醒單報廢通知"
				+ "\r\n";
		content += "單        號：" + PNO.trim() + "\r\n";
		content += "員工編號：" + empid.trim() + "\r\n";
		content += "姓　　名：" + name.trim() + "\r\n";
		content += "部　　門：" + DEPT_NAME.trim() + "\r\n";
		content += "申請日期：" + M_DATE.trim() + "\r\n";
		content += "設備名稱：" + INSTRUMENT_NAME.trim() + "\r\n";
		content += "儀器編號：" + INSTRUMENT_NO.trim() + "\r\n";
		content += "狀態別： 2.報廢\r\n";
		content += "簽核意見：" + getMemo() + "\r\n";
		sendallmail(t, get_tot_user, title, content, flowService);
		return true;
	}
	public String getInformation(){
		return "---------------\u6838\u51c6\u5831\u5ee2.preProcess()----------------";
	}
}
