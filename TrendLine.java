package org.example;

public class TrendLine  {

    double[] x;
    double[] y;
    double a;
    double b;
    int length;

    public TrendLine(double[] x, double[] y){
        this.x = x;
        this.y = y;
        length = x.length;
    }

    public void getKoef(){
        double[][] m = {
                {multisum(x), summ(x), summ(x, y)},
                {summ(x), length, summ(y)}
        };

       double oprMain = m[0][0] * m[1][1] - m[1][0] * m[0][1];
       double oprA = m[0][2] * m[1][1] - m[1][2] * m[0][1];
       double oprB = m[0][0] * m[1][2] - m[1][0] * m[0][2];
       a = oprA/oprMain;
       b = oprB/oprMain;
    }

    private double summ(double[] value){
        double s = 0;
        for (int i=0; i<length; i++){
            s += value[i];
        }
        return s;
    }

    private double summ(double[] value1, double[] value2){
        double s = 0;
        for (int i=0; i<length; i++){
            s += value1[i]*value2[i];
        }
        return s;
    }

    private double multisum(double[] value){
        double s = 0;
        for (int i=0; i<length; i++){
            s += Math.pow(value[i], 2);
        }
        return s;
    }

    public double[] getX(){
        return x;
    }
    public double[] getY(){
        return y;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public void adwda(){
        a = Math.sqrt(2);
    }
}
