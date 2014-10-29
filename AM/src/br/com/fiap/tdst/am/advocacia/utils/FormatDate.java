package br.com.fiap.tdst.am.advocacia.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class FormatDate {

	
	public static Date getData(String dataString){
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//formato de data

		java.util.Date date = null;
			try {
					date = sdf.parse(dataString);
			} catch (ParseException e) {
					e.printStackTrace();
			}
		java.sql.Date dataDespesa = new java.sql.Date(date.getTime());
		
		
		return dataDespesa;
		
		
	}
}
