@DescriptionClass(title = "ClassTest3. Run: test2(), (test3(), test4(), test1() - single priority)," +
        "testAfterSuite()")
public class ClassTestWithSinglePriority {

    @Test(description =  "Method test1 description", priority = 2)
    public static void test1(){
        System.out.println("test1");
    }

    @Test(description =  "Method test2 description", priority = 1)
    public static void test2(){
        System.out.println("test2");
    }

    @Test(description =  "Method test3 description", priority = 2)
    public static void test3(){
        System.out.println("test3");
    }

    @Test(description =  "Method test4 description", priority = 2)
    public static void test4(){
        System.out.println("test4");
    }

    @AfterSuite
    public static void testAfterSuite(){
        System.out.println("testAfterSuite");
    }


}
