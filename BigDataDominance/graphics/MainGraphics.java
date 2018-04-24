/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import graphics.GeocoderExample;
import searchQuery.Restaurants;
import searchQuery.SkylineMain;
import tools.JSonParser;
import tools.Tools;
import tools.XYLineChartExample;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
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
	private JButton btn_go_sort;
    private  JButton btn_search;
    private JButton btn_showAnalysis;
    private  JComboBox<String> cbo_cuisine;
    private  JComboBox<String> cbo_sortby;
    private  JScrollPane jScrollPane1;
    private  JScrollPane jScrollPane2;
    private  JSeparator jSeparator1;
    private  JLabel lbl_cuisine;
    private  JLabel lbl_cuisine1;
    private  JLabel lbl_header;
    private  JLabel lbl_resultsFound;
    private  JLabel lbl_search;
    private  JLabel lbl_sortby;
    private  JList<String> lst_allrestaurants;
    private  JList<String> lst_sortedrestaurants;
    public   JPanel pnl_header;
    private static javax.swing.JPanel pnl_map;
    private  JPanel pnl_results;
    private  JPanel pnl_search;
    private  JTextField txt_searchrange;
    // End of variables declaration//GEN-END:variables
   
    private static GeocoderExample mapView = new GeocoderExample();
    public static Vector<String> restuarantName =  new Vector<String>();
    public static Vector<Double[]> restuarantlatlng =  new Vector<Double[]>();
    public static Vector<Integer> restuarantPrice =  new Vector<Integer>();
	public static Vector<Double> restuarantScore =  new Vector<Double>();
	private static final String title = "Restaurants Recommendation System";
	
	public static Vector<Restaurants> kRes;
	
	public static String[] arsg  = null;
	
	public static void setStr(String[] args)
	{
		arsg = args;
	}
	
	public static String[] getString()
	{
		return arsg;
	}
	

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
        lbl_search = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_cuisine = new javax.swing.JLabel();
        lbl_cuisine1 = new javax.swing.JLabel();
        txt_searchrange = new javax.swing.JTextField();
        cbo_cuisine = new javax.swing.JComboBox<>();
        btn_search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_allrestaurants = new javax.swing.JList<>();
        lbl_resultsFound = new javax.swing.JLabel();
        pnl_results = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_sortedrestaurants = new javax.swing.JList<>();
        lbl_sortby = new javax.swing.JLabel();
        cbo_sortby = new javax.swing.JComboBox<>();
        btn_showAnalysis = new javax.swing.JButton();
        btn_go_sort = new JButton();
        pnl_map = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setLocation(new java.awt.Point(150, 50));
        setName("Main Page"); // NOI18N
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnl_header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_header.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(0, 102, 204));
        lbl_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_header.setText("A Restaurant Recommendation System");

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, 1381, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_header)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl_search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbl_search.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        lbl_search.setText("Search");

        lbl_cuisine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cuisine.setText("Cuisine:");

        lbl_cuisine1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cuisine1.setText("Searching Range/Distance (miles):");

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
        btn_search.setText("GO");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
 
        lst_allrestaurants.setModel(new AbstractListModel<String>() 
        { 
        	   Vector<String> vec  = JSonParser.getResVec();
               Vector<Double[]> lltVec =   JSonParser.getRestuarantlatlng();
               Vector<Integer> price =   JSonParser.getRestuarantPrice();
               Vector<Double> Score =   JSonParser.getRestuarantScore();
			private static final long serialVersionUID = 4267073180687045665L;
		 
            public int getSize() { 
            	 
            	if (vec.size() > 0)
              return vec.size();
            	
            	else return 40;
            }
            
            public String getElementAt(int i)
            { 
               
         		if (vec.size() > 0)
            		{
         				String info  = (i+1) + ". "+vec.get(i).toString() +
         						" \n[" + Tools.distance(41.1536674 , -81.3578859 ,
         								lltVec.get(i)[0], lltVec.get(i)[1]) 
         							+ " mi | Score " +Score.get(i)+" | Price :" + Tools.GetChar(price.get(i))+"]";
         	 
            			return info;
            		}

            	return " ";
            	 

            }
        });
        
        
        

        lst_allrestaurants.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane2.setViewportView(lst_allrestaurants);

        lbl_resultsFound.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_resultsFound.setText("");

        javax.swing.GroupLayout pnl_searchLayout = new javax.swing.GroupLayout(pnl_search);
        pnl_search.setLayout(pnl_searchLayout);
        pnl_searchLayout.setHorizontalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addComponent(lbl_cuisine)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addComponent(lbl_cuisine1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_searchrange, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_resultsFound))
                            .addGroup(pnl_searchLayout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(lbl_search)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_searchLayout.setVerticalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cuisine)
                    .addComponent(cbo_cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cuisine1)
                    .addComponent(txt_searchrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_resultsFound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
        );

        pnl_results.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lst_sortedrestaurants.setFont(new  Font("Tahoma", 1, 15)); // NOI18N
        
        
        jScrollPane1.setViewportView(lst_sortedrestaurants);

        lbl_sortby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_sortby.setText("Sort by");

        cbo_sortby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_sortby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option ..."
        		, "Top Dominating Distance-Price-Score"
        		, "Dominating Distance-Price"
        		, "Dominating Distance-Score"
        		, "Dominating Price-Score" }));

        btn_showAnalysis.setBackground(new java.awt.Color(0, 102, 204));
        btn_showAnalysis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_showAnalysis.setForeground(new java.awt.Color(255, 255, 255));
        btn_showAnalysis.setText("Show Analysis");
        btn_showAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showAnalysisActionPerformed(evt);
                int str  =  cbo_sortby.getSelectedIndex();
                int i = 0;
                switch(str)
                {
                case 0:
                	i = 0;
                break;
                
                case 1:
                	i = 1;
                break;
                
                case 2:
                	i = 2;
                	break;
                	
                case 3:
                	i = 3;
                	break;
                	
                case 4:
                	i = 4;
                	break;
                	
                }
               
                 SearchAction();
    			 
				 UpdateList();
				 
                 XYLineChartExample.DrawChart("Score", "Distance", JSonParser.getTRes(),  JSonParser.getKres() , i);
                
      
                
            }
        });
		btn_go_sort.setBackground(new java.awt.Color(0, 102, 204));
        btn_go_sort.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_go_sort.setForeground(new java.awt.Color(255, 255, 255));
        btn_go_sort.setText("GO");
        btn_go_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_go_sortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_resultsLayout = new javax.swing.GroupLayout(pnl_results);
        pnl_results.setLayout(pnl_resultsLayout);
        pnl_resultsLayout.setHorizontalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnl_resultsLayout.createSequentialGroup()
                        .addComponent(lbl_sortby)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_sortby, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_go_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_showAnalysis)
                .addGap(237, 237, 237))
        );
        pnl_resultsLayout.setVerticalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_sortby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sortby)
                    .addComponent(btn_go_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_showAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pnl_map.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_map.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_results, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btn_showAnalysisActionPerformed(java.awt.event.ActionEvent evt) { 
    	
 
    } 

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        mapView.removeAll();
        mapView = new GeocoderExample();
        lst_allrestaurants.removeAll();
        SearchAction();
        mainFrame.lbl_resultsFound.setText(restuarantName.size() +" Restaurants Found.");
        mainFrame.repaint();
        MainGraphics.pnl_map.add(mapView, BorderLayout.CENTER);
        MainGraphics.pnl_map.validate();
        MainGraphics.pnl_map.setVisible(true);
        mainFrame.add(MainGraphics.pnl_map);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void btn_go_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_go_sortActionPerformed
        // TODO add your handling code here:
        if(cbo_sortby.getSelectedIndex() > 0){
            UpdateList();
        }
        else{
            //clear list
        }
    }//GEN-LAST:event_btn_go_sortActionPerformed

    public static MainGraphics mainFrame;
    public static void main(String args[]) {
    	 
    	   setStr(args);
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
					//String str = JSonParser.RestaurantsWithInRadius(41.1536674 , -81.3578859 , "American" , JSonParser.KEy , 2);
 
					//JSonParser.getData(str);		
					
                	//restuarantName  = JSonParser.getResVec();
		 
			        mainFrame = new MainGraphics();
			        
			        MainGraphics.pnl_map.removeAll();
		           // restuarantlatlng =  JSonParser.getRestuarantlatlng();
		           // restuarantPrice  = JSonParser.getRestuarantPrice();
		           // restuarantScore  = JSonParser.getRestuarantScore();
 
		      /*      mainFrame.lbl_result.setText(restuarantName.size() + " Restuarants Found !!");

		                for (int i = 0 ; i < restuarantName.size() ; i++ )
		                {
		                	Double[] latlng = restuarantlatlng.get(i);
		                	//mapView.performGeocode( restuarantName.get(i).toString() , latlng[0] , latlng[1]  , restuarantPrice.get(i) , restuarantScore.get(i));
		                }*/
		               
		                mainFrame.txt_searchrange.setText("0");
		                mainFrame.cbo_cuisine.setSelectedIndex(0);
		          
		                MainGraphics.pnl_map.add(mapView, BorderLayout.CENTER);
		                MainGraphics.pnl_map.validate();
		                //MainGraphics.pnl_map.setVisible(true);
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

				 int index  =  cbo_sortby.getSelectedIndex();			 
				 if (index != 0)
				 {
					 Vector<Restaurants> kRes = JSonParser.getData(str, index);
					 setkRes(kRes);
				 }
				 
				 else {
					 Vector<Restaurants> kRes = JSonParser.getData(str);
					 setkRes(kRes);
				 }
 
				 
				 System.out.println("size" + kRes.size());
	 
				 Vector<Restaurants> TRes = JSonParser.getTRes();
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

	/**
	 * @return the kRes
	 */
	public static Vector<Restaurants> getkRes() {
		return kRes;
	}

	/**
	 * @param kRes the kRes to set
	 */
	public static void setkRes(Vector<Restaurants> kRes) {
		MainGraphics.kRes = kRes;
	}
	
	public void UpdateList()
	{

        lst_sortedrestaurants.setModel(new AbstractListModel<String>() 
        { 
			private static final long serialVersionUID = 1957933967234505236L;
			
			Vector<Restaurants> kres =  getkRes();
			public int getSize() { 
				try{
      
        	 if (kres.size() > 0)
        		 return kres.size();
				}
				catch(NullPointerException e)
				{
					  return 40;
				}
				  return 40;
			}
        
        public String getElementAt(int i)
        { 
			try{
             	 if (getkRes().size() > 0)
             	 {
             		  // System.out.println(kres.get(i).getName());
             		String info  = (i+1) + ". " + kres.get(i).getName() +
     						" [" + Tools.distance(41.1536674 , -81.3578859 , 
     								kres.get(i).getLat(),getkRes().get(i).getLng()) 
     							+ " mi | Score " +kres.get(i).getScore()+"| Price :" +  kres.get(i).getPrice()+"]";
        			return info;
             	 }
			}
			catch(NullPointerException e)
			{
				  
			}
        	return " ";
        }
    });
	}
 

}
