package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class Dump {
	
	private static JPanel contentPane;
	private static JScrollPane sensorInfoScroll;
	private static JLabel map;
    public static final int MIN_ZOOM = 0;
    public static final int MAX_ZOOM = 21;
    private static int zoomValue = 4;
	
	public static void map2()
	{
		final Browser browser =new Browser();
        JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue < MAX_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
                }
            }
        });
        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue > MIN_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
                }
            }
        });
        JPanel toolBar = new JPanel();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        
    	BrowserView view = new BrowserView(browser);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        browser.loadURL("map.html");
  
		
	}
	
	
	/*	
	public static void MainFrame( )
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		frame.add(panel);	
	 

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setResizable(false);
		placeComponents1(panel);
		frame.setLocationRelativeTo(null);	
		frame.setVisible(true);
		frame.repaint();
		frame.validate();
		
		
		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);
		
		final GeocoderExample mapView = new GeocoderExample();
	     
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
		frame.add(view, BorderLayout.CENTER);
		frame.setSize(1300, 900);
		frame.setVisible(true);
 
        frame.add(mapView, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
         
	}*/

}
