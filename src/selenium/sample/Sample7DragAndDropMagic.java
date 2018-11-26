package selenium.sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class Sample7DragAndDropMagic {
    public static void dragAndDropMagic(WebDriver driver, String source, String target) {
        try {
            String basePath = new File("").getAbsolutePath();

            //http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
            //https://gist.github.com/rcorreia/2362544
            final String JQUERY_LOAD_SCRIPT = (basePath + "/lib/jquery_load_helper.js");
            String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);

            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeAsyncScript(
                    jQueryLoader);

            js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
                    + " }); ");

            //http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
            //"where jquery_load_helper.js contains:"
            String filePath = basePath + "/lib/drag_and_drop_helper.js";


            //JQuery can ONLY work with id and css , xpath does NOT work with it.

            StringBuffer buffer = new StringBuffer();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null)
                buffer.append(line);

            String javaScript = buffer.toString();

            javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
            ((JavascriptExecutor) driver).executeScript(javaScript);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String file) throws Exception {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
}
