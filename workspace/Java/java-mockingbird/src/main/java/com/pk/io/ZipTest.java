package com.pk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    public static void main(String[] args) {
        try {
            zip(new File("/Users/chenguanlin/Documents/000000_0"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压，压缩包中没有文件夹
     *
     * @param file 需要解压的文件
     */
    public static void unzip(File file) throws IOException {
        if (file.exists() && file.isFile()) {
            // 输出的路径
            String outputPath = file.getParent();
            // 压缩文件
            ZipFile zipFile = new ZipFile(file);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipEntry = zis.getNextEntry();
            while (null != zipEntry) {
                // 从压缩文件zipFile的哪个zipEntry中读取数据
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                // 解压后的数据输出到哪个文件
                FileOutputStream fileOutputStream = new FileOutputStream(new File(outputPath, zipEntry.getName()));
                int len;
                byte[] buff = new byte[1024];
                while ((len = inputStream.read(buff)) != -1) {
                    fileOutputStream.write(buff, 0, len);
                }
                zipEntry = zis.getNextEntry();
            }
        }
    }

    /**
     * 压缩，压缩包中没有文件夹
     *
     * @param file 需要解压的文件所在的文件夹
     */
    public static void zip(File file) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
                new File(file.getParent(), file.getName() + ".zip")));
             FileInputStream fileInputStream = new FileInputStream(file)) {
            zos.putNextEntry(new ZipEntry(file.getName()));
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) != -1) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
