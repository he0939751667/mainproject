package com.ysk.STABLE_REMIND_MOVE;
import setFuntion._hproc;
/**
 * �d�ߪ��\��
 * @author B0052
 *
 */

public class query extends _hproc{
	String tablename = "STABLEREMIND_MOVE"; //í�w�ʨ��˴������ʳ�
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
