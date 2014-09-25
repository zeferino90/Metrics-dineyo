package com.example.extraclasses;

import java.util.ArrayList;
import java.util.List;

public class ListaDatos {
	private List<Datos> datos;

	public ListaDatos(){
		datos = new ArrayList<Datos>();
	}
	
	public List<Datos> getDatos() {
		return datos;
	}

	public void setDatos(List<Datos> datos) {
		this.datos = datos;
	}
}
