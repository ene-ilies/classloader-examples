package ro.bogdan.ilies.factory;

import ro.bogdan.ilies.util.Test3;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class FactoryTest {

    public void test() {
        Test3 test3 = (Test3) Factory.createPackageTest3();
        test3.test3();
    }
}
