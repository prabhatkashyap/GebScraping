import java.io.*;

public class ParseTextToCSV {

    public static void main(String arg[]) {
        try {
            File fileText = new File("/home/nexthoughts/Desktop/participantData");
            FileReader fileReader = new FileReader(fileText);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter writer = new FileWriter("/home/nexthoughts/Desktop/participantDataCSV.csv");

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                if (s.startsWith("data-")) {
                    s = s.replace("data-", "");
                    writer.append(s);
                    writer.append('\n');
                }
            }
//            FileWriter writer = new FileWriter("/home/nexthoughts/Desktop/participantDataCSV.csv");

//            writer.append("DisplayName");
//            writer.append(',');
//            writer.append("Age");
//            writer.append('\n');
//
//            writer.append("MKYONG");
//            writer.append(',');
//            writer.append("26");
//            writer.append('\n');
//
//            writer.append("YOUR NAME");
//            writer.append(',');
//            writer.append("29");
//            writer.append('\n');
//
//
//            writer.flush();
//            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
