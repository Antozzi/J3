package chat.database;

import chat.client.ClientWindow;

import java.io.*;

public class HistoryLogger {

    public static void doLogReader() {
        File file = new File("historylog.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            for (int i = 0; i < 100; i++) {
                while ((line = br.readLine()) != null) {
                    ClientWindow.printMsg(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doLogWriter(String value) {
        File file = new File("historylog.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(value);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
