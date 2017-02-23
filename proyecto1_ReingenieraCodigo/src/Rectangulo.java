/**
 * Asignatura Evolución y Mantenimiento Software.
 * ETS. Ing. Sistemas Informáticos - Universidad Politécnica de Madrid.
 * Sesión práctica.
 * 
 * Clase GeometriaGrafica.
 * (c) Jessica Díaz & Carolina Gallardo
 * (c) Jennifer Pérez Benedí, Soledad Delgado Sanz, Jessica Díaz Fernández.
*/
import java.awt.Color;
import java.lang.Math;

public class Rectangulo {

	// state;
	public int centroX;
	public int centroY;
	public int base;
	public int altura;

	public Color colorBorde;
	public Color colorRelleno;
	
	 
	// Constructor
	public Rectangulo() {		
		this.centroX = 0;
		this.centroY = 0;
		this.setCentro(0,0);
		this.base = 0;
		this.setBase(0);
		this.altura = 0;
		this.setAltura(0);
		this.colorBorde = null;
		this.colorRelleno = null;
		this.setBorde(null);
		this.setRelleno(null);
	}
	
	public Rectangulo(int x, int y, int b, int a) {		
		this.centroX = x;
		this.centroY = y;
		this.base = b;
		this.altura = a;
		this.colorBorde = null;
		this.colorRelleno = null;
		this.setCentro(x,y); this.setBase(b); this.setAltura(a); this.setBorde(null);this.setRelleno(null);
	}
	
	public Rectangulo(int x, int y, int b, int a, Color borde, Color relleno){
this.centroX = x;
		this.centroY = y;
	this.base = b;
this.altura = a;
	this.colorBorde = borde;
this.colorRelleno = relleno;
this.setCentro(x,y); this.setBase(b); this.setAltura(a); this.setBorde(borde);this.setRelleno(relleno);
	}
	
	// métodos Set
	
public void setCentro (int x, int y) {
this.centroX = x;	this.centroY = y;}
public void setBase (int b) {
this.base = b;}
public void setAltura (int a) {
this.altura = a;}
public void setBorde (Color color) {
this.colorBorde = color;}	
public void setRelleno (Color color) {
this.colorRelleno = color;}	
	

	// métodos Get
	public int[] getCentro () {
        int[] centro = new int[2];
		centro[0]= this.centroX;
		centro[1]= this.centroY;
		return centro;
	}

	public int getBase () {
return this.base;}
	
	public int getAltura () {
return this.altura;}
	
	public Color getBorde () {
		return this.colorBorde;
	}	
	
	public Color getRelleno () {
		return this.colorRelleno;
	}		
	
	// métodos adicionales
	public  boolean tieneRelleno (){
		return (this.colorRelleno!=null);
	}
	
	public boolean tieneBorde(){
		return (this.colorBorde!=null);
	}
	
    public void desactivarBorde(){
		this.colorBorde = null;
	}
	
	public void desactivarRelleno(){
		this.colorRelleno = null;
	}
 
	
	public void mover(int dx, int dy){	
		setCentro(this.centroX + dx, this.centroY + dy);
	}

	public double area () {
		return this.base * this.altura;
	}
	

	public double perimetro (){
		return  this.base + this.base + this.altura + this.altura;
	}
	
	public double distancia (Circulo c){
		int[] centro = c.getCentro();
		return Math.sqrt(((this.centroX-centro[0]) * (this.centroX-centro[0])) + ((this.centroY-centro[1]) * (this.centroY-centro[1])) );
	}
	
	public double distancia (Rectangulo r){
		int[] centro = r.getCentro();
		return Math.sqrt(((this.centroX-centro[0]) * (this.centroX-centro[0])) + ((this.centroY-centro[1]) * (this.centroY-centro[1])) );
	}
	
	public Color mezclaColor (Circulo c){
	Color resultado = null;
	int rojo, verde, azul;
	if (this.tieneRelleno() & c.tieneRelleno()){	
	rojo = ((this.colorRelleno.getRed() +  c.getRelleno().getRed()) < 255) ? (this.colorRelleno.getRed() +  c.getRelleno().getRed()) : 255; 
	verde = ((this.colorRelleno.getGreen() +  c.getRelleno().getGreen()) < 255) ? (this.colorRelleno.getGreen() +  c.getRelleno().getGreen()) : 255; 
	azul = ((this.colorRelleno.getBlue() +  c.getRelleno().getBlue()) < 255) ? (this.colorRelleno.getBlue() +  c.getRelleno().getBlue()) : 255; 
	resultado = new Color(rojo, verde, azul);
	}
	return resultado;
	}
	
	public Color mezclaColor (Rectangulo r){
	Color resultado = null;
	int rojo, verde, azul;
	if (this.tieneRelleno() & r.tieneRelleno()){	
	rojo = ((this.colorRelleno.getRed() +  r.getRelleno().getRed()) < 255) ? (this.colorRelleno.getRed() +  r.getRelleno().getRed()) : 255; 
	verde = ((this.colorRelleno.getGreen() +  r.getRelleno().getGreen()) < 255) ? (this.colorRelleno.getGreen() +  r.getRelleno().getGreen()) : 255; 
	azul = ((this.colorRelleno.getBlue() +  r.getRelleno().getBlue()) < 255) ? (this.colorRelleno.getBlue() +  r.getRelleno().getBlue()) : 255; 
	resultado = new Color(rojo, verde, azul);
	}
	return resultado;
	}
	
	public String toString(){
	String cadena = "RECTANGULO: Centro = [" + this.centroX + ", " + this.centroY + "]; Base = " + this.base +"; Altura = " + this.altura;
	if (this.tieneRelleno()){cadena = cadena + "; Color relleno [= " + this.colorRelleno.getRed() + ", " + this.colorRelleno.getGreen() + ", " + this.colorRelleno.getBlue() + "]";}
	else{cadena = cadena + "; Sin relleno";}
	if (this.tieneBorde()){cadena = cadena + "; Color borde [= " + this.colorBorde.getRed() + ", " + this.colorBorde.getGreen() + ", " + this.colorBorde.getBlue() + "]";}
	else{cadena = cadena + "; Sin borde";}
	return cadena;
	}
	
	
}
