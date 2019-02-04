import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TachographTest {

    private Tachograph tachograph;

    @Before
    public void before() {
        tachograph = new Tachograph();
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        tachograph.addDataToTable(new Date(),2,3);
        Assert.assertEquals(false, tachograph.isEmpty());
    }
}
