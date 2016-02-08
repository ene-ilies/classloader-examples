package ro.bogdan.ilies;

import org.junit.Test;
import org.junit.runner.RunWith;
import ro.bogdan.ilies.runner.ClassLoaderTestRunner;

/**
 * @author MuleSoft, Inc.
 */
@RunWith(ClassLoaderTestRunner.class)
public class OverrideSystemClassLoaderTestCase {

    @Test
    public void overrideSystemClassLoader() {
        System.out.println("Classloader: " + this.getClass().getClassLoader());
    }

}
