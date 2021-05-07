


public class Main {

    public static void main(String[] args) {

        TestAll testAll = new TestAll();

        testAll.start(ClassTestWithOrderedPriority.class);
        testAll.start(ClassTestWithSinglePriority.class);
        testAll.start(ClassTestWithSeveralAnnots.class);
        }
}
