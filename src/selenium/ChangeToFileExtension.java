package selenium;

public class ChangeToFileExtension {

    public String extension() {
        System.out.println(System.getProperty("os.name") );
        if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("mac"))
            return "";
        else
            return ".exe";
    }
}
