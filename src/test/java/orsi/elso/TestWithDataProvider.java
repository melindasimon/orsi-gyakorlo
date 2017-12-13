package orsi.elso;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by msimon on 13.12.2017.
 */
public class TestWithDataProvider {

    @Test(dataProvider = "dataMethod")
    public void testMethod(int a, int b, int sum) {
        System.out.println("Expected that " + a + " + " + b + " = " + sum);
        Assert.assertEquals(Szamologep.osszeadas(a,b), sum);
    }

    @DataProvider
    public Object[][] dataMethod() {
        return new Object[][] { { 1, 2, 3 }, { 2, 2, 4 }, { -1, 1, 0} };
    }

}
