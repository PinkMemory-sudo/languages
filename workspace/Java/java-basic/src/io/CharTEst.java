package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流test
 */
public class CharTEst {

    public static void main(String[] args) {

    }

    public static void  readerTest(){
        try(FileReader reader = new FileReader("")) {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
