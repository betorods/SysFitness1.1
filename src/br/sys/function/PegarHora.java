package br.sys.function;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alberto
 */
public class PegarHora {

    public String Hora() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss"); 
        Date date = new Date(); 
        return dateFormat.format(date);
    }
}
