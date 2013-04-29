package com.charts.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.niftysol.androcharts.AreaChart;
import com.niftysol.androcharts.ColorStyle;
import com.niftysol.androcharts.ColumnChart;
import com.niftysol.androcharts.DataTable;
import com.niftysol.androcharts.LineChart;
import com.niftysol.androcharts.PieChart;
import com.niftysol.androcharts.Series;


public class AndroChartDemo extends Activity{
	
	RelativeLayout main;
	int click;
	int colstyle[];
	DataTable datatbl;
	ColumnChart mChart;
	PieChart pChart;
	LineChart liChart;
	AreaChart aChart;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_andro_chart_demo);
    	 main=(RelativeLayout)findViewById(R.id.Main);
    	 
    	
  
    	
    	// instantiate data table object   	 
    	datatbl=new DataTable();
  
    	//set categories as a string array
    	datatbl.setCategories(new String[]{"Jan","Feb","Mar","Apr"});
    	
    	//add series with first string specifies series name and second float array specifies values for categories
    	//Note: category string array length must be of same size that of series value float array
    	datatbl.addSeries("Google", new float[]{45,75.6f,91.3f,30});
    	
        
    	
    	//you can add as many series you want
    	//alternatively you may add series as follow, this is useful when adding series data dynamically via cursor or any other data source
    	Series s=new Series("Amazon",    new float[]{12,70,40,55});
    	datatbl.addSeries(s);
    	
    	
    	
    	

    	
    	//retrieve Chart_Type to display selected chart
    	Bundle b;
    	b=getIntent().getExtras();
    	int i=(Integer)b.get("Chart_Type");
    	
    	
    	if(i==1)
        {
    			//  <--    Column Chart Default    -->
    		
              // instantiate type of view, here in this case it is ColumnChart
                 mChart=new ColumnChart(this); 
        		
        		
              // set DataTable object as its data source
                 mChart.setDataTable(datatbl);
       	 		
              // as all Chart views are subclasses of standard Android view, where the power of this library lies.
              // so, you may treat chart object as normal standard android view, as shown below how Layout parameter is set.                 
                 RelativeLayout.LayoutParams chartLay=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
                   
       	 		// we recommend you to set activity theme  android:theme="@android:style/Theme.Light.NoTitleBar.Fullscreen" in manifest for best view when 
       	 		// layout parameters are fill_parent

       	 		
       	 		// specify type of ColumnChart, Note that default is non stacked chart, so you may remove below property
                 mChart.setChartStyle(ColumnChart.DEFAULT);   
                
                
              // specify one of Default ColorStyle available in library, Note : Default is ColorStyle.MONO
              // if you want to specify your own ColorStyle then set any color as a parameter, library automatically generates color series using standard color range algorthm
              // e.g.  mChart.setSeriesColorStyle(Color.GRAY); 
              
                 mChart.setSeriesColorStyle(ColorStyle.BLUEBERRY);    
                
                
              // if you want to specify each different color for Series then, remove setSeriesColorStyle(int ColrStyle); and set individual color as below.
              // e.g.   mChart.setSeriesColors(new int[]{Color.YELLOW,Color.BLUE,Color.RED}); where int[] size must be same as number of series in datatable, in this case it is three, Google, Apple and Amazon
                
              // set Chart title , if you don't want chart title then remove below property.
                 mChart.setTitle("Service sell statistics : Jan 2012 - Jun 2012");  
                
                
              // set X and Y axis title
                 mChart.setXAxisTitle("Months");
                 mChart.setYAxisTitle("sell (in US M$)");   
             //  mChart.setBackgroundColor(Color.BLUE);
                
                
                
              // you may customize chart using following properties, 
              // Note: Default colors and text sizes are optimized for most uses, so avoid using unless it is important. 
                
         /*      mChart.setAxisTitleTextsize(30);             
                 mChart.setAxisTitleColor(Color.GREEN);
              
                 mChart.setAxisLabelTextsize(25);
                 mChart.setAxisLabelColor(Color.GRAY);
              
                 mChart.setAxisColor(Color.DKGRAY);
                 mChart.setTypeface(Typeface.SERIF);
                 
                 mChart.setTitleTextSize(40);
                 mChart.setTitleColor(Color.GRAY);        */ 
                
                
                
                
             // use below property to show or hide Legend Area, note: Default is true, so you may remove below property.
                mChart.showLegendArea(true);
                
                
             // in addition to above properties,as we stated above you may set padding, margin and many more properties that are available for standard view.
             // its simple to use , you can draw chart using maximum 4 line of code
          	    main.addView(mChart,chartLay);
          	      	
          	   
        	
        }
        
    	else if(i==2)
        {	
    		
    			//  <--    Column Chart Stacked   -->
    		
    		
               mChart=new ColumnChart(this); 
	       	 	 mChart.setDataTable(datatbl);
	       	 	
	       	 	
	             RelativeLayout.LayoutParams chartLay=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);	      
	
	          // you must set this property when you want stacked column charts 
	             mChart.setChartStyle(ColumnChart.STACKED);
	            
	            
	          // below properties are same as explained for Non Stacked (Default) Column Chart
	            
	             mChart.setSeriesColorStyle(ColorStyle.CYAN); 	            
	             mChart.setXAxisTitle("Months");
	             mChart.setYAxisTitle("sell (in US M$)");       
	             mChart.setTitle("Service sell statistics : Jan 2012 - Jun 2012");
	            
	            
	             main.addView(mChart,chartLay);
        }

    	else if(i==3)   	   		
        {
    		
    			//  <--    Pie Chart   -->
    		
    		
	        	   pChart=new PieChart(this); 
	        	 
	          // Note: pie charts is always drawn for first series, in this case it is Google.
	         	  pChart.setDataTable(datatbl);
	         	  RelativeLayout.LayoutParams chartLay2=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);       
	        	
	        	   pChart.setColorStyle(ColorStyle.MONO);
	         	  pChart.setTitle("Service sell statistics : Jan 2012 - Jun 2012");
	         	
	          // specify where data label lies,
	         	  pChart.setDataLabelStyle(PieChart.OUT);
	         	
 	
	         	  pChart.setTitleTextSize(12);
	          // uncomment below properties to customize pie chart
	        	
	       /*  	
	         	  pChart.setTitleColor(Color.RED);        	
	         	  pChart.setDataLabelTextSize(20);	         	  */
	   
	        	
	        	   main.addView(pChart,chartLay2);
        	
	       
        }
           
    	else if(i==4)
        {
    		
    		//  <--   Line Chart   -->
    		
    		
    		
        	    liChart=new LineChart(this);      
              liChart.setDataTable(datatbl);
            
              RelativeLayout.LayoutParams chartLay3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);         
              liChart.setSeriesColorStyle(ColorStyle.RED_DARK);
             
              liChart.setTitle("Service sell statistics : Jan 2012 - Jun 2012");
              liChart.setXAxisTitle("Months");
              liChart.setYAxisTitle("sell (in US M$)");
             
             
       //     uncomment below properties to customize Line chart
             
        /*    liChart.setAxisTitleTextsize(25);
              liChart.setAxisTitleColor(Color.GREEN);
            
              liChart.setAxisLabelTextsize(15);
              liChart.setAxisLabelColor(Color.BLUE);
              liChart.setAxisColor(Color.GREEN);
             
             
              liChart.setTitleTextSize(21);           
              liChart.setTitleColor(Color.GREEN);           
              liChart.showLegendArea(false);                     */
           
          	  main.addView(liChart,chartLay3);
        }  
        
    	else
        {
    		
    		//  <--   Area Chart   -->
    		
    		
    		
    		     aChart=new AreaChart(this);      
    		     aChart.setDataTable(datatbl);         
             RelativeLayout.LayoutParams chartLay3=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);         
             aChart.setSeriesColorStyle(Color.rgb(53, 68, 41));
             
        //   aChart.setSeriesColors(new int[]{Color.RED,Color.YELLOW,Color.BLUE});
             
             aChart.setTitle("Service sell statistics : Jan 2012 - Jun 2012");
             aChart.setXAxisTitle("Months");
             aChart.setYAxisTitle("sell (in US M$)");

             
        //   uncomment below properties to customize Area chart
             
        /*   aChart.setAxisTitleTextsize(25);
             aChart.setAxisTitleColor(Color.GREEN);
             aChart.setAreaAlpha(200);
            
             aChart.setAxisLabelTextsize(15);
             aChart.setAxisLabelColor(Color.GRAY);
             aChart.setAxisColor(Color.GREEN);
             
             
             aChart.setTitleTextSize(21);           
             aChart.setTitleColor(Color.GREEN);           
             aChart.showLegendArea(false);  */                   
           
          	 main.addView(aChart,chartLay3);
        }
    	
    	
     
    }
  
}
