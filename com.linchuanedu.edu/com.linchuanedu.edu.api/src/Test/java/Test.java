import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pansp on 2017-12-18.
 */
public class Test {

    public static void main(String[] args){

        Test test = new Test();
        long startTime = System.currentTimeMillis();
        test.testAC();
        System.out.println("AC cost time : " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        test.testContains();
        System.out.println("Contains cost time : " + (System.currentTimeMillis() - startTime) + "ms");
    }




    public void testAC(){
        String file = "C:\\Users\\pansp\\Desktop\\敏感词.txt";
        String file1 = "C:\\Users\\pansp\\Desktop\\文章.txt";


        Trie trie = Trie.builder()
                .addKeywords(readFileByLines(file))
                .build();

        long startTime = System.currentTimeMillis();
        Collection<Emit> emits = trie.parseText(readFile(file1));

        System.out.println("AC匹配时间： " + (System.currentTimeMillis() -startTime) + "ms");
        System.out.println(emits.toString());

    }


    public List<String> readFileByLines(String fileName) {
        List<String> list = new ArrayList();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
//            System.out.println("-------获取敏感词，开始！-------");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                list.add(tempString);
                line++;
            }
//            System.out.println("-------获取敏感词，结束！-------");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return list;
    }

    public String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
//            System.out.println("-------获取需要过滤的文章，开始！-------");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                result.append(System.lineSeparator() + tempString);
                line++;
            }
            reader.close();
//            System.out.println("-------获取需要过滤的文章，结束！-------");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return result.toString();
    }



    public void testContains(){
        String file = "C:\\Users\\pansp\\Desktop\\敏感词.txt";
        String file1 = "C:\\Users\\pansp\\Desktop\\文章.txt";
        long num = 0;
        List<String> result = new ArrayList<>();


        List<String> words = readFileByLines(file);
        String content = readFile(file1);

        for (String word : words) {
            if (content.contains(word)) {
                num ++;
                result.add(word);
            }
        }

        System.out.println("包含敏感词个数：" + num + " 含有的敏感词为：" + result.toString());

    }
}
