package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;
import ro.bogdan.ilies.util.Test3;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class MethodNotFoundTestCase {

    private static final String NO_SUCH_METHOD_ERROR = "ro.bogdan.ilies.util.Test3.test3()V";

    @Test
    public void methodNotFound() {
        try {
            Test3 test3 = new Test3();
            test3.test3();
            Assert.fail("Exception expected to be thrown.");
        } catch (NoSuchMethodError e) {
            Assert.assertEquals(NO_SUCH_METHOD_ERROR, e.getMessage());
        }
    }

}
