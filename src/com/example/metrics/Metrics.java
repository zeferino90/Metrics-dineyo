package com.example.metrics;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adapters.JsonAdapter;
import com.example.extraclasses.Datos;


public class Metrics extends ListActivity {

	private JsonAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://dineyo.com").build();
		JsonMetrics metrics = restAdapter.create(JsonMetrics.class);
		//List<Datos> metricas = metrics.listMetrics();
		List<Datos> metricas = new ArrayList<Datos>();
		adapter = new JsonAdapter(this, R.layout.item_metric, metricas);
		setListAdapter(adapter);
	}
	
	private interface JsonMetrics{
		@GET("/api/metrics")
		List<Datos> listMetrics();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.metrics, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
