package ro.bogdan.ilies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.classloader.CustomClassLoader;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class OverrideSystemClassLoaderTestCase {

    @Test
    public void overrideSystemClassLoader() {
        Assert.assertEquals(CustomClassLoader.class, this.getClass().getClassLoader().getClass());
    }

}
