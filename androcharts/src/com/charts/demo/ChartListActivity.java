package com.charts.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


//Activity which shows list of charts, for reference on how to use, refer AndroChartDemo.java, 
public class ChartListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_list); 
        
        String[] s=new String[]{"Column Chart - Default","Column Chart- Stacked","Pie Chart","Line Chart","Area Chart"};	
        ArrayAdapter<String> charts=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, s);
        setListAdapter(charts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_chart_list, menu);
        return true;
    }
    
  
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);		
		
			 Intent myintent=new Intent();
			 myintent.setClass(this, AndroChartDemo.class);
			 myintent.putExtra("Chart_Type", position+1);
			 startActivity(myintent);
		 
	}

	

    
}
