package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String st;
            StringBuilder data = new StringBuilder();
            while ((st = br.readLine()) != null) {
                data.append(st).append(" ");
            }
            String[] dataArr = data.toString().split(" ");
            profile.setName(dataArr[1]);
            profile.setAge(Integer.parseInt(dataArr[3]));
            profile.setEmail(dataArr[5]);
            profile.setPhone(Long.parseLong(dataArr[7]));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return profile;
    }
}
