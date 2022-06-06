package com.jewelry.auth;

import java.io.*;
import java.util.Scanner;

public class WorkWithFiles {

    public static void write(String text, String filePath){
        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String read(String filePath) {
        String list = "";
        File txt = new File(filePath);
        try (Scanner in = new Scanner (txt)){
            while(in.hasNext()){
                list +=in.nextLine() + " ";// + "\n";
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return list;
    }
}
