package com.ysk.OA314;
import setFuntion._hproc;
/**
 * 查詢的功能
 * @author B0052
 *
 */

public class query extends _hproc{
	String tablename = "FQ_INSTRUMENT_REMIND"; //4Q驗證及儀器定期保養提醒單
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value
		String EMPID = getValue("EMPID");
		String PNO = getValue("PNO");
		String MDATE = getValue("SDATE");
		String MDATE1 = getValue("EDATE");
		//queryFuntion 我自己把常用到的程式碼放到自訂的地方以便之後只要把參數代進去即可
		String querydata[][] = queryFuntion(tablename,EMPID, PNO, MDATE, MDATE1);
		setTableData("table1", querydata);
		 return value;
	}
	public String getInformation(){
		return "---------------button2(\u67e5\u8a62).html_action()----------------";
	}
}
