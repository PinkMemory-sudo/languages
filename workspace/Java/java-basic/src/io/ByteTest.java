package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节流test
 */
public class ByteTest {


    public static void main(String[] args) {

        // FileInputStream与BufferedInputStream的read()方法
        bufferedRead();
        bufferedArr();
        streamRead();
        streamArrRead();

    }

    public static void bufferedRead() {
        long start = System.currentTimeMillis();
        try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream("/Users/chenguanlin/Documents/test.zip"))) {
            while (bi.read() != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    public static void bufferedArr() {
        byte[] b = new byte[1024*8];
        long start = System.currentTimeMillis();
        try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream("/Users/chenguanlin/Documents/test.zip"))) {
            while (bi.read(b) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    public static void streamRead() {
        long start = System.currentTimeMillis();
        try (FileInputStream bi = new FileInputStream("/Users/chenguanlin/Documents/test.zip")) {
            while (bi.read() != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    public static void streamArrRead() {
        long start = System.currentTimeMillis();
        byte[] b = new byte[8192];
        try (FileInputStream bi = new FileInputStream("/Users/chenguanlin/Documents/test.zip")) {
            while (bi.read(b) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
    }
}
