package mitarbeiter.dao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

import general.code.GeschaeftDB;

public class Printjob implements Printable {
	String grund;
	String namemit;

	public Printjob(String grundKundigung, String name) {
		grund=grundKundigung;
		namemit=name+",";
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
		if(pageIndex>0) {
		return NO_SUCH_PAGE;	
		}
		Graphics2D graphics2d=(Graphics2D)graphics;
		graphics2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY() );
		String print="Seher geheerte Frau/Herr "+namemit+"\nhermit kundigen wir sie, Datum "+dateFormat.format(date)+"  , da "+grund+"                              \n\nmit freundlichen Grüßen \n"+GeschaeftDB.getInstance().getCurrentAccountName();
		System.out.println(namemit);
		deowString(graphics, print,100,100, graphics2d);
		return PAGE_EXISTS;
}
	private void deowString(Graphics graphics,String string,int x,int y,Graphics2D graphics2d) {
		for (String line : string.split("\n")) {
			graphics2d.drawString(line, x, y +=graphics2d.getFontMetrics().getHeight());
		
			
		}
	}
}
