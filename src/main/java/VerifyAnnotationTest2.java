import org.testng.annotations.*;

public class VerifyAnnotationTest2 {

    @BeforeSuite
    public void suiteStart(){
        System.out.println("test suite start2");
    }
    @AfterSuite
    public void suiteEnd(){
        System.out.println("test suite end2");
    }

    @BeforeTest
    public void testStart(){
        System.out.println("test start2");
    }
    @AfterTest
    public void testEnd(){
        System.out.println("testEnd2");
    }
    @BeforeClass
    public void classStart(){
        System.out.println("class start2");
    }
    @AfterClass
    public void classEnd(){
        System.out.println("class end2");
    }
    @BeforeMethod
    public void methodStart(){
        System.out.println("method start2");
    }
    @AfterMethod
    public void methodEnd(){
        System.out.println("method end2");
    }
    @Test
    public void sampleTestMethod1(){
        System.out.println("sample test 1_2");
    }

    @Test
    public void sampleTestMethod2(){
        System.out.println("sample test 2_2");
    }
    @Test
    public void sampleTestMethod3(){
        System.out.println("sample test 3_2");
    }
}
