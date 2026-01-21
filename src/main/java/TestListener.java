import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Test her başladığında rapora bir girdi ekle
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Başarılı");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Hata mesajını ekle
        test.get().fail(result.getThrowable());

        // Screenshot al ve rapora ekle
        try {
            test.get().fail("Ekran Görüntüsü",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Driver.getScreenshot()).build());
        } catch (Exception e) {
            test.get().fail("Ekran görüntüsü alınamadı.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush(); // Raporu diske yaz
        }
    }
}