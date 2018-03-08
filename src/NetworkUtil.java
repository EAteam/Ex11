import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sahar.shukrun on 11/19/2017.
 */

public class NetworkUtil {

    private static final Logger LOGGER = Logger.getLogger( NetworkUtil.class.getName() );

    public static Socket createSocket(String url, int port, int timeout) throws IOException{
        Socket s = null;
        s = new Socket(url, port);
        if (timeout > 0) {
            s.setSoTimeout(timeout);
        }
        return s;
    }

    public static void sendRequest(Socket s, String request) throws IOException{
        PrintWriter out = new PrintWriter(s.getOutputStream(),
                true);
        out.write(request);
        out.flush(); // force write
    }

    public static String getResponse(Socket s) throws IOException{
        String res = null;
        DataInputStream is = null;
        int cntlen = 0;

        try {
            is = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            byte[] buf = new byte[1024];
            int nRead;
            nRead = is.read(buf);
            if( nRead == -1 ) {
                LOGGER.log(Level.WARNING,"ERROR - failed to read from socket"); //logging
                return res;
            }

            // Analyze the length of content
            String temp = new String(buf, 0, nRead);
            res = temp;

            // Read the rest of sockets
            byte[] buf1 = new byte[cntlen];
            while((nRead = is.read(buf1,0,cntlen)) != -1) {
                res +=  new String(buf1, 0, nRead);
                cntlen -= nRead;
                if (cntlen == 0) {
                    break;
                }
            }

            LOGGER.log(Level.INFO,"Finish reading from socket"); // logging
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            if (null != is) {
                is.close();
            }
            return res;
        }
    }

}
