package com.ysk.OA314;
import setFuntion._hproc;
/**
 * �d�ߪ��\��
 * @author B0052
 *
 */

public class query extends _hproc{
	String tablename = "FQ_INSTRUMENT_REMIND"; //4Q���Ҥλ����w���O�i������
	public String action(String value)throws Throwable{
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@ 
		// �ǤJ�� value
		String EMPID = getValue("EMPID");
		String PNO = getValue("PNO");
		String MDATE = getValue("SDATE");
		String MDATE1 = getValue("EDATE");
		//queryFuntion �ڦۤv��`�Ψ쪺�{���X���ۭq���a��H�K����u�n��ѼƥN�i�h�Y�i
		String querydata[][] = queryFuntion(tablename,EMPID, PNO, MDATE, MDATE1);
		setTableData("table1", querydata);
		 return value;
	}
	public String getInformation(){
		return "---------------button2(\u67e5\u8a62).html_action()----------------";
	}
}
