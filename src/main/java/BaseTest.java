import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by C842045 on 1/12/2019.
 */
public class BaseTest {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//env.properties");
        prop.load(fis);
    }
}
