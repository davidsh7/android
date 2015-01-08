package com.example.teleperformance;

public class Node {
	
	private String titulo;
	private String subtitulo;
	private int imagen;

	public Node() {

	}

	public Node(String tit, String sub, int img) {
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
