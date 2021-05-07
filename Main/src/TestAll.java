import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestAll {

    public TestAll() {
    }

    public void start(Class<?> testClass) {

        if (!testClass.isAnnotationPresent(DescriptionClass.class)) {
            throw new RuntimeException("bad class");
        }

        System.out.println("Class to test: " + testClass.getName());
        System.out.println("Description: " +
                testClass.getAnnotation(DescriptionClass.class).title());

        Method[] methods = testClass.getMethods();

        List<Method> methodsBeforeSuite = new LinkedList<>();
        Map<Integer, List<Method>> methodsTests = new TreeMap<>();
        List<Method> methodsAfterSuite = new LinkedList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                methodsBeforeSuite.add(m);
            } else if (m.isAnnotationPresent(Test.class)) {

                int priority = m.getAnnotation(Test.class).priority();

                if (!methodsTests.containsKey(priority)) {
                    methodsTests.put(priority, new LinkedList<Method>());
                }

                List<Method> list = methodsTests.get(priority);
                list.add(m);
                methodsTests.put(priority, list);
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                methodsAfterSuite.add(m);
            }

        }

        if (methodsBeforeSuite.size() > 1) {
            throw new RuntimeException("More than one method with annot: @BeforeSuite");
        }
        if (methodsAfterSuite.size() > 1) {
            throw new RuntimeException("More than one method with annot: @AfterSuite");
        }

        //@BeforeSuite

        for (Method m : methodsBeforeSuite) {

            if (m.isAnnotationPresent(BeforeSuite.class)) {

                try {
                    m.invoke(testClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //@Tests


        for (List<Method> m : methodsTests.values()) {
            try {
                for (Method method : m) {
                    method.invoke(testClass);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }


        //@AfterTests

        for (Method m : methodsAfterSuite) {

            if (m.isAnnotationPresent(AfterSuite.class)) {

                try {
                    m.invoke(testClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static void nextOrderRun(int prioritet, Map<Integer, Method> map) {

        int nextPrioritet = prioritet;

        if (map.containsKey(prioritet)) {
            nextPrioritet += 1;
            nextOrderRun(nextPrioritet, map);
        }

    }
}
