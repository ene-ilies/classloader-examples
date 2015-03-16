package main.classloader;

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

        if (name.equals("main.util.Test2")) {
            return null;
        } else if (name.equals("main.util.Test3")) {
            String classesPath = System.getProperty("classesPath");
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
        } else if (name.startsWith("main.util.") || name.equals("main.factory.FactoryTest")) {
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
