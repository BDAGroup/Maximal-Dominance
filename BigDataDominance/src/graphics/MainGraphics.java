/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import graphics.GeocoderExample;
import tools.JSonParser;
import tools.Tools;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.simple.parser.ParseException;

/**
 *
 * @author Pavan
 */
public class MainGraphics extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Frm_Main
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private   JButton btn_search;
    private  JComboBox<String> cbo_cuisine;
    private  JComboBox<String> cbo_sortby;
    private  JScrollPane jScrollPane1;
    private  JSeparator jSeparator1;
    private  JSeparator jSeparator2;
    private JLabel lbl_cuisine;
    private JLabel lbl_cuisine1;
    private  JLabel lbl_header;
    private   JLabel lbl_result;
    private  JLabel lbl_search;
    private  JLabel lbl_sortby;
    private  JList<String> lst_restaurants;
    public  JPanel pnl_header;
    private static  JPanel pnl_map;
    private  JPanel pnl_results;
    private  JPanel pnl_search;
    private JTextField txt_searchrange;
    // End of variables declaration//GEN-END:variables
   
    private static GeocoderExample mapView = new GeocoderExample();
    public static Vector<String> restuarantName =  new Vector<String>();
    public static Vector<Double[]> restuarantlatlng =  new Vector<Double[]>();
    public static Vector<Integer> restuarantPrice =  new Vector<Integer>();
	public static Vector<Double> restuarantScore =  new Vector<Double>();
	
 

	public MainGraphics() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_header = new  JPanel();
        lbl_header = new  JLabel();
        pnl_search = new  JPanel();
        lbl_search = new  JLabel();
        jSeparator1 = new  JSeparator();
        lbl_cuisine = new  JLabel();
        lbl_cuisine1 = new  JLabel();
        txt_searchrange = new  JTextField();
        cbo_cuisine = new  JComboBox<>();
        btn_search = new  JButton();
        pnl_results = new  JPanel();
        lbl_result = new  JLabel();
        jSeparator2 = new  JSeparator();
        jScrollPane1 = new  JScrollPane();
        lst_restaurants = new  JList<>();
        lbl_sortby = new  JLabel();
        cbo_sortby = new  JComboBox<>();
        pnl_map = new  JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(150, 50));
        setName("Main Page"); // NOI18N
        addWindowStateListener(new  WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        pnl_header.setBorder( BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_header.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(0, 102, 204));
        lbl_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_header.setText("Top Dominating Restaurants Finder");

        javax.swing.GroupLayout pnl_headerLayout = new  GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_header)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnl_search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbl_search.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        lbl_search.setText("Search Attributes");

        lbl_cuisine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cuisine.setText("Cuisine:");

        lbl_cuisine1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cuisine1.setText("Searching Range/Distance (mile):");

        txt_searchrange.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_searchrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchrangeActionPerformed(evt);
            }
        });

        cbo_cuisine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_cuisine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a cuisine ...", 
        		"American", 
        		"Italian", 
        		"Mexican",
        		"Japanese", 
        		"Chinese", 
        		"Indian", 
        		"Nepalese", 
        		"Thai" ,
        		"Mediterranean",
        		"Turkish", 
        		"Greek", 
        		"Caribbean"}));

        btn_search.setBackground(new java.awt.Color(0, 102, 204));
        btn_search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");

        javax.swing.GroupLayout pnl_searchLayout = new javax.swing.GroupLayout(pnl_search);
        pnl_search.setLayout(pnl_searchLayout);
        pnl_searchLayout.setHorizontalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lbl_search))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addComponent(lbl_cuisine)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addComponent(lbl_cuisine1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_searchrange, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_searchLayout.setVerticalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cuisine)
                    .addComponent(cbo_cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cuisine1)
                    .addComponent(txt_searchrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btn_search)
                .addGap(21, 21, 21))
        );
        
        
        btn_search.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub+
						
						 mapView.removeAll();
						 mapView = new GeocoderExample();			
						 lst_restaurants.removeAll();
						 SearchAction();
						
				         mainFrame.lbl_result.setText(restuarantName.size() + " Restuarants Found !!");
				       
				         mainFrame.repaint();
				         MainGraphics.pnl_map.add(mapView, BorderLayout.CENTER);
			             MainGraphics.pnl_map.validate();
			             MainGraphics.pnl_map.setVisible(true);
			             mainFrame.add(MainGraphics.pnl_map);
			             mainFrame.setVisible(true);
			           
			            // mainFrame.repaint();
				  		 
					}
        	
        	
        		});

        pnl_results.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbl_result.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_result.setText("Results");
        lst_restaurants.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Vector<String> vec  = restuarantName;
        
        Vector<Double[]> lltVec =   JSonParser.getRestuarantlatlng();
        Vector<Integer> price =   JSonParser.getRestuarantPrice();
        Vector<Double> Score =   JSonParser.getRestuarantScore();
      
        lst_restaurants.setModel(new AbstractListModel<String>() 
        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 4267073180687045665L;
			String[] strings = { "1. Restaurant 1", "2. Restaurant 2", "3. Restaurant 3", "4. Restaurant 4", "5. Restaurant 5" };
            
            public int getSize() { 
            	
            	if (vec.size() == 0)
            	
            	return strings.length; 
            	
            	else 
            		return vec.size();
            }
            
            public String getElementAt(int i)
            { 
            	if (vec.size() == 0)
            	return strings[i]; 
            	
            	else
            		{
 
            		if (lltVec.size() > 0)
            		{
            			return vec.get(i).toString() + " [" + Tools.distance(41.1536674 , -81.3578859 , lltVec.get(i)[0], lltVec.get(i)[1]) + " mi ] [ Score " +Score.get(i)+"| Price :" + 													Tools.GetChar(price.get(i))+"]";
            		}
            		
            		
            		else {
            			  return vec.get(i).toString();
            		}

            		}
            	
            }
        });
        jScrollPane1.setViewportView(lst_restaurants);

        lbl_sortby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_sortby.setText("Sort by");

        cbo_sortby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_sortby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top Dominating Score", "Dominating Price", "Dominating Distance", "Dominating Ratings" }));

        javax.swing.GroupLayout pnl_resultsLayout = new javax.swing.GroupLayout(pnl_results);
        pnl_results.setLayout(pnl_resultsLayout);
        pnl_resultsLayout.setHorizontalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lbl_result)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addGap(0, 79, Short.MAX_VALUE)
                        .addComponent(lbl_sortby)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_sortby, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_resultsLayout.setVerticalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addComponent(lbl_result, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_sortby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sortby))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        pnl_map.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_map.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_results, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_results, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnl_map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchrangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchrangeActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
       if ((evt.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
//           Point newLocation = this.getContentPane().getLocationOnScreen();
//           newLocation.translate(400, 15);
//           lbl_header.setBounds(500, 10, lbl_header.getWidth(), lbl_header.getHeight());
//           //this.pnl_header.removeAll();
//           this.pnl_header.add(lbl_header);
//           this.pnl_header.validate();
       }
    }//GEN-LAST:event_formWindowStateChanged

    private static MainGraphics mainFrame;
    public static void main(String args[]) {
 
  	  PatternTheme pat =  new PatternTheme();
    	try {
    		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"); 	
    		 	pat.setUpColor();	
    		 	pat.setName("Search Engine");
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
					String str = JSonParser.RestaurantsWithInRadius(41.1536674 , -81.3578859 , "Mexican" , JSonParser.KEy , 4);
					
					
					JSonParser.getData(str);		
					
					restuarantName  = JSonParser.getResVec();
			        mainFrame = new MainGraphics();
			        MainGraphics.pnl_map.removeAll();
  
		            restuarantlatlng =  JSonParser.getRestuarantlatlng();
		            restuarantPrice  = JSonParser.getRestuarantPrice();
		            restuarantScore  = JSonParser.getRestuarantScore();
 
		            mainFrame.lbl_result.setText(restuarantName.size() + " Restuarants Found !!");
		            
		            
		                for (int i = 0 ; i < restuarantName.size() ; i++ )
		                {
		                	Double[] latlng = restuarantlatlng.get(i);
		                	mapView.performGeocode( restuarantName.get(i).toString() , latlng[0] , latlng[1]  , restuarantPrice.get(i) , restuarantScore.get(i));
		                }
		               
		                mainFrame.txt_searchrange.setText("4");
		                mainFrame.cbo_cuisine.setSelectedIndex(3);
		                
		                
		                MainGraphics.pnl_map.add(mapView, BorderLayout.CENTER);
		                MainGraphics.pnl_map.validate();
		                MainGraphics.pnl_map.setVisible(true);
		                mainFrame.setResizable(true);
		                mainFrame.setVisible(true);
		               
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             
            }
        });
    }
    
    
    public void SearchAction()
    {
    	String cuisine = cbo_cuisine.getSelectedItem().toString();
    	
    	double radius =  Double.parseDouble(txt_searchrange.getText().toString().trim());
    	
    	restuarantName.removeAllElements();
    	restuarantlatlng.removeAllElements();
    	restuarantScore.removeAllElements();
    	restuarantPrice.removeAllElements();
    	
    	if(!cuisine.isEmpty() && radius != 0.0)
    	{
			try {
				 String str  = JSonParser.RestaurantsWithInRadius(41.1536674 , -81.3578859 , cuisine , JSonParser.KEy , radius);
				 JSonParser.getData(str);
				 restuarantName   = JSonParser.getResVec();
				 restuarantlatlng =  JSonParser.getRestuarantlatlng();
				 restuarantPrice  = JSonParser.getRestuarantPrice();
				 restuarantScore  = JSonParser.getRestuarantScore();
 
				 for (int i = 0 ; i < restuarantName.size() ; i++ )
	                {
					 	 Double[] latlng = restuarantlatlng.get(i);
					     mapView.performGeocode( restuarantName.get(i).toString() , latlng[0] , latlng[1]  , restuarantPrice.get(i) , restuarantScore.get(i));
	                }
				
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
    	}
    	
 
    }
    
    
    

}
