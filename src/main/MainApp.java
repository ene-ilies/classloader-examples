package main;

import main.classloader.CustomClassLoader;
import main.classloader.ParentCustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class MainApp {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader(
                new ParentCustomClassLoader(MainApp.class.getClassLoader()));
        Class<?> clazz = customClassLoader.loadClass("main.util.ClassLoaderTestRunner");

        for (Method method : clazz.getMethods()) {
            if (method.getName().equals("runTests")) {
                method.invoke(clazz.newInstance());
            }
        }

    }
}
