package com.example.yck1.cwgl.File;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * Created by yck1 on 2015/11/9.
 */
public class FileIO {

    public String read(String filename){

            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCardDir = Environment.getExternalStorageDirectory();
                try {
                    FileInputStream fis = new FileInputStream(sdCardDir.getCanonicalPath() + filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    StringBuilder sb = new StringBuilder("");
                    String line =null;
                    while ((line = br.readLine()) != null){
                        sb.append(line);
                    }
                    br.close();
                    return sb.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    public void write(String content,String filename){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File sdCardDir = Environment.getExternalStorageDirectory();
            try {
                File targetFile = new File(sdCardDir.getCanonicalPath()+filename);
                Log.d("sr",sdCardDir.getCanonicalPath());
                RandomAccessFile raf = new RandomAccessFile(targetFile,"rw");
                raf.seek(targetFile.length());
                raf.write(content.getBytes());
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
