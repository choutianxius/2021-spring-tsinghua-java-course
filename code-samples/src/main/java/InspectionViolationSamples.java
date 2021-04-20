import java.util.ArrayList;
import java.util.List;

/**
 * 违反代码规范的情况举例
 *
 * @author octopusthu@gmail.com
 */
public class InspectionViolationSamples {

    public static void main(String[] args) {
        List list = new ArrayList<>();

        DemoStaticClass demoStaticClass = new DemoStaticClass();
        DemoStaticClass.demoStaticMethod();

    }

    static class DemoStaticClass {
        static void demoStaticMethod() {
        }
    }

    static class DemoParentClass {
        void demoParentClassMethod() {
        }
    }

    static class DemoChildClass extends DemoParentClass {
        void demoParentClassMethod() {
        }
    }
}

