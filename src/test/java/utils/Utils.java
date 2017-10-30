package utils;

import java.io.File;

public class Utils {

    private static String OS = System.getProperty("os.name").toLowerCase();



    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static void setChromeDriverLocation() {
        String pathToDriver = "";
        if (isWindows()) {
            pathToDriver = "binaries/chromedriver.exe";
        } else if (isMac()) {
            pathToDriver = "binaries/mac/chromedriver";
        } else if (isUnix()) {
            pathToDriver = "binaries/linux/chromedriver";
        }

        if(System.getProperty("webdriver.chrome.driver") == null){

            System.setProperty("webdriver.chrome.driver", new File(pathToDriver).getAbsolutePath());
        }


    }

}
