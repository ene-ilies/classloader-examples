package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;
import ro.bogdan.ilies.util.TestUsingTest2;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class NoClassDefFoundTestCase {

    private static final String NO_CLASS_DEF_FOUND = "ro/bogdan/ilies/util/Test2";

    @Test
    public void noClassDefFound() {
        try {
            TestUsingTest2 testUsingTest2 = new TestUsingTest2();
            testUsingTest2.tryToUseTest2();
            Assert.fail("Exception expected to be thrown.");
        } catch (NoClassDefFoundError e) {
            Assert.assertEquals(NO_CLASS_DEF_FOUND, e.getMessage());
        }
    }
}
