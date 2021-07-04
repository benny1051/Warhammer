package model;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Plot2 extends JFrame {
private int[] hitsArray;

    public Plot2(int[] hitsArray) {
        this.hitsArray=hitsArray;

        startPlot();

        // Create dataset
        XYDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Average Hits",
                "Hits", "nmbr", dataset);


        //Changes background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(50,255,0));


        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        //Boys (Age,weight) series
        XYSeries series1 = new XYSeries("HITS");
        for(int i=0;i<hitsArray.length;i++) {
            series1.add(i,hitsArray[i]);
        }
        dataset.addSeries(series1);

        return dataset;
    }

    public void startPlot() {
        SwingUtilities.invokeLater(() -> {

            setSize(1000, 600);
            setLocationRelativeTo(null);
            setVisible(true);
        });
    }
}
