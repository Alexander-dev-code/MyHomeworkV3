package client;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        doFileStream();
        HistoryReader historyReader = new HistoryReader();
        System.out.println("HistoryReader : " + historyReader.toString().length());
        /*HistoryWriter historyWriter = new HistoryWriter();
        System.out.println("HistoryWriter :" + historyWriter.toString().intern());*/
        }
    /*BufferedWriter bw;
    public void writeHistory(String msg) {
        try {
            bw.write( msg + "\n");
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    BufferedReader br = null;
    ArrayList<String> myArr = new ArrayList(  );

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

            answer+="Текущая переписка: \n";
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            answer = "История пуста";
        } finally {
            return answer;
        }

    }*/

        static void doFileStream() {
            try (FileInputStream fin = new FileInputStream(
                    "/Users/Randoom/MyProject/MyHomeworkV3/Homework3/src/main/java/client/test.txt")) {
                int symbol = 0;
                while ((symbol = fin.read()) != -1) {
                    System.out.print((char) symbol);
                }
                System.out.println();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (FileOutputStream fout = new FileOutputStream(
                    "/Users/Randoom/MyProject/MyHomeworkV3/Homework3/src/main/java/client/test.txt", true)) {
                fout.write("\n".getBytes("UTF-8"));
                fout.write("Hello, world!".getBytes("UTF-8"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}
