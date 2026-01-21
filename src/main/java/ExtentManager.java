import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
            String fileName = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

            htmlReporter.config().setTheme(Theme.DARK); // Koyu tema, daha havalı :)
            htmlReporter.config().setDocumentTitle("Otomasyon Raporu");
            htmlReporter.config().setReportName("Test Sonuçları");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Senin Adın");
            extent.setSystemInfo("Environment", "Test");
        }
        return extent;
    }
}