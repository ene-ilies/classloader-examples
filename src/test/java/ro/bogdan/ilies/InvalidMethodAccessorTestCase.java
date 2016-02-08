package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.factory.FactoryTest;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class InvalidMethodAccessorTestCase {

    private static final String ILLEGAL_ACCESS_ERROR = "tried to access method ro.bogdan.ilies.factory.Factory.createPackageTest3()Ljava/lang/Object; from class ro.bogdan.ilies.factory.FactoryTest";

    @Test
    public void invalidMethodAccessor() {
        try {
            FactoryTest factoryTest = new FactoryTest();
            factoryTest.test();
            Assert.fail("Exception expected to be thrown.");
        } catch (IllegalAccessError e) {
            Assert.assertEquals(ILLEGAL_ACCESS_ERROR, e.getMessage());
        }
    }
}
