package util;

import org.arquillian.spacelift.Spacelift;
import org.arquillian.spacelift.task.archive.UnzipTool;
import org.arquillian.spacelift.task.net.DownloadTool;

public class DeployBrowserDrivers {

	  private final static String CHROMEDRIVER_URL = "https://chromedriver.storage.googleapis.com/76.0.3809.68/chromedriver_win32.zip";

	  private final static String GEKHODRIVER_URL = "https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-win32.zip";

	    public static void setupChrome() {

	        Spacelift.task(DownloadTool.class)
	            .from(CHROMEDRIVER_URL)
	            .to(System.getProperty("user.dir") + "/chrome.zip")
	            .then(UnzipTool.class)
	            .toDir(System.getProperty("user.dir") + "/chrome/")
	            .execute()
	            .await();

	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chrome/chromedriver.exe");

	    }
	    

	    public static void setupFireFox() {

	        Spacelift.task(DownloadTool.class)
	            .from(GEKHODRIVER_URL)
	            .to(System.getProperty("user.dir") + "/FF.zip")
	            .then(UnzipTool.class)
	            .toDir(System.getProperty("user.dir") + "/FF_DRIVER2/")
	            .execute()
	            .await();

	        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/FF_DRIVER2/geckodriver.exe");

	    }
}
