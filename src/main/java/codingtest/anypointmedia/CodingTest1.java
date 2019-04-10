package codingtest.anypointmedia;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class CodingTest1 {

    public static void main(String[] args) {
        //set file path 123444
        FileParser fileParser = new FileParser("test.txt");

        //get fileReader
        FileReader fileReader = fileParser.getFile();

        //split token
        List<String> list = fileParser.getTokenList(fileReader);

        //sorting tokens
        Map<Integer, Map<String, Integer>> map = fileParser.createTokenLengthMap(list);

        //print result
        fileParser.printResult(map);
    }

}
