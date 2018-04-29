/**
 * 
 */
package tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import com.orsoncharts.Chart3D; 
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.Colors; 
import com.orsoncharts.data.xyz.XYZDataset; 
import com.orsoncharts.data.xyz.XYZSeries; 
import com.orsoncharts.data.xyz.XYZSeriesCollection; 
import com.orsoncharts.graphics3d.Dimension3D; 
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.label.StandardXYZLabelGenerator; 
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.LineXYZRenderer;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.style.ChartStyle;

import searchQuery.Restaurants; 
 
public class Skyline3DChart { 
   

    public static Chart3D createChart(XYZDataset dataset) { 
        Chart3D chart = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",  
                "Top K Restaurants", dataset, "Distance", "Score", "Price"); 
      /*  
        Chart3D chart = Chart3DFactory.createXYZLineChart("ScatterPlot3DDemo1",  
                "Top K Restaurants", dataset, "Distance", "Score", "Price"); */
       
        XYZPlot plot = (XYZPlot) chart.getPlot(); 
        plot.setDimensions(new Dimension3D(15.0, 8.0, 8.0)); 
        plot.setLegendLabelGenerator(new StandardXYZLabelGenerator( 
                StandardXYZLabelGenerator.COUNT_TEMPLATE)); 
        
        
        ScatterXYZRenderer renderer = (ScatterXYZRenderer) plot.getRenderer(); 
        renderer.setSize(0.15); 
        renderer.setColors(Colors.createIntenseColors()); 
        
        /*LineXYZRenderer renderer = (LineXYZRenderer) plot.getRenderer(); 
        renderer.setColors(Colors.createIntenseColors()); 
        renderer.setPlot(plot);
        renderer.setNotify(true);*/
        
        chart.setViewPoint(ViewPoint3D.createAboveLeftViewPoint(40)); 
        return chart; 
    } 
     

    public static XYZDataset createDataset(Vector<Restaurants> Tres , Vector<Restaurants> Kres) { 
        XYZSeries s1 = createRandomSeries("Total Restaurants", Tres); 
        
        XYZSeries s2 = createRandomSeries("K Restaurants",  Kres); 
        //XYZSeries s3 = createRandomSeries("S3", 150); 
        
        XYZSeriesCollection dataset = new XYZSeriesCollection(); 
        dataset.add(s1); 
        dataset.add(s2); 
       // dataset.add(s3); 
        return dataset; 
    } 
     
    private static XYZSeries createRandomSeries(String name, Vector<Restaurants> vec) { 
        XYZSeries s = new XYZSeries(name); 
        for (int i = 0; i < vec.size(); i++) { 
            s.add(vec.get(i).getDistance() ,  vec.get(i).getScore() , vec.get(i).getPrice() ); 
        } 
        return s; 
    } 
    
    
    public static void CreateChart(Vector<Restaurants> Tres , Vector<Restaurants> Kres)
    {
    	  
   	     DemoPanel demoPanel = new DemoPanel(new GridLayout(2,2));
         Chart3D chart = createChart(createDataset( Tres , Kres));      
   	     
         chart.setTitle("Top K Restaurants(Distance , Score , Price)");
         chart.setAntiAlias(true);
        
         Chart3DPanel  sd =   new Chart3DPanel(chart) ;
         sd.setPreferredSize(new Dimension(50 , 50));
         sd.setBorder(BorderFactory.createCompoundBorder(
                 BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), 
                 BorderFactory.createLineBorder(Color.DARK_GRAY)));
         sd.setMargin(0.35);

         
         demoPanel.add(new DisplayPanel3D(sd, false, true));
         demoPanel.addChartPanel(sd);
         demoPanel.setPreferredSize(new Dimension(400, 400));
        
   	  JFrame frame = new JFrame();
   	  frame.setLayout(new BorderLayout());
   	  frame.setSize(1500,1200);
   	  frame.add(demoPanel, BorderLayout.CENTER);
   	  frame.setVisible(true);
    }
     
}