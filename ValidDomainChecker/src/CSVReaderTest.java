import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVReaderTest {

    public static void main(String[] args) {
        String strFile = "/Users/sc063069/Documents/New_CSV.csv";
        String csvSplitBy = ",";
        ArrayList<MyCSVReaderDTO> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(strFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                MyCSVReaderDTO myCsvReader = new MyCSVReaderDTO();

                // use comma as separator
                String[] cols = line.split(csvSplitBy);

                myCsvReader.setUserId(Integer.valueOf(cols[0]));
                myCsvReader.setAminities(cols[1]);
                myCsvReader.setTimestamp(Long.valueOf(cols[2]));

                list.add(myCsvReader);
            }
            retriveAminities(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Map<Integer, List<MyCSVReaderDTO>> retriveAminities(ArrayList<MyCSVReaderDTO> list) {

        // Map<Integer, List<MyCSVReaderDTO>> result = new HashMap<Integer, ArrayList<MyCSVReaderDTO>>();

         int userId = 11;
//         list.stream()
//         .collect(Collectors.groupingBy(MyCSVReaderDTO::getUserId)).values().stream()
//         .filter(peopleWithSameId -> (peopleWithSameId == userId)
//         .forEach(peopleWithSameId -> System.out.println("Result" + peopleWithSameId));
         
         Map<Integer, List<MyCSVReaderDTO>> result = list.stream().filter(Hotel -> Hotel.getUserId().equals(new Integer(userId))).collect(Collectors.groupingBy(MyCSVReaderDTO::getUserId));

//        Map<Integer, List<MyCSVReaderDTO>> result = list.stream()
//                .collect(Collectors.groupingBy(MyCSVReaderDTO::getUserId));

        result.forEach((k, v) -> System.out.println("UserId : " + k + " Details : " + v));

        return result;

    }

}
