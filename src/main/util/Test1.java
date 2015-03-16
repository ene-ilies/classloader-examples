package main.util;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class Test1 {

    public void printClassLoader() {
        System.out.println(this.getClass().getName() + "'s classloader: " + this.getClass().getClassLoader());
    }
}
