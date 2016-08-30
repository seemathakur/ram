package com.vsp.testfw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlki on 8/18/2016.
 */
public class DeserializeCacheFile {

    //330484151115
    private static final String filepath = "C:\\Carls Documents\\eclipse_workspace\\iDrTestFW\\";
    public static final String FILENAME = "330484151115";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String test = "This will work if the objects were written with a single ObjectOutputStream. " +
                "If several ObjectOutputStreams were used to write to the same file in succession, " +
                "it will not. – Tom Anderson 4 mins ago";

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("stuff.txt");
            for (String s : test.split("\\s+")) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(s);
            }
        } finally {
            if (fos != null)
                fos.close();
        }

        List<Object> results = new ArrayList<Object>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filepath + FILENAME);
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                results.add(ois.readObject());
            }
        } catch (EOFException ignored) {
            // as expected
        } finally {
            if (fis != null)
                fis.close();
        }
        System.out.println("results = " + results);
    }

}
