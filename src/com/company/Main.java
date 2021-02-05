package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.Arrays;
import java.util.Base64;


public class Main {

    public static void main(String[] args) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get("program2"));
        byte[] key = Base64.getDecoder().decode("xWtGjU1Zp8ZlisznS4+3lMIVSkc6yMhZKATTVMEi7ZY=");

        byte[] myCommand = "cat /secret_data/flag_file".getBytes(StandardCharsets.UTF_8);
        byte[] myKey = new byte[key.length];

        for (int i = 0; i < myKey.length; i++) {
            if (i < myCommand.length){
                myKey[i] = (byte) (myCommand[i] ^ fileBytes[i]);
            } else myKey[i] = (byte) (32 ^ fileBytes[i % fileBytes.length]);
        }

        byte[] b = Base64.getEncoder().encode(myKey);
        String myNewKey = new String(b);
        System.out.println(myNewKey);
    }
}
