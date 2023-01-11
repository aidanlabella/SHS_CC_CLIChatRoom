import java.net.*;
import java.io.*;
import java.util.*;

public class ChatRoomClient {
    private static final String HOST = "192.168.1.106";
    private static final int PORT = 800;

    private Scanner input;
    private PrintStream output;

    public ChatRoomClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            this.input = new Scanner(inputStream);
            this.output = new PrintStream(outputStream);

            //TODO: PART 1: You will need to create an object for both text input and output
            // hint: what is the type of System.in and System.out? Keep in mind these are both
            // static objects that belong to the System class.
            // See https://docs.oracle.com/javase/7/docs/api/java/lang/System.html

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void enterChatRoom() {
         String firstMessage = getMessage();
         if (firstMessage.equals(Protocol.OK)) {
            // This is the "Handshake"
            writeMessage(Protocol.OK);

            writeMessage(Protocol.NAME);
            writeMessage("Aidan");

            if (!getMessage().equals(Protocol.RECIEVED)) return;

            writeMessage(Protocol.COLOR);
            writeMessage(Protocol.ANSI_BLUE);

            if (!getMessage().equals(Protocol.RECIEVED)) return;

            writeMessage(Protocol.WELCOME);
            writeMessage("Go Bison!");

            if (!getMessage().equals(Protocol.RECIEVED)) return;
            //TODO: Part 4, this is where you will use the protocol to
            //set your name, color and send a welcome message.
            //You can use the last two lines where the "handshake" was
            //completed as a refetence
        }      
    }

    public String getMessage() {
        //TODO: PART 3: use the class you found in PART 1 to get a message from the socket
        return this.input.nextLine();
    }

    public void writeMessage(String string) {
        //TODO: PART 2: use the class you found in PART 1 to pass the string
        // message to the server
        this.output.println(string);
    }

    /**
     * The entry point for this application
     *
     * @param {args} command line arguments, none expected
     */
    public static void main(String [] args) {
        ChatRoomClient client = new ChatRoomClient(HOST, PORT);
        
        client.enterChatRoom();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your next message: ");
            client.writeMessage(Protocol.NEW_MSG);
            client.writeMessage(sc.nextLine());
        }

        //TODO: (Bonus) set up the chat room so that you can get text from the user (locally)
        //and send it to the server. You may find the NEW_MSG constant in Protocol useful 
        //for this. 
        //

    }
}
