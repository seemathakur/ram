package com.vsp.testfw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlki on 8/18/2016.
 */
public class DeserializeCacheSingleObjectPattern {

    private static final String filepath = "C:\\Carls Documents\\eclipse_workspace\\iDrTestFW\\";
    public static final String FILENAME = "330484151115";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Object> results = new ArrayList<Object>();
        FileInputStream fis = new FileInputStream(filepath + FILENAME);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                results.add(ois.readObject());
            }
        } catch (OptionalDataException e) {
            if (!e.eof) throw e;
        } finally {
            ois.close();
        }
    }
}
