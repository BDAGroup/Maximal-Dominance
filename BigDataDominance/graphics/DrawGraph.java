/**
 * 
 */
package graphics;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JWindow;

import com.sun.awt.AWTUtilities;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import searchQuery.Restaurants;

/**
 * @author MagnumES
 *
 */
public class DrawGraph extends Application {
	
	 final JFXPanel p = new JFXPanel();
	  private static String xAxis = null;
	  private static String yAxis = null;
	  private static Vector<Restaurants> TotalRes = null;
	  private static Vector<Restaurants> SkylineRes = null;
	  
 
	
	  /**
	 * @return the xAxis
	 */
	public static String getxAxis() {
		return xAxis;
	}

	/**
	 * @param xAxis the xAxis to set
	 */
	public static void setxAxis(String xAxis) {
		 DrawGraph.xAxis = xAxis;
	}

	/**
	 * @return the yAxis
	 */
	public static String getyAxis() {
		return yAxis;
	}

	/**
	 * @param yAxis the yAxis to set
	 */
	public static void setyAxis(String yAxis) {
		 DrawGraph.yAxis = yAxis;
	}

	/**
	 * @return the totalRes
	 */
	public static Vector<Restaurants> getTotalRes() {
		return TotalRes;
	}

	/**
	 * @param totalRes the totalRes to set
	 */
	public static void setTotalRes(Vector<Restaurants> totalRes) {
		TotalRes = totalRes;
	}

	/**
	 * @return the skylineRes
	 */
	public static Vector<Restaurants> getSkylineRes() {
		return SkylineRes;
	}

	/**
	 * @param skylineRes the skylineRes to set
	 */
	public static void setSkylineRes(Vector<Restaurants> skylineRes) {
		SkylineRes = skylineRes;
	}
 
	@Override
	  public void start(Stage stage) {
	    final NumberAxis xAxis = new NumberAxis();
	    final NumberAxis yAxis = new NumberAxis();
	    
	    StackPane secondaryLayout = new StackPane();
	  
	    
	    xAxis.setLabel(getxAxis());
	    yAxis.setLabel(getyAxis());
	    
	    final LineChart<Number, Number> lineChart = new LineChart<Number, Number>( xAxis, yAxis);

	    lineChart.setTitle("Sky Line Restaurants");
	    XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
	    
	    XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
	    series.setName("TotalRestaurants");
	 
	    Vector<Restaurants> res = getTotalRes();
	    
	    for (int i = 0 ; i < res.size() ; i++)
	    {
		    series.getData().add(new XYChart.Data<Number, Number>(i, res.get(i).getDistance()));
		    
		     System.out.println("Dis " + res.get(i).getDistance());
	    }
	    
	    Vector<Restaurants> Kres = getSkylineRes();
	    
	    series1.setName("K Resturants");
	    for (int k = 0 ; k < Kres.size() ; k++)
	    {
		    series1.getData().add(new XYChart.Data<Number, Number>(k, Kres.get(k).getDistance()));
		    
		    System.out.println("S " + Kres.get(k).getDistance());
	    }
	   
	    Scene scene = new Scene(lineChart, 800, 600); 
	    lineChart.getData().add(series);
	    lineChart.getData().add(series1);
	    
	   /*    Stage newWindow = new Stage();
	    
	       newWindow.setTitle("Second Stage");
  //https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/swing-fx-interoperability.htm
	       newWindow.setScene(scene);
	    
	     // Specifies the modality for new window.
	       newWindow.initModality(Modality.WINDOW_MODAL);
	       newWindow.initOwner(stage);
 
	       newWindow.setX(stage.getX() + 200);
	       newWindow.setY(stage.getY() + 100);
	       newWindow.show();
	   
	       StackPane root = new StackPane();
	       Scene scenea = new Scene(root, 450, 250);
	       stage.setScene(scenea);
	       //stage.show();
*/	         stage.setScene(scene);
	         p.setScene(scene);
	         JFrame jf = new JFrame();
	         jf.setSize(300, 200);
	       	 jf.getContentPane().add(p);
			 jf.setResizable(false);
			 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			 
			 JPanel pan = new JPanel();
			 pan.setLayout(new FlowLayout());
			 jf.add(pan);
			 
			 jf.setLocationRelativeTo(null);
			 jf.setVisible(true);
			 jf.getContentPane().removeAll();
			 jf.getContentPane().add(pan);		 
			 jf.repaint();
			 jf.validate();
			 stage.show();
	  }
	
	public static void LaunchChart(  )
	{
		// this is launch 
		 launch(MainGraphics.arsg);
		 
	}

/*	public static void LaunchChart(String[] args , JWindow myJFrame)
	{
		launch(args);
 
	    myJFrame =new JWindow();
	    myJFrame.setLayout(MainGraphics.mainFrame.getLayout());
	    myJFrame.setLocationRelativeTo(MainGraphics.mainFrame.getContentPane());
	    myJFrame.setOpacity(0.9f);
	    myJFrame.setAlwaysOnTop(true);
	    AWTUtilities.setWindowOpaque(myJFrame, false);
	    myJFrame.pack();
	    myJFrame.setVisible(true);	    
		myJFrame.repaint();	   
	}*/

}
