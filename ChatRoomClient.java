import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class ChatRoomClient {
    private static final String HOST = "localhost";
    private static final int PORT = 800;

    Scanner scanner;
    PrintStream printStream;

    public ChatRoomClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            this.scanner = new Scanner(socket.getInputStream());
            this.printStream = new PrintStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void enter() {
        if (scanner.next().equals(Protocol.OK)) {
            printStream.println(Protocol.OK);

            printStream.println(Protocol.NAME);
            printStream.println("Aidan");

            printStream.println(Protocol.COLOR);
            printStream.println(Protocol.ANSI_CYAN);

            printStream.println(Protocol.WELCOME);
            printStream.println("Hi");
        }
    }

    public void writeMessage(String string) {
        this.printStream.println(Protocol.NEW_MSG);
        this.printStream.println(string);
    }

    /**
     * The entry point for this application
     *
     * @param {args} command line arguments, none expected
     */
    public static void main(String [] args) {
        ChatRoomClient client = new ChatRoomClient(HOST, PORT);
        
        client.enter();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter next message:");
            client.writeMessage(sc.nextLine());
        }
    }
}
