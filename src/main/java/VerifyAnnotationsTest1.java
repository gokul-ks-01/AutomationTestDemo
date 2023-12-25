import org.testng.annotations.*;

public class VerifyAnnotationsTest1 {
    @BeforeSuite
    public void suiteStart(){
        System.out.println("test suite start1");
    }
    @AfterSuite
    public void suiteEnd(){
        System.out.println("test suite end1");
    }
    @BeforeTest
    public void testStart(){
        System.out.println("test start1");
    }
    @AfterTest
    public void testEnd(){
        System.out.println("testEnd1");
    }
    @BeforeClass
    public void classStart(){
        System.out.println("class start1");
    }
    @AfterClass
    public void classEnd(){
        System.out.println("class end1");
    }
    @BeforeMethod
    public void methodStart(){
        System.out.println("method start1");
    }
    @AfterMethod
    public void methodEnd(){
        System.out.println("method end1");
    }

    @Test
    public void sampleTestMethod1(){
        System.out.println("sample test 1_1");
    }
    @Test
    public void sampleTestMethod2(){
        System.out.println("sample test 2_1");
    }
    @Test
    public void sampleTestMethod3(){
        System.out.println("sample test 3_1");
    }
}
