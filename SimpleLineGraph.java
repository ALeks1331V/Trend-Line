package org.example;

import javax.swing.*;
import java.awt.*;

public class SimpleLineGraph extends JPanel {
    TrendLine trendLine;

    public SimpleLineGraph(TrendLine trendLine) {
        this.trendLine = trendLine;
        trendLine.getKoef(); // Рассчитываем коэффициенты a и b
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int padding = 50;

        g.drawLine(padding, height - padding, width - padding, height - padding); // X-axis
        g.drawLine(padding, padding, padding, height - padding);                  // Y-axis

        double[] x = trendLine.x;
        double[] y = trendLine.y;
        int n = x.length;

        double xMin = Double.MAX_VALUE, xMax = Double.MIN_VALUE;
        double yMin = Double.MAX_VALUE, yMax = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (x[i] < xMin) xMin = x[i];
            if (x[i] > xMax) xMax = x[i];
            if (y[i] < yMin) yMin = y[i];
            if (y[i] > yMax) yMax = y[i];
        }

        double xScale = (width - 2 * padding) / (xMax - xMin);
        double yScale = (height - 2 * padding) / (yMax - yMin);

        for (int i = 0; i < n; i++) {
            int xPlot = (int) (padding + (x[i] - xMin) * xScale);
            int yPlot = (int) (height - padding - (y[i] - yMin) * yScale);
            g.fillOval(xPlot - 3, yPlot - 3, 6, 6); // Точки

            // Подпись точек
            g.drawString(String.format("(%.2f, %.2f)", x[i], y[i]), xPlot + 5, yPlot - 5);
        }

        g.setColor(Color.RED);
        int x1 = padding;
        int y1 = (int) (height - padding - (trendLine.a * xMin + trendLine.b - yMin) * yScale);
        int x2 = width - padding;
        int y2 = (int) (height - padding - (trendLine.a * xMax + trendLine.b - yMin) * yScale);
        g.drawLine(x1, y1, x2, y2); // Линия тренда
    }
}
