package general.design;

import java.awt.Color;

/**
 * Created On 19.11.2019
 * @author omare
 *
 */
public class Colors {
	
	public static final String LIGHT_YELLOW = "#EFEB0D";
	//default background color
	public static final String LIGHT_GREY = "#F0ECEB";
	//default text color
	public static final String SEXY_BLUE = "#0078D7";
	public static final String SEXY_RED = "#FF0000";
	//default button background color
	public static final String LIGHT_PINK = "#FFFAFA";
	//default inner panel color
	public static final String LIGHT_ORANGE = "#FFFAF0";
	public static final String RED = "#FF0000";
	public static final String DARK_GREY =  "#6D7373"; 
	
	/**
	 * 
	 * Created By Omar
	 * is used to decode hexacode into a color
	 * 
	 * @param hexaColor hexadecimal color's code to parse
	 * @return the decoded Color from the hexa code
	 */
	public static Color parseColor(String hexaColor) {
		return Color.decode(hexaColor);
	}
	
}
