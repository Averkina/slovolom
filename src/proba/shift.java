package proba;



import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import junit.framework.Assert;
import org.junit.Test;

public class shift {

    public static void main(String[] args) throws IOException {
        new shift().run();
    }
    

        static int F(final int n) {
            
            int[] A = new int [100];
            
//            if (A[n] != -1) {
//                return A[n];
//            }
            if (n < 2) {
                return 1;
            }
            else {
                A[n] = F(n - 1) + F(n - 2);
                return A[n];
            }
        }

    

    @Test
    public void testConversion() {
        Assert.assertEquals(13, shift.F(7));
        Assert.assertEquals(1, shift.F(1));
        Assert.assertEquals(1, shift.F(2));
        Assert.assertEquals(0, shift.F(0));
    }

    private void processTask(Scanner inputer, PrintWriter outputer) {
        final int n = inputer.nextInt();
        outputer.print(F(n));
    }

    private void run() throws IOException {
        Scanner inputer = getInputer();
        PrintWriter outputer = getOutputer();

        processTask(inputer, outputer);

        inputer.close();
        outputer.close();
    }

    private final String inputFileName = "input.txt";
    private final String outputFileName = "output.txt";

    private boolean isInputFileExists() {
        return (new File(inputFileName).exists());
    }

    private Scanner getInputer() throws FileNotFoundException {
        if (isInputFileExists()) {
            return new Scanner(new FileInputStream(inputFileName));
        }
        return new Scanner(new InputStreamReader(System.in));
    }

    private PrintWriter getOutputer() throws FileNotFoundException {
        if (isInputFileExists()) {
            return new PrintWriter(new FileOutputStream(outputFileName));
        }
        return new PrintWriter(new OutputStreamWriter(System.out));
    }

}