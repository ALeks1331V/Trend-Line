package org.example;

import java.io.*;
public class parseCSV {
    private static final int length = 5;
    private static double[][] dataMatrix = new double[length][length+1];

    public parseCSV(String filePath){
        try(BufferedReader fileReader
                    = new BufferedReader(new FileReader(filePath)))
        {
            String line = "";
            int i = 0;
            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(";");
                if (i!=0) {
                    for (int j = 1; j < tokens.length; j++) {
                        dataMatrix[i-1][j-1] = Double.parseDouble(tokens[j]);
                    }
                }
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] getX(){
        double[] x = new double[length];
        for(int i = 0; i<length; i++){
            double tempSum = 0;
            for (int j = 0; j < length; j++){
                tempSum += dataMatrix[i][j];
            }
            x[i] = tempSum/length;
        }
        return x;
    }

    public static double[] getY() {
        double[] y = new double[length];
        for (int i = 0; i < length; i++) {
            y[i] = dataMatrix[i][5];
        }
        return y;
    }
}
