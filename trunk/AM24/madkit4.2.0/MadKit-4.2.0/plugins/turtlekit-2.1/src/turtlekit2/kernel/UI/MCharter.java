package turtlekit2.kernel.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;



public class MCharter extends JPanel {
	final static long serialVersionUID = 1l;

	/**
	 * Chart parameters
	 */
	int subplot_count;
	XYSeriesCollection[] datasets;
	Object variables;
	CombinedDomainXYPlot plot;
	JFreeChart chart;
	ChartPanel chartPanel;
	int step = 0;

	/**
	 * Basic constructor
	 * 
	 * @param simu
	 *            the running simulation
	 */
	public MCharter(double ... variables) {
		initSeries(variables);
		setLayout(new FlowLayout());
		add(chartPanel);
	}

	private void initSeries(double ... variables) {
		subplot_count = variables.length;
		datasets = new XYSeriesCollection[subplot_count];
		plot = new CombinedDomainXYPlot(new NumberAxis("Step"));

		for (int i = 0; i < subplot_count; i++) {
			XYSeries series = new XYSeries(variables[i],true, false);
			series.setDescription("Variable 1");
			this.datasets[i] = new XYSeriesCollection(series);
			NumberAxis valueAxis = new NumberAxis();
			valueAxis.setAutoRange(true);
			NumberAxis domainAxis = new NumberAxis();
			domainAxis.setAutoRange(true);

			XYPlot subplot = new XYPlot(this.datasets[i], domainAxis, valueAxis, new StandardXYItemRenderer());
			subplot.setBackgroundPaint(Color.lightGray);
			subplot.setDomainGridlinePaint(Color.white);
			subplot.setRangeGridlinePaint(Color.white);
			plot.add(subplot);

			chart = new JFreeChart("Simulation", plot);
			chart.setBorderPaint(Color.black);
			chart.setBorderVisible(true);
			chart.setBackgroundPaint(Color.white);
			chart.setAntiAlias(true);
			chartPanel = new ChartPanel(chart);
			chartPanel.setMaximumSize(new Dimension(400, 200));
		}

	}


	/**
	 * reset
	 * 
	 * @param newModel
	 *            is true when the reset involves a new model
	 */
	public void reset(boolean newModel) {
		if (newModel) {
			initSeries();
			this.removeAll();
			this.add(chartPanel);
		} else {
			for (int i = 0; i < subplot_count; i++) {
				datasets[i].getSeries(0).clear();
			}
		}
		this.validate();
	}



	/****************** Listeners - Chart variables ********************************/
	/**
	 * Listener on simulation steps
	 */
	public void update(double ... variables) {
		step++;
		for (int i = 0; i < subplot_count; i++) {
			try {
				double value = variables[i];
				this.datasets[i].getSeries(0).addOrUpdate(step, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/***********JPEG METHOD***********/
	public void saveToFile(/*JFreeChart chart,*/
			String aFileName,
			int width,
			int height,
			double quality)
	throws FileNotFoundException, IOException
	{
		BufferedImage img = draw( chart, width, height );

		FileOutputStream fos = new FileOutputStream(aFileName);
		JPEGImageEncoder encoder2 =
			JPEGCodec.createJPEGEncoder(fos);
		JPEGEncodeParam param2 =
			encoder2.getDefaultJPEGEncodeParam(img);
		param2.setQuality((float) quality, true);
		encoder2.encode(img,param2);
		fos.close();
	}

	protected static BufferedImage draw(JFreeChart chart, int width, int height)
	{
		BufferedImage img =
			new BufferedImage(width , height,
					BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = img.createGraphics();


		chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));

		g2.dispose();
		return img;
	}



	/********** Public methods *********/

//	public void writeCsv(CsvWriter csvWriter) {
//
//		try {
//			for (int j = 0; j < subplot_count; j++) {
//				XYSeriesCollection columnCollection = datasets[j];
//				String[] record = new String[2];
//				record[0] = "Step";
//				record[1] = columnCollection.getSeries(0).getDescription();
//				csvWriter.writeRecord(record);
//				int itemCount = columnCollection.getSeries(0).getItems().size();
//				for (int i = 0; i < itemCount; i++) {
//					XYDataItem recordItem = (XYDataItem) columnCollection
//					.getSeries(0).getItems().get(i);
//					record[0] = new Integer(recordItem.getX().intValue())
//					.toString();
//					record[1] = recordItem.getY().toString();
//					csvWriter.writeRecord(record);
//				}
//			}
//
//		} catch (IOException e) {
//			System.err.println(" File Write Error !\n" + e);
//
//		}
//	}

}
