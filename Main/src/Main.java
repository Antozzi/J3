public class Main {

    public static void main(String[] args) {

        ABCPrinter abcPrinter = new ABCPrinter();
        Thread t1 = new Thread(abcPrinter::printA);
        Thread t2 = new Thread(abcPrinter::printB);
        Thread t3 = new Thread(abcPrinter::printC);
        t1.start();
        t2.start();
        t3.start();

    }
}

