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

            if (str.contains("-") || str.startsWith("А") ||
                    str.startsWith("Б") || str.startsWith("В") ||
                    str.startsWith("Г") || str.startsWith("Д") ||
                    str.startsWith("Е") || str.startsWith("Ё") ||
                    str.startsWith("Ж") || str.startsWith("З") ||
                    str.startsWith("И") || str.startsWith("Й") ||
                    str.startsWith("К") || str.startsWith("Л") ||
                    str.startsWith("М") || str.startsWith("Н") ||
                    str.startsWith("О") || str.startsWith("П") ||
                    str.startsWith("Р") || str.startsWith("С") ||
                    str.startsWith("Т") || str.startsWith("У") ||
                    str.startsWith("Ф") || str.startsWith("Х") ||
                    str.startsWith("Ц") || str.startsWith("Ч") ||
                    str.startsWith("Ш") || str.startsWith("Щ") ||
                    str.startsWith("Ъ") || str.startsWith("Ы") ||
                    str.startsWith("Ь") || str.startsWith("Э") ||
                    str.startsWith("Ю") || str.startsWith("Я")) { 
//                System.out.println("i = " + i + "; object: " + words.get(i));
                words.remove(i);
            }
        }
        return words;
    }

    @Test
    public void test() {
        Assert.assertEquals(true, existsWord("абажур"));
        Assert.assertEquals(true, existsWord("ящурка"));
        Assert.assertEquals(false, existsWord("контробобик"));
    }
}