package br.com.uri.operacoes.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class GraficoHistograma {

    public void mostrarGrafico(BufferedImage image, String title) {
        int[] histograma = new int[256];

        IntStream.range(0, image.getWidth()).forEach(linha -> {
            IntStream.range(0, image.getHeight()).forEach(coluna -> {
                int gray = image.getRGB(linha, coluna) & 0xFF;
                histograma[gray]++;
            });
        });

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < histograma.length; i++) {
            dataset.addValue(histograma[i], "Pixels", String.valueOf(i));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                title, "Níveis de cinza", "Número de pixels",
                dataset, PlotOrientation.VERTICAL, false, false, false);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.05);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 1));
        frame.add(chartPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
