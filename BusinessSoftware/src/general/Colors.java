package general;

import java.awt.Color;

public class Colors {
	
	public static final String LIGHT_YELLOW = "#EFEB0D";
	public static final String LIGHT_GREY = "#F0ECEB";
	public static final String SEXY_BLUE = "#0078D7";
	public static final String LIGHT_PINK = "#FFFAFA";
	
	public static Color parseColor(String hexaColor) {
		return Color.decode(hexaColor);
	}
	
}
