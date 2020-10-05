package client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryWriter {
    BufferedWriter bw;

    public HistoryWriter(){
        try{
            this.bw = new BufferedWriter(new FileWriter( "/Users/Randoom/MyProject/MyHomeworkV3/Homework3/src/main/java/client/test.txt" , true) );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("файл не найден");
        }
    }

    public void writeHistory(String msg) {
        try {
            bw.write( msg + "\n");
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void closeHistoryWriter(){
        try {
            this.bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
