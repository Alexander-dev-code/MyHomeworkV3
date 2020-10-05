package client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistoryReader {
    BufferedReader br = null;
    ArrayList<String> myArr = new ArrayList();

    public String readHistory() throws FileNotFoundException {
        String answer = "";
        int minus = 0;

        try {
            br = new BufferedReader( new FileReader(
                    "/Users/Randoom/MyProject/MyHomeworkV3/Homework3/src/main/java/client/test.txt") );
            String str;


            while((str = br.readLine()) != null)
                myArr.add( str+"\n" );
            if (myArr.size()>10) {
                minus = myArr.size()-10;
                for (int i = 0; i < minus; i++) {
                    myArr.remove( 0 );
                }
            }
            StringBuilder builder = new StringBuilder();
            for (String value : myArr) {
                builder.append(value);
            }


            answer += builder.toString();

            answer+="История: \n";
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            answer = "История пуста";
        } finally {
            return answer;
        }

    }
}
