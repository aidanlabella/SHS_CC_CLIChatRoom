/** 
 * This interface will contain constant strings that define
 * the protocol used for clients to communicate with the server
 */
public interface Protocol {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // TCP "Handshake"
    public static String OK = "OK";

    // Indicates to the server that there is a new message waiting
    public static String NEW_MSG = "NEW_MSG";

    public static String NAME = "NAME";
    public static String COLOR = "COLOR";
    public static String WELCOME = "WELCOME";
}
