package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class ClassNotFoundExceptionTestCase {

    private static final String CLASS_NOT_FOUND_ERROR = "ro/bogdan/ilies/util/Test2";

    @Test
    public void classNotFoundError() {
        try {
            Class.forName("ro.bogdan.ilies.util.Test2");
            Assert.fail("Exception expected to be thrown.");
        } catch (ClassNotFoundException e) {
            Assert.assertEquals(CLASS_NOT_FOUND_ERROR, e.getMessage());
        }
    }
}
