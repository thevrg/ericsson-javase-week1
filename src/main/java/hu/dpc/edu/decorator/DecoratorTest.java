package hu.dpc.edu.decorator;

import java.io.*;

/**
 * Created by vrg on 12/10/16.
 */
public class DecoratorTest {
    public static void main(String[] args) throws IOException {

        try (LineNumberReader in =
                new LineNumberReader(
                        new CharacterReplacerFilterReader(
                                new InputStreamReader(
                                        new FileInputStream("pom.xml"), "UTF-8"),
                                '<', 'X'))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(in.getLineNumber() + ": " + line);
            }
        }
    }
}
