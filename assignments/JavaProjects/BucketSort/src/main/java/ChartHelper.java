import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChartHelper {

	public void createRuntimeChart(ArrayList<int[]> arrays, long[] runtimes, String chartTitle) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Runtime");

		for (int i = 0; i < arrays.size(); i++) {
			int[] array = arrays.get(i);
			long runtime = runtimes[i];
			series.add(array.length, runtime);  // Array size is X, runtime is Y
		}

		dataset.addSeries(series);

		JFreeChart chart = ChartFactory.createScatterPlot(
				chartTitle,
				"Array Size (n)",
				"Runtime in Nanoseconds",
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false
		);

		// Customizations
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(new Color(255, 228, 196));

		// Show chart in a frame
		displayChart(chart);
	}

	private static void displayChart(JFreeChart chart) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Charts");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout(0, 5));
			frame.add(new ChartPanel(chart), BorderLayout.CENTER);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
