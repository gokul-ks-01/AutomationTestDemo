import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyDataProvider {
    @Test(dataProvider = "sample")
    public void samplePrintout(String key,String value){

        System.out.println("Key=" + key +" , "+ "value="+value );
    }

    @DataProvider(name="sample")
    public Object[][] sampleKeyValuePair(){

        return new Object[][]
                {
                {"x","1"},
                {"y","2"}
                } ;
    }
}
