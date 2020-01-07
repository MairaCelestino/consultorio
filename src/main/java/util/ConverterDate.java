package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterDate {
	public static String formatarData(String dataNasc_pac) throws Exception {
		if (dataNasc_pac == null || dataNasc_pac.equals(""))
			return null;

		String dataF = null;
		try {
			DateFormat df = new SimpleDateFormat("dd/mm/aaaa");
			Date date = (java.util.Date) df.parse(dataNasc_pac);
			dataF = df.format(date);
		} catch (ParseException pe) {
			throw pe;
		}
		return dataF;
	}

	public static java.sql.Date formatarData(Date data) throws Exception {
		if (data == null)
			return null;

		java.sql.Date date = null;
		date = new java.sql.Date(data.getTime());

		return date;
	}

	public static Date strToDate(String dataNasc_pac) throws Exception {
		if (dataNasc_pac == null)
			return null;

		Date dataF = null;
		try {
			DateFormat df = new SimpleDateFormat("dd/mm/aaaa");
			dataF = (java.util.Date) df.parse(dataNasc_pac);

		} catch (ParseException pe) {
			throw pe;
		}
		return dataF;
	}
}
