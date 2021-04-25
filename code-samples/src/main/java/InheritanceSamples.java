/**
 * 接口、类与方法的继承举例，用于演示 IntelliJ IDEA 的 Navigate 功能。
 *
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
