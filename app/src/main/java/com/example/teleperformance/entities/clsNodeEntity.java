package com.example.teleperformance.entities;

public class clsNodeEntity {
	
	private String titulo;
	private String subtitulo;
	private int imagen;

	public clsNodeEntity() {

	}

	public clsNodeEntity(String tit, String sub, int img) {
		titulo = tit;
		subtitulo = sub;
		imagen = img;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String value) {
		titulo = value;
	}
	
	public String getSubtitulo() {
		return subtitulo;
	}
	
	public void setSubtitulo(String value) {
		subtitulo = value;
	}

	public int getImagen() {
		return imagen;
	}
	
	public void setImagen(int value) {
		imagen = value;
	}
	
}
