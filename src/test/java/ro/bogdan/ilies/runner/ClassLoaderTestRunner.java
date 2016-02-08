package ro.bogdan.ilies.runner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import ro.bogdan.ilies.classloader.CustomClassLoader;
import ro.bogdan.ilies.classloader.ParentCustomClassLoader;

/**
 * @author MuleSoft, Inc.
 */
public class ClassLoaderTestRunner extends BlockJUnit4ClassRunner {

    public ClassLoaderTestRunner(Class<?> klass) throws InitializationError {
        super(getFromTestClassLoader(klass));
    }

    private static Class<?> getFromTestClassLoader(Class<?> clazz) throws InitializationError {
        try {
            ClassLoader testClassLoader = new CustomClassLoader(new ParentCustomClassLoader(ClassLoaderTestRunner.class.getClassLoader()));
            return testClassLoader.loadClass(clazz.getName());
        } catch (ClassNotFoundException e) {
            throw new InitializationError(e);
        }
    }
}
