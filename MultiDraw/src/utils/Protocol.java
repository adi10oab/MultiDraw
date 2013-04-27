package utils;

public interface Protocol {	
	// MISC commands
	public static final byte ALOHA = 1;
	public static final byte SEND_FILE = 2;
	public static final byte CHAT_MESSAGE = 3;
	public static final byte USERLIST= 4;
	
	// Paint commands
	public static final byte DRAW_LINE = 10;
	public static final byte BRUSH_COLOR_1 = 11;
	public static final byte BRUSH_COLOR_2 = 12;
	public static final byte CHANGE_BRUSH_SIZE = 13;
}
