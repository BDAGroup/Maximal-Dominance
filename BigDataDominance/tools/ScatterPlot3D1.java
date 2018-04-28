/**
 * 
 */
package tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.orsoncharts.Chart3D; 
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.Colors; 
import com.orsoncharts.data.xyz.XYZDataset; 
import com.orsoncharts.data.xyz.XYZSeries; 
import com.orsoncharts.data.xyz.XYZSeriesCollection; 
import com.orsoncharts.graphics3d.Dimension3D; 
import com.orsoncharts.graphics3d.ViewPoint3D; 
import com.orsoncharts.label.StandardXYZLabelGenerator; 
import com.orsoncharts.plot.XYZPlot; 
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.style.ChartStyle; 
 
/**
 * Scatter plot demo chart configuration. 
 */ 
public class ScatterPlot3D1 { 
   
    /**
     * Creates a scatter chart based on the supplied dataset. 
     *  
     * @param dataset  the dataset. 
     *  
     * @return A scatter chart.  
     */ 
    public static Chart3D createChart(XYZDataset dataset) { 
        Chart3D chart = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",  
                "Chart created with Orson Charts", dataset, "X", "Y", "Z"); 
        XYZPlot plot = (XYZPlot) chart.getPlot(); 
        plot.setDimensions(new Dimension3D(10.0, 4.0, 4.0)); 
        plot.setLegendLabelGenerator(new StandardXYZLabelGenerator( 
                StandardXYZLabelGenerator.COUNT_TEMPLATE)); 
        ScatterXYZRenderer renderer = (ScatterXYZRenderer) plot.getRenderer(); 
        renderer.setSize(0.15); 
        renderer.setColors(Colors.createIntenseColors()); 
        chart.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40)); 
        return chart; 
    } 
     
    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the 
     * demo self-contained - in practice you would normally read your data 
     * from a file, database or other source). 
     *  
     * @return A sample dataset. 
     */ 
    public static XYZDataset createDataset() { 
        XYZSeries s1 = createRandomSeries("S1", 10); 
        XYZSeries s2 = createRandomSeries("S2", 50); 
        XYZSeries s3 = createRandomSeries("S3", 150); 
        XYZSeriesCollection dataset = new XYZSeriesCollection(); 
        dataset.add(s1); 
        dataset.add(s2); 
        dataset.add(s3); 
        return dataset; 
    } 
     
    private static XYZSeries createRandomSeries(String name, int count) { 
        XYZSeries s = new XYZSeries(name); 
        for (int i = 0; i < count; i++) { 
            s.add(Math.random() * 100, Math.random() / 100, Math.random() * 100); 
        } 
        return s; 
    } 
    
    
    public static void main(String[] args)
    {
 
    	
    	  Chart3D ch = createChart(createDataset());
 
    	  DemoPanel demoPanel = new DemoPanel(new GridLayout(2,3));
 
          Chart3D chart = createChart(createDataset());
    	  chart.setStyle(ch.getStyle());

          ChartStyle sy = chart.getStyle();       
          Chart3DPanel  sd =   new Chart3DPanel(ch) ;
 
          demoPanel.addChartPanel(sd);
  
    	  JFrame frame = new JFrame();
    	  frame.setLayout(new BorderLayout());
    	  frame.setSize(700,900);
    	  frame.add(demoPanel, BorderLayout.CENTER);
    	  frame.setVisible(true);
    	
    }
     
}