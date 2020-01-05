package general;

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
	//default button background color
	public static final String LIGHT_PINK = "#FFFAFA";
	//default inner panel color
	public static final String LIGHT_ORANGE = "#FFFAF0";
	
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
