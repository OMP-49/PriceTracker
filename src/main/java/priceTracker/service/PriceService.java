/**
 * 
 */
package priceTracker.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author om
 *
 */
@Service
public class PriceService {
	
	public float getProductCurrentPrice(String url) {
		
		WebClient webClient = new WebClient(BrowserVersion.CHROME);

		try {
		   HtmlPage page = webClient.getPage("https://foodnetwork.co.uk/italian-family-dinners/");
		   
		   webClient.getOptions().setCssEnabled(false);
		   webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		   webClient.getOptions().setThrowExceptionOnScriptError(false);
		   webClient.getOptions().setPrintContentOnFailingStatusCode(false);

		   webClient.getCurrentWindow().getJobManager().removeAllJobs();
		   webClient.closeAllWindows();

		} catch (IOException e) {
		   System.out.println("An error occurred: " + e);
		}
		return 0;
	}

}
