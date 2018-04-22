package graphics;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.LatLngBounds;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.swing.MapView;
import tools.Tools;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


    
public class GeocoderExample extends MapView {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1469920719412108553L;

	private static final String INITIAL_LOCATION = "Kent";

    private OptionsWindow optionsWindow;

    public GeocoderExample() {
     
        setOnMapReadyHandler(new MapReadyHandler() {
            @SuppressWarnings("deprecation")
			@Override
            public void onMapReady(MapStatus status) {
                // Getting the associated map object
                final Map map = getMap();
                // Setting initial zoom value
                map.setZoom(14.0);
                
                LatLng location = new LatLng(41.1536674 , -81.3578859);
                
                map.setCenter(location);

                // Creating a map options object
                @SuppressWarnings("deprecation")
				MapOptions options = new MapOptions(map);
                // Creating a map type control options object
                MapTypeControlOptions controlOptions = new MapTypeControlOptions(map);
                // Changing position of the map type control
                controlOptions.setPosition(ControlPosition.RIGHT_BOTTOM);
                // Setting map type control options
                options.setMapTypeControlOptions(controlOptions);
                // Setting map options
                map.setOptions(options);

               performGeocode(INITIAL_LOCATION);
            }
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();

        optionsWindow = new OptionsWindow(this, new Dimension(500, 600)) {
            @Override
            public void initContent(JWindow contentWindow) {
                JPanel content = new JPanel(new GridBagLayout());
                content.setBackground(Color.white);

                Font robotoPlain18 = new Font("Roboto", 0, 18);
                final JTextField searchField = new JTextField();
                searchField.setText(INITIAL_LOCATION);
                searchField.setToolTipText("Enter address or coordinates...");
                searchField.setBorder(BorderFactory.createEmptyBorder());
                searchField.setFont(robotoPlain18);
                searchField.setForeground(new Color(0x21, 0x21, 0x21));
                searchField.setUI(new SearchFieldUI(searchField));

                final JButton searchButton = new JButton();
                
                try {
					BufferedImage deviceImage   = ImageIO.read(new File("res/search.png"));
					searchButton.setIcon(new ImageIcon( deviceImage));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
                 
                //searchButton.setRolloverIcon(new ImageIcon(MapOptionsExample.class.getResource("/res/connect.png")));  */   
                searchButton.setBorder(BorderFactory.createEmptyBorder());
                searchButton.setUI(new BasicButtonUI());
                searchButton.setOpaque(false);
                ActionListener searchActionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        performGeocode(searchField.getText());
                    }
                };
                searchButton.addActionListener(searchActionListener);
                searchField.addActionListener(searchActionListener);

                content.add(searchField, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 11, 11, 11), 0, 0));
                content.add(searchButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(11, 0, 11, 11), 0, 0));

                contentWindow.getContentPane().add(content);
            }

            @Override
            protected void updatePosition() {
                if (parentFrame.isVisible()) {
                    Point newLocation = parentFrame.getContentPane().getLocationOnScreen();
                    newLocation.translate(400, 110);
                    contentWindow.setLocation(newLocation);
                    contentWindow.setSize(150, 40);
                }
            }
        };
    }

    class SearchFieldUI extends BasicTextFieldUI {
        private final JTextField textField;

        public SearchFieldUI(JTextField textField) {
            this.textField = textField;
        }

        @Override
        protected void paintBackground(Graphics g) {
            super.paintBackground(g);
            String toolTipText = textField.getToolTipText();
            String text = textField.getText();
            if (toolTipText != null && text.isEmpty()) {
                paintPlaceholderText(g, textField);
            }
        }

        protected void paintPlaceholderText(Graphics g, JComponent c) {
            g.setColor(new Color(0x75, 0x75, 0x75));
            g.setFont(c.getFont());
            String text = textField.getToolTipText();
            if (g instanceof Graphics2D) {
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
            g.drawString(text, 0, 14);
        }
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        optionsWindow.dispose();
    }

    public void performGeocode(String text) {
        // Getting the associated map object
    	
    	try{
        final Map map = getMap();
        // Creating a geocode request
        GeocoderRequest request = new GeocoderRequest(map);
        // Setting address to the geocode request
 
        request.setAddress(text);
   
        // Geocoding position by the entered address
        getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
            @Override
            public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                // Checking operation status
                if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                    // Getting the first result
                    GeocoderResult result = results[0];
        
                    LatLng location = result.getGeometry().getLocation();
  
                    // Setting the map center to result location

                    // Creating a marker object
                    Marker marker = new Marker(map);
                    // Setting position of the marker to the result location
                    marker.setPosition(location);
                    
                   
                    map.setCenter( marker.getPosition());
 
                    // Creating an information window
                    InfoWindow infoWindow = new InfoWindow(map);
                    // Putting the address and location to the content of the information window
                    infoWindow.setContent("<b>" + text+ "</b><br>" + location.toString());
                    // Moving the information window to the result location
                    infoWindow.setPosition(location);
                    // Showing of the information window
                    infoWindow.open(map, marker);
                }
            }
        });
    }
    	  catch(Exception e )
        {
        	
        }
    }
    
    public void performGeocode(String Name ,Double lat , Double lon  , int Price, Double Score) {
        // Getting the associated map object
    	try{
        final Map map = getMap();
        // Creating a geocode request
        @SuppressWarnings("deprecation")
		GeocoderRequest request = new GeocoderRequest(map);
        // Setting address to the geocode request
        LatLng location = new LatLng( lat , lon);
        
        request.setLocation(location);
        // Geocoding position by the entered address
        getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
            @Override
            public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                // Checking operation status
                if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                    // Getting the first result
                    GeocoderResult result = results[0];
                    LatLng location = result.getGeometry().getLocation();
                    // Setting the map center to result location
                    map.setCenter(location);
                    // Creating a marker object
                    Marker marker = new Marker(map);
                    // Setting position of the marker to the result location
                    marker.setPosition(location);
                    
                    marker.setTitle(Name);
                    // Creating an information window
                    InfoWindow infoWindow = new InfoWindow(map);
                    // Putting the address and location to the content of the information window
                     String dis  = Tools.distance(41.1536674 , -81.3578859, lat, lon) + " mi";
   
                    infoWindow.setContent("<b>" + Name+ "</b><br> Dis: " + dis + "</b><br> Score: " + Score + "</b><br>Price: " + Tools.GetChar(Price));
                    // Moving the information window to the result location
                    infoWindow.setPosition(location);
                    // Showing of the information window
                    infoWindow.open(map, marker);
                }
            }
        });
    }
    	  catch(Exception e )
        {
        	
        }
    }
    
 
 
}