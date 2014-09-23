package com.example.metrics;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adapters.JsonAdapter;
import com.example.extraclasses.ListaDatos;


public class Metrics extends ListActivity {

	private JsonAdapter adapter;
	private ListaDatos metricas;
	
	private interface JsonMetrics{
		@GET("/api/metrics")
		void listMetrics(Callback<ListaDatos> callback);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://dineyo.com").build();
		JsonMetrics metrics = restAdapter.create(JsonMetrics.class);
		 
		metrics.listMetrics(new Callback<ListaDatos>(){

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Log.e("Retrofit error", arg0.toString());
			}

			@Override
			public void success(ListaDatos arg0, Response arg1) {
				// TODO Auto-generated method stub
				metricas = arg0;
				adapter = new JsonAdapter(getBaseContext(), R.layout.item_metric, metricas.getDatos());
				setListAdapter(adapter);
			}
			
		});
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
