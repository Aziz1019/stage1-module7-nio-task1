package com.epam.mjc.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
             FileChannel fileChannel = randomAccessFile.getChannel();) {
            StringBuilder strData = new StringBuilder();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    strData.append((char) buffer.get());
                }
                buffer.clear();
                strData.append(" ");
            }
            String[] dataArr = strData.toString().split(" ");

            profile.setName(dataArr[1].split("\n")[0].trim());
            profile.setAge(Integer.valueOf(dataArr[2].split("\n")[0].trim()));
            profile.setEmail(dataArr[3].split("\n")[0].trim());
            profile.setPhone(Long.valueOf(dataArr[4].split("\n")[0].trim()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}
