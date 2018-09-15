package codingtest.anypointmedia;

import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class FileTest {

    private FileParser fileParser = new FileParser("test.txt");

    @Test
    public void getFileTest() {
        assertNotNull(fileParser.getFile());
    }

    @Test
    public void getTokenListTest() {
        FileReader fileReader = fileParser.getFile();
        assertThat(fileParser.getTokenList(fileReader).get(0), is("first"));
    }

    @Test
    public void createTokenLengthMapTest() {
        FileReader fileReader = fileParser.getFile();
        List<String> list = fileParser.getTokenList(fileReader);
        System.out.println(fileParser.createTokenLengthMap(list));
    }
}
