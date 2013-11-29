package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class Dictionary {

    ArrayList<String> words = new ArrayList<String>();
    String fileName = "e:\\ru.txt";

    public static void main(String[] args) throws IOException {
        new Dictionary();
    }

    public Dictionary() {
        load(fileName);
        //System.out.println("Words loaded: " + words.size());
        filter(words);
        //System.out.println("Words filtered: " + words.size());
    }

    private ArrayList<String> load(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                words.add(s);
            }
            fr.close();
        }
        catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        }
        return words;
    }

    public boolean existsWord(String subWord) {
        return words.contains(subWord);
    }

    private ArrayList<String> filter(ArrayList<String> words) {

        for (int i = 0; i < words.size(); i++){
            String str = words.get(i);

            if (str.contains("-") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�") ||
                    str.startsWith("�") || str.startsWith("�")) { 
//                System.out.println("i = " + i + "; object: " + words.get(i));
                words.remove(i);
            }
        }
        return words;
    }

    @Test
    public void test() {
        Assert.assertEquals(true, existsWord("������"));
        Assert.assertEquals(true, existsWord("������"));
        Assert.assertEquals(false, existsWord("�����������"));
    }
}