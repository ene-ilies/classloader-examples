package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.factory.Factory;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;
import ro.bogdan.ilies.util.Test3;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class ClassCastErrorTestCase {

    private static final String CAN_NOT_CAST = "ro.bogdan.ilies.util.Test3 cannot be cast to ro.bogdan.ilies.util.Test3";

    @Test
    public void classCastError() {
        try {
            Test3 test3 = (Test3) Factory.createObjectTest3();
            Assert.fail("Exception expected to be thrown.");
        } catch (ClassCastException e) {
            Assert.assertEquals(CAN_NOT_CAST, e.getMessage());
        }
    }
}
