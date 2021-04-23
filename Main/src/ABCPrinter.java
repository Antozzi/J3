public class ABCPrinter {

    private final Object monitoredObj = new Object();
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (monitoredObj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        monitoredObj.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitoredObj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitoredObj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        monitoredObj.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitoredObj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printC() {
        synchronized (monitoredObj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        monitoredObj.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitoredObj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
