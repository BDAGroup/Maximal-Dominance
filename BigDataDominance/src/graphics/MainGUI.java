package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.*;


public class MainGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public  static JComboBox<String> selectedDevice ;
	private final String American = "American";
	private final String Italian  = "Italian";
	private final String Mexican  = "Mexican";
	private final String FastFood	= "FastFood";
	

    
	public static void main(final String[] args) {
		new MainGUI().MapView( ); 
	}
  

	private   void placeComponents1(JPanel panel) {
		// TODO Auto-generated method stub
		

		JLabel locationLabel = new JLabel("Location");
		locationLabel.setBounds(10, 10, 100, 25);
		panel.add(locationLabel);

		JTextField city = new JTextField(10);
		city.setBounds(100, 10, 25, 25);
		panel.add(city);
	 

		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(220, 10, 90, 25);
		panel.add(SearchButton);
		
		JLabel GeoLabel = new JLabel("Cuisine");
		GeoLabel.setBounds(10, 40, 100, 25);
		panel.add(GeoLabel);
 
		
		selectedDevice = new JComboBox<String>();
		
		selectedDevice.setBounds(100, 40, 100, 25);	
		selectedDevice.addItem("Select");
		selectedDevice.addItem(American);
		selectedDevice.addItem(Italian);
		selectedDevice.addItem(Mexican);
		selectedDevice.addItem(FastFood);
 
	    selectedDevice.addActionListener(this);
		panel.add(selectedDevice);
		
		
		JLabel Range = new JLabel("Distance");
		Range.setBounds(10, 65, 60, 25);
		panel.add(Range);
		
		JTextField RangeValue = new JTextField(5);
		RangeValue.setBounds(100, 65, 20, 25);
		panel.add(RangeValue);
		
		
		JLabel Price = new JLabel("Price");
		Price.setBounds(120, 65, 100, 25);
		panel.add(Price);
		
		JTextField PriceValue = new JTextField(5);
		PriceValue.setBounds(100, 65, 20, 25);
		panel.add(PriceValue);
		
		JButton SaveButton = new JButton("Update");
		SaveButton.setBounds(220, 40, 80, 25);
		panel.add(SaveButton);
	 
		

 
	}
	
	public   void setList()
	{	
		selectedDevice.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				// TODO Auto-generated method stub
				
			Object item = selectedDevice.getSelectedItem();
			
			if(!e.equals("Select"))
			{
			if(!item.equals("MAGNUM") || !item.equals("ALC") || !item.equals("ALC(UN-BRANDED)") ||  !item.equals("CARRIER") ||!item.equals("TKO")|| !item.equals("ETL") )
			{
				
 
				selectedDevice.removeAllItems();
				
				selectedDevice.setVisible(false);
			
			}
			 
			}
 
			}
		});	
		}
	

 
	
	public   void MapView()
	{

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
		
		JFrame frame = new JFrame();
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
	  
		placeComponents1(panel);
		
		
        frame.add(panel, BorderLayout.NORTH);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1300, 900);
		
		
		   JPanel panel2 = new JPanel();
		   panel2.setBounds(10,180,250,250);  
 
	       GeocoderExample mapView = new GeocoderExample();
	       panel2.add(mapView ,   BorderLayout.CENTER);
	       panel2.setVisible(true);
	       
	       frame.add(mapView);
 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		frame.setResizable(true);
		frame.repaint();
		 
		frame.validate();
	

		
	}
	
	
	

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	


	
	
	

	
	
	
	

}
