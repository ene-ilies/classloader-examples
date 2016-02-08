package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.factory.Factory;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;
import ro.bogdan.ilies.util.Test1;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class LinkageErrorTestCase {

    private static final String LINKAGE_ERROR = "loader constraint violation: loader (instance of ro/bogdan/ilies/classloa"
            + "der/ParentCustomClassLoader) previously initiated loading for a different type with name \"ro/bogdan/ilies/util/Test1\"";

    @Test
    public void linkageError() {
        try {
            Test1 test1 = Factory.createTest1();
            test1.printClassLoader();
            Assert.fail("Exception expected to be thrown.");
        } catch (LinkageError e) {
            Assert.assertEquals(LINKAGE_ERROR, e.getMessage());
        }
    }
}
