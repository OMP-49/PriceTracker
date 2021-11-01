import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.apache.http.ConnectionClosedException;

public class VerifyWebClient {

	public static void main(String[] args) {
		
//		WebClient webClient = new WebClient(BrowserVersion.CHROME);

//		try {
//		   HtmlPage page = webClient.getPage("https://foodnetwork.co.uk/italian-family-dinners/");
//		   String temp = page.asText();
//		   System.out.println(temp);
//		   
//		   webClient.getOptions().setCssEnabled(false);
//		   webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//		   webClient.getOptions().setThrowExceptionOnScriptError(false);
//		   webClient.getOptions().setPrintContentOnFailingStatusCode(false);
//
//		   webClient.getCurrentWindow().getJobManager().removeAllJobs();
//		   webClient.closeAllWindows();
//
//		} catch (IOException e) {
//		   System.out.println("An error occurred: " + e);
//		}
		
		URL url = null;
		HttpURLConnection httpConnection;
		URLConnection connection;				// define the connection
		
		String inputLine = null;				// define the input stream
		DataInputStream dis;
		
		try {
            url = new URL ("https://www.amazon.in/Samsung-inches-Crystal-Ultra-UA43AUE60AKLXL/dp/B092BJMT8Q/");									// define the URL
            
            connection = url.openConnection();	
            connection.setRequestProperty("Accept-Encoding", "gzip");
//            Reader reader = new InputStreamReader(connection.getInputStream ());	// input data stream
//            Object obj = connection.getContent();
//            String contentEnc = connection.getContentEncoding();
//            String contentType = connection.getContentType();
            
            Reader reader = null;
            if ("gzip".equals(connection.getContentEncoding())) {
               reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
            }
            else {
               reader = new InputStreamReader(connection.getInputStream());
            }
            while (true) {
                int ch = reader.read();
                if (ch==-1) {
                   break;
                }
                System.out.print((char)ch);
             }
            
        } catch (MalformedURLException me) {
            System.out.println ("MalformedURLException: " + me);		// print information if MalformedURLException
        } catch (IOException ioe) {
            System.out.println ("IOException: " + ioe);					// print information if IOException
        }

	}

}
