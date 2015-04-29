package de_mpi;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        URL url = new URL("http://xv-omc.hypoport.local/om-xv/index.html");
        URL url = new URL("http://dilbert.com/"); // Intern führt dies zu 401 Unauthorized
        // siehe https://wiki.hypoport.local/pages/viewpage.action?pageId=26051428

        URLConnection con = url.openConnection();


        Reader r = new InputStreamReader(con.getInputStream(), "UTF-8");
        StringBuilder buf = new StringBuilder();
        while (true) {
            int ch = r.read();
            if (ch < 0)
                break;
            buf.append((char) ch);
        }
        System.out.println(buf.toString());

    }
}
