package orsi.elso;

import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.ArithmeticException;

/**
 * Created by msimon on 29.11.2017.
 */
public class SzamologepTeszt {

    @BeforeClass
    public static void egyszerAzOsszesTesztElott() {
        System.out.println("Ez egyszer fut le az osszes teszt elott.");
    }

    @AfterClass
    public static void egyszerAzOsszesTesztUtan() {
        System.out.println("Ez egyszer fut le az osszes teszt utan.");
    }

    @BeforeMethod
    public static void mindenTesztElott() {
        System.out.println("Ez minden teszt elott lefut.");
    }

    @AfterMethod
    public static void mindenTesztUtan() {
        System.out.println("Ez minden teszt utan lefut.");
    }

    @Test(groups = {"normal","osszeadas"}, description = "ez egy összeadás teszt", dependsOnGroups = {"szorzas"}, alwaysRun = true)
    public static void osszeadasTeszt() {
        Assert.assertEquals(Szamologep.osszeadas(1,2), 3); // 1 + 2 = 3 kell legyen :)
    }

    @Test(groups = {"normal","szorzas"}, invocationCount = 3, dependsOnGroups = {"osztas"})
    public static void szorzasTeszt() {
        Assert.assertEquals(Szamologep.szorzas(0, 123456), 0);
        Assert.assertEquals(Szamologep.szorzas(3,4), 12);
        Assert.fail("direkt elrontva");
    }

    @Test(groups = {"normal","osztas"})
    public static void osztasTeszt() {
        Assert.assertEquals(Szamologep.osztas(5,1), 5); // 5:1=5
        Assert.assertEquals(Szamologep.osztas(16,2), 8);
        Assert.assertEquals(Szamologep.osztas(7,2), 3);
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public static void osztasNullaval() {
        Szamologep.osztas(12, 0); // nullaval osztunk
    }
}
