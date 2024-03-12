import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChartHelper {

	public void createRuntimeChart(ArrayList<int[]> evenlyDistributedArrays, long[] evenlyDistributedRuntimes,
								   ArrayList<int[]> unevenlyDistributedArrays, long[] unevenlyDistributedRuntimes,
								   String chartTitle) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		// Series for evenly distributed arrays
		XYSeries evenlySeries = new XYSeries("Evenly Distributed");
		for (int i = 0; i < evenlyDistributedArrays.size(); i++) {
			evenlySeries.add(evenlyDistributedArrays.get(i).length, evenlyDistributedRuntimes[i]);
		}
		dataset.addSeries(evenlySeries);

		// Series for unevenly distributed arrays
		XYSeries unevenlySeries = new XYSeries("Unevenly Distributed");
		for (int i = 0; i < unevenlyDistributedArrays.size(); i++) {
			unevenlySeries.add(unevenlyDistributedArrays.get(i).length, unevenlyDistributedRuntimes[i]);
		}
		dataset.addSeries(unevenlySeries);

		// Create the chart with the dataset
		JFreeChart chart = ChartFactory.createScatterPlot(
				chartTitle,
				"Array Size (n)",
				"Runtime in Nanoseconds",
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false);

		XYPlot plot = chart.getXYPlot();
		XYItemRenderer renderer = new XYLineAndShapeRenderer(true, true); // Set true to draw lines

		// Set different colors for the series
		renderer.setSeriesPaint(0, Color.GREEN); // Color for evenly distributed
		renderer.setSeriesPaint(1, Color.BLUE);  // Color for unevenly distributed

		plot.setRenderer(renderer);

		displayChart(chart);
	}

	private void displayChart(JFreeChart chart) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Chart");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new ChartPanel(chart));
			frame.pack();
			frame.setVisible(true);
		});
	}
}
