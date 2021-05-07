@DescriptionClass(title = "ClassTest2, Run: Error, several methods with annot: @BeforeSuite")
public class ClassTestWithSeveralAnnots {

    @BeforeSuite
    public static void testBeforeSuite(){
        System.out.println("test@BeforeSuite");
    }
    @BeforeSuite
    public static void testBeforeSuite1(){
        System.out.println("test@BeforeSuite");
    }

    @Test(description =  "Method test1 description", priority = 3)
    public static void test1(){
        System.out.println("test1");
    }

    @Test(description =  "Method test2 description", priority = 3)
    public static void test2(){
        System.out.println("test2");
    }

    @Test(description =  "Method test3 description", priority = 66)
    public static void test3(){
        System.out.println("test3");
    }

    @Test(description =  "Method test4 description", priority = 33)
    public static void test4(){
        System.out.println("test4");
    }

    @AfterSuite
    public static void testAfterSuite(){
        System.out.println("testAfterSuite");
    }

}