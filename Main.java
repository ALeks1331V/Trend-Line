package org.example;
import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        String filePath = "Path";
        parseCSV parse = new parseCSV(filePath);
        TrendLine line = new TrendLine(parse.getX(), parse.getY());
        line.getKoef();

        SwingUtilities.invokeLater(() -> createAndShowGUI(line));

    }
    public static void createAndShowGUI(TrendLine trendLine) {
        JFrame frame = new JFrame("Trend Line Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleLineGraph trendLinePanel = new SimpleLineGraph(trendLine);
        frame.add(trendLinePanel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}