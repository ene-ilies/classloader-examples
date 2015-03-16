package main.factory;

import main.util.Test1;
import main.util.Test3;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class Factory {

    public static Test1 createTest1() {
        return new Test1();
    }

    public static Object createObjectTest3() {return new Test3(); }

    static Object createPackageTest3() {return new Test3(); }
}
