package com.pro.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

public class Program{
    public static void main(String[] args) {
        try{
            BufferedReader reader1=new BufferedReader(new FileReader(
                "e:/MyFiles/links.txt"));
            String link="";
            while((link=reader1.readLine())!=null){
                URL url=new URL(link);
                URLConnection conn=url.openConnection();
                String agent="Mozilla/5.0 (Windows NT 10.0)"+ 
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103"+
                 "Safari/537.36";
                conn.setRequestProperty("User-Agent", agent);
                
                String name=link.replace("https://", "").replace(".com", "");
                Writer writer=new FileWriter("e:/MyFiles/"+name+".html");
                BufferedReader reader=new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
                String line="";
                System.out.println("Writting "+name);
                while((line=reader.readLine())!=null){
                    writer.write(line);
                }
                System.out.println(name+" written");
                reader.close();
            }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}