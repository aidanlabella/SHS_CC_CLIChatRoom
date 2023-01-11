import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatRoomClient {
    private static final String HOST = "localhost";
    private static final int PORT = 800;

    //HINT: You will want to have object references here.

    public ChatRoomClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

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

            //TODO: Part 4, this is where you will use the protocol to
            //set your name, color and send a welcome message.
            //You can use the last two lines where the "handshake" was
            //completed as a refetence
        }      
    }

    public String getMessage() {
        //TODO: PART 3: use the class you found in PART 1 to get a message from the socket
        return new String();
    }

    public void writeMessage(String string) {
        //TODO: PART 2: use the class you found in PART 1 to pass the string
        // message to the server
    }

    /**
     * The entry point for this application
     *
     * @param {args} command line arguments, none expected
     */
    public static void main(String [] args) {
        ChatRoomClient client = new ChatRoomClient(HOST, PORT);
        
        client.enterChatRoom();

        //TODO: (Bonus) set up the chat room so that you can get text from the user (locally)
        //and send it to the server. You may find the NEW_MSG constant in Protocol useful 
        //for this.
    }
}
