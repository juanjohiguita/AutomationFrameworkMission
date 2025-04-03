package core.listeners;

import core.pages.basePage.BaseScreen;
import org.testng.*;

public class TestListener implements ITestListener, IExecutionListener{

    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        BaseScreen.closeDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        BaseScreen.closeDriver();
    }

    /*
    @Override
    public void onTestFailure(ITestResult result) {
        String filename = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "screenshots" + File.separator + result.getMethod().getMethodName();
        File file = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(filename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}
