package com.example.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.extraclasses.Datos;
import com.example.metrics.R;

public class JsonAdapter extends ArrayAdapter<Datos>  {
	private Context context;
	private List<Datos> datos;
	
	public JsonAdapter(Context context, int id_layout, List<Datos> values) {
		super(context, id_layout, values);
		datos = values;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_metric, parent, false);
        
        Datos item = datos.get(position);
        
        
        if(item != null){
        	TextView clave = (TextView)convertView.findViewById(com.example.metrics.R.id.clave);
        	TextView valor = (TextView)convertView.findViewById(com.example.metrics.R.id.valor);
        	valor.setTextColor(Color.GRAY);
        	clave.setText(item.getKey());
        	valor.setText(item.getValue());
        }
        return convertView;
	}
}
