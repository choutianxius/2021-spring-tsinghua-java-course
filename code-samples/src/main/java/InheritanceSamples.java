/**
 * @author octopusthu@gmail.com
 */
public class InheritanceSamples {

    interface TestInterface {
        /**
         * testMethod
         */
        void testMethod();
    }

    abstract static class TestAbstractClass implements TestInterface {
        @Override
        public void testMethod() {
            System.out.println("testMethod of abstract class");
        }
    }

    static class TestConcreteClass extends TestAbstractClass {
        @Override
        public void testMethod() {
            System.out.println("testMethod of concrete class");
        }
    }

    public static void main(String[] args) {
        TestConcreteClass testConcreteClass = new TestConcreteClass();
        testConcreteClass.testMethod();
    }
}
