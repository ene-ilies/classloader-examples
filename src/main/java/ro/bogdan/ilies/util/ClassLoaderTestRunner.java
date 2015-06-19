package ro.bogdan.ilies.util;

import ro.bogdan.ilies.factory.Factory;
import ro.bogdan.ilies.factory.FactoryTest;

/**
 * Created by bogdan.ilies on 8/13/2014.
 */
public class ClassLoaderTestRunner {

    public void runTests() {
        try {
            // no class def found error when class can not be loaded
            noClassDefFound();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            // method not found when another version of class loaded
            methodNotFound();
        } catch (Throwable e) {
            e.printStackTrace();
        }


        try {
            // linkage error when class declaration loaded by one loader and class instance loaded by another loader
            linkageError();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            // class cast error when class loaded by another loader
            classCastError();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            // invalid method accessor when class loaded by different class loader
            invalidMethodAccessor();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void noClassDefFound() {
        Test2 test2 = new Test2();
    }

    private void linkageError() {
        Test1 test1 = Factory.createTest1();
        test1.printClassLoader();
    }

    private void methodNotFound() {
        Test3 test3 = new Test3();
        test3.test3();
    }

    private void classCastError() {
        Test3 test3 = (Test3) Factory.createObjectTest3();
        test3.test3();
    }

    private void invalidMethodAccessor() {
        FactoryTest factoryTest = new FactoryTest();
        factoryTest.test();
    }
}
