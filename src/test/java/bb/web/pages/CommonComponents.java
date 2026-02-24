package bb.web.pages;

import bb.web.common.BasePage;
import java.io.File;

public class CommonComponents extends BasePage {

    public boolean isHeadingVisible(String text){
        String xpath = "//*[self::h1 or self::h2 or self::h3 or self::h4]" + "[normalize-space(.)='" + text + "']";
        return isVisible(waitVisible(xpath, 10));
    }

    public boolean isMessageVisible(String text){
        String xpath = "//*[self::p or self::span or self::div]" + "[normalize-space(.)='" + text + "']";
        return isVisible(xpath);
    }

    public void acceptAlert() {
        waitForAlertAndAccept();
    }

    public boolean isFileDownloaded(String downloadPath, String filePrefix, int timeoutSeconds) {

        File folder = new File(downloadPath);

        if (!folder.exists() || !folder.isDirectory()) {
            return false;
        }

        long endTime = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < endTime) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    String name = file.getName();
                    if (name.startsWith(filePrefix)) {
                        return true;
                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
