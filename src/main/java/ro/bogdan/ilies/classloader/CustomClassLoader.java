package ro.bogdan.ilies.classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class CustomClassLoader extends ClassLoader {

    public CustomClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (name.equals("ro.bogdan.ilies.util.Test2")) {
            return null;
        } else if (name.equals("ro.bogdan.ilies.util.Test3")) {
            String classesPath = System.getProperty("project.basedir");
            String classPath = classesPath + name.replace(".", "\\") + ".class";
            byte[] buffer = null;
            try {
                InputStream inputStream = new FileInputStream(classPath);
                buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return defineClass(name, buffer, 0, buffer.length);
        } else if (name.startsWith("ro.bogdan.ilies.util.") || name.equals("ro.bogdan.ilies.factory.FactoryTest") || name.endsWith("TestCase")) {
            URL resource = super.getResource(name.replace(".", "/") + ".class");
            byte[] buffer = null;
            try {
                InputStream inputStream = resource.openStream();
                buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return defineClass(name, buffer, 0, buffer.length);
        }

        return getParent().loadClass(name);
    }

}
