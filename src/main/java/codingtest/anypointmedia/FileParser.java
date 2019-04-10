package codingtest.anypointmedia;

import java.io.*;
import java.util.*;

public class FileParser {

    /**
     * file path
     */
    private String path;

    FileParser(String path) {
        this.path = path;
    }

    /**
     * 지정한 경로의 파일을 가져온다.
     *
     * @return FileReader 인스턴스
     */
    FileReader getFile() {

        FileReader fileReader = null;

        File file = new File(path);

        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    /**
     * 받은 파일로부터 단어들을 분리하고 list에 담는다.
     *
     * @param fileReader getFile()에서 얻은 인스턴스
     * @return 단어 리스트(중복되는 단어가 몇개인지 알기 위해 여기서는 list로 리턴한다.)
     */
    List<String> getTokenList(FileReader fileReader) {

        List<String> list = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                //line에서 단어별로 분리
                StringTokenizer stringTokenizer = new StringTokenizer(line);

                //단어 리스트에 담는다.
                while (stringTokenizer.hasMoreTokens()) {
                    list.add(stringTokenizer.nextToken().toLowerCase());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 단어리스트를 토대로 자리수에 맞게 map에 넣는다.
     * map은 단어 자리수를 key, map을 value로 갖는다. 이때 value는 단어와 해당단어의 갯수를 key,value로 갖는다.
     * (중복단어의 개수는 중요하지 않고, 단어를 정렬하기 위해서 단어를 key로 둔다. 중복개수는 참고용)
     *
     * @param list 단어리스트
     * @return 단어수로 정렬된 treemap(+단어별 중복갯수 map)
     */
    Map<Integer, Map<String, Integer>> createTokenLengthMap(List<String> list) {

        //최상위 맵 (글자수로 정렬하가위해 treemap사용)
        Map<Integer, Map<String, Integer>> tokenMap = new TreeMap<>();

        //단어의 글자수
        int tokenLength;

        for (String token : list) {
            tokenLength = token.length();

            //이미 map에 들어있는 글자수 확인 ( 없으면 맵 생성 )
            if (tokenMap.get(tokenLength) == null) {
                //단어와 중복단어갯수를 위한 맵생성
                Map<String, Integer> tokenCntMap = new TreeMap<>();
                tokenCntMap.put(token, 1);
                tokenMap.put(tokenLength, tokenCntMap);
            } else {
                Map<String, Integer> tokenCntMap = tokenMap.get(tokenLength);

                //중복단어개수
                int count = 1;

                //단어가 등록된적이 있는지 확인 ( 없으면 맵 생성 )
                if (tokenCntMap.get(token) != null) {
                    count = tokenCntMap.get(token);
                    tokenMap.get(tokenLength).put(token, count + 1);
                } else {
                    tokenCntMap.put(token, count);
                }

            }
        }

        return tokenMap;

    }

    /**
     * 결과 출력
     *
     * @param map createTokenLengthMap() 리턴값
     */
    void printResult(Map<Integer, Map<String, Integer>> map) {

        Set<Integer> entries = map.keySet();
        Iterator<Integer> i = entries.iterator();

        while (i.hasNext()) {
            Integer key = i.next();
            Map<String, Integer> inner_map = map.get(key);

            Set<String> inner_entries = inner_map.keySet();
            Iterator<String> inner_i = inner_entries.iterator();

            System.out.println("------ 글자수:" + key + "개 ------");

            while (inner_i.hasNext()) {
                String token = inner_i.next();
                Integer count = inner_map.get(token);
                System.out.println(token + "(중복:" + count + "개)");
            }

        }

    }


}
