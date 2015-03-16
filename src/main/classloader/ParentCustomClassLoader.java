package main.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class ParentCustomClassLoader extends ClassLoader {

    public ParentCustomClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (name.startsWith("main.factory.")) {
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
