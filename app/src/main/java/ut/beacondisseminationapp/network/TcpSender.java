package ut.beacondisseminationapp.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpSender extends ObjectOutputStream {

    OutputStream os;

    public TcpSender(OutputStream os) throws IOException {
        super(os);
        this.os = os;
    }

    public TcpSender(Socket s) throws IOException {
        this(s.getOutputStream());
    }

    public void send(Object obj) {
        try {
            super.writeObject(obj);
            super.flush();
            super.reset();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
