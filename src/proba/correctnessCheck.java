package proba;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;


public class correctnessCheck {


    public static void main(String[] args) throws IOException {
    }

    public static String replaceCharAt(String s, int pos, char c) {

        StringBuffer sBuffer = new StringBuffer(s);
        sBuffer.setCharAt(pos, c);

        return sBuffer.toString();
    }

    boolean containsWord(final String longWord, final String subWord) {

        int j = 0; 
        int i;
        String copyLongWord = new String();
        copyLongWord = longWord;

        for (i = 0; j < subWord.length(); ) {
            while ((i < copyLongWord.length()) && (subWord.charAt(j) != copyLongWord.charAt(i))) {
                i++;
            }
            if (i == copyLongWord.length()) {
                return false;
            }
            j++;
            copyLongWord = replaceCharAt(copyLongWord, i, '\0');
            i = 0;
        }
        return true; 
    }

    boolean containsWordI(final String longWord, final String subWord) {

        String copyLongWord = new String();
        String copySubWord = new String();
        copyLongWord = longWord.toUpperCase();
        copySubWord = subWord.toUpperCase();

        containsWord(copyLongWord, copySubWord);

        return true; 
    }
    @Test
    public void test() {

        Assert.assertEquals("�23456", replaceCharAt("123456", 0, '�'));
        Assert.assertEquals("1�3456", replaceCharAt("123456", 1, '�'));

        Assert.assertEquals(true, containsWord("123456", "123"));
        Assert.assertEquals(true, containsWord("123456", "45"));
        Assert.assertEquals(true, containsWord("123456", "35"));
        Assert.assertEquals(true, containsWord("123456", "53"));
        Assert.assertEquals(false, containsWord("123456", "0"));
        Assert.assertEquals(true, containsWord("123456", "6"));
        Assert.assertEquals(false, containsWord("��", "��"));
        Assert.assertEquals(false, containsWord("������", "P����"));
        Assert.assertEquals(false, containsWord("������", "P��"));
        Assert.assertEquals(true, containsWord("������", "���"));
        Assert.assertEquals(true, containsWord("������", "�����"));
        Assert.assertEquals(false, containsWord("������", "��O"));
        Assert.assertEquals(true, containsWord("������", "���"));
        Assert.assertEquals(true, containsWord("��������", "����"));
        Assert.assertEquals(false, containsWord("��������", "���"));
        Assert.assertEquals(true, containsWord("��������", "���"));

        Assert.assertEquals(true, containsWord("123456", "16"));
        Assert.assertEquals(true, containsWord("123456", "61"));
        Assert.assertEquals(true, containsWord("123456", "654321"));
        Assert.assertEquals(true, containsWord("123456", ""));
        Assert.assertEquals(true, containsWord("123456", "123456"));
        Assert.assertEquals(false, containsWord("123456", "7"));
        Assert.assertEquals(false, containsWord("123456", "1234567"));
        Assert.assertEquals(false, containsWord("123456", "11"));
        Assert.assertEquals(false, containsWord("123456", "123456123456"));
        Assert.assertEquals(true, containsWord("122333", "123233"));
        Assert.assertEquals(false, containsWord("122333", "123223"));
        Assert.assertEquals(true, containsWord("", ""));
        Assert.assertEquals(false, containsWord("111", "1111"));
        Assert.assertEquals(false, containsWord("", "1"));

        Assert.assertEquals(false, containsWord("����", "����"));
        Assert.assertEquals(true, containsWordI("����", "����"));
        Assert.assertEquals(false, containsWord("����", "����"));
        Assert.assertEquals(true, containsWordI("����", "����"));
    }
}
