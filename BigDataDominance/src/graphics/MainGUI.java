package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.*;


public class MainGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public  static JComboBox<String> selectedCuisine ;
	public  static JComboBox<String> selectedScore ;
	private final String American = "American";
	private final String Italian  = "Italian";
	private final String Mexican  = "Mexican";
	private final String FastFood	= "FastFood";
	

    
	public static void main(final String[] args) {
		new MainGUI().MapView( );
	}
  

	private   void placeComponents1(JPanel panel) {
		// TODO Auto-generated method stub
		
		int x = 10 ;
		int y = 40;
		
 
		JLabel locationLabel = new JLabel("Location");
		locationLabel.setBounds(x, y, 100, 25);
		panel.add(locationLabel);

		JTextField city = new JTextField(10);
		city.setBounds(x+50, y, 25, 25);
		panel.add(city);
	 

		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(220, y, 90, 25);
		panel.add(SearchButton);
		
		JLabel GeoLabel = new JLabel("Cuisine");
		GeoLabel.setBounds(10, y, 100, 25);
		panel.add(GeoLabel);
 
		
		selectedCuisine = new JComboBox<String>();
		
		selectedCuisine.setBounds(100, 40, 100, 25);	
		selectedCuisine.addItem("Select");
		selectedCuisine.addItem(American);
		selectedCuisine.addItem(Italian);
		selectedCuisine.addItem(Mexican);
		selectedCuisine.addItem(FastFood);
 
		selectedCuisine.addActionListener(this);
		panel.add(selectedCuisine);
		
		
		JLabel Range = new JLabel("Distance(mile)");
		Range.setBounds(10, y, 60, 25);
		panel.add(Range);
		
		JTextField RangeValue = new JTextField(5);
		RangeValue.setBounds(100, y, 20, 25);
		panel.add(RangeValue);
		
		
		JLabel Price = new JLabel("Price($)");
		Price.setBounds(120, y, 100, 25);
		panel.add(Price);
		
		JTextField PriceValue = new JTextField(5);
		PriceValue.setBounds(100, y, 20, 25);
		panel.add(PriceValue);
		
		JLabel Score = new JLabel("Score");
		Score.setBounds(120, y, 100, 25);
		panel.add(Score);
		
		selectedScore = new JComboBox<String>();
		
		selectedScore.setBounds(140, y, 100, 25);	
		selectedScore.addItem("Select");
		selectedScore.addItem("5");
		selectedScore.addItem("4");
		selectedScore.addItem("3");
		selectedScore.addItem("2");
		selectedScore.addItem("1");
 
		selectedScore.addActionListener(this);
		panel.add(selectedScore);
		
		JButton SaveButton = new JButton("Update");
		SaveButton.setBounds(220, y, 80, 25);
		panel.add(SaveButton);
 
 
	}
	
	public   void setList()
	{	
		selectedCuisine.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				// TODO Auto-generated method stub
				
			Object item = selectedCuisine.getSelectedItem();
			
			if(!e.equals("Select"))
			{
			if(!item.equals("MAGNUM") || !item.equals("ALC") || !item.equals("ALC(UN-BRANDED)") ||  !item.equals("CARRIER") ||!item.equals("TKO")|| !item.equals("ETL") )
			{
				
 
				selectedCuisine.removeAllItems();
				
				selectedCuisine.setVisible(false);
			
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
	  
		
		
		
        frame.add(panel, BorderLayout.NORTH);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1300, 900);
		placeComponents1(panel);
		
		   JPanel panel2 = new JPanel();
		   panel2.setBounds(10,180,250,250);  
 
	       GeocoderExample mapView = new GeocoderExample();
	       panel2.add(mapView ,   BorderLayout.CENTER);
	       panel2.setVisible(true);
	       
	       frame.add(mapView);
 
        //frame.setLocationRelativeTo(null);
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
