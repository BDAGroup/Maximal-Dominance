package tools;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import searchQuery.Restaurants;

/**
 * This program demonstrates how to draw XY line chart with XYDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class XYLineChartExample extends JFrame {
	
	private static Vector<Restaurants> ResV;

	public XYLineChartExample(String XAxis , String YAxis , Vector<Restaurants> Res , Vector<Restaurants> KRes , int type) {
		super("XY Line Chart Example with JFreechart");
		JPanel chartPanel = createChartPanel(XAxis , YAxis , Res , KRes , type);
		add(chartPanel, BorderLayout.CENTER);
		setSize(640, 480);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel(String XAxis , String YAxis , Vector<Restaurants> Res , Vector<Restaurants> KRes , int type) {
		String chartTitle = "Top K Restuarants";

		XYDataset dataset = createDataset(Res ,  KRes , type);
		
		boolean showLegend = true;
		boolean createURL = false;
		boolean createTooltip = true;
		
	/*	JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, 
				, dataset, 
 				PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);*/
		//
 
		
		if (type == 2)
		{
			XAxis = "Distance";
			YAxis = "Price";
		}
		else if (type ==3)
		{
			XAxis = "Distance";
			YAxis = "Score";
		}
		else if (type == 4)
		{
			XAxis = "Price";
			YAxis = "Score";
			
		}
	 
		
		
		 JFreeChart chart = ChartFactory.createScatterPlot( chartTitle,   XAxis, YAxis, dataset , PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);
		 customizeChart(chart);
		
		
	/*	// saves the chart as an image files
		File imageFile = new File("XYLineChart.png");
		int width = 640;
		int height = 480;
		
		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (IOException ex) {
			System.err.println(ex);
		}*/
		
		return new ChartPanel(chart);
	}

	private XYDataset createDataset(Vector<Restaurants> Res , Vector<Restaurants> KRes , int type) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		XYSeries series1 = new XYSeries("Restaurants");
		XYSeries series2 = new XYSeries("K-Restaurants");
		
 
		if (type == 2)
		{
			for(int i = 0 ; i < Res.size() ; i++)
			{
				series1.add( Res.get(i).getDistance()  ,Res.get(i).getPrice());
			}
			
			
			for(int k = 0 ; k < KRes.size() ; k++)
			{
				series2.add( KRes.get(k).getDistance()  , KRes.get(k).getPrice());
			}
		}
		
		
		else if (type == 3)
		{
			for(int i = 0 ; i < Res.size() ; i++)
			{
				series1.add( Res.get(i).getDistance()  ,Res.get(i).getScore());
			}
			
			
			for(int k = 0 ; k < KRes.size() ; k++)
			{
				series2.add( KRes.get(k).getDistance()  , KRes.get(k).getScore());
			}
		}
		
		
		
		else if (type == 4)
		{
			for(int i = 0 ; i < Res.size() ; i++)
			{
				series1.add( Res.get(i).getPrice()  ,Res.get(i).getScore());
			}
			
			
			for(int k = 0 ; k < KRes.size() ; k++)
			{
				series2.add( KRes.get(k).getPrice()  , KRes.get(k).getScore());
			}
			
		}
		
 
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		
		
		return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.YELLOW);

		// sets thickness for series (using strokes)
		 renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		 renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
	     plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
	
	public static void DrawChart(String XAxis , String YAxis ,  Vector<Restaurants> Res , Vector<Restaurants> KRes , int type )
	{ 
  	   
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
 
				XYLineChartExample sline =  new XYLineChartExample(  XAxis ,   YAxis ,    Res , KRes , type);
				sline.setVisible(true);
			}
		});	
	}
	

}