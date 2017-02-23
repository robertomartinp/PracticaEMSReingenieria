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

public class Circulo {
	// state;
public int centroX;	public int centroY;	public int radio;
public Color colorBorde; public Color colorRelleno;	
public Color resultado;
public String cadena;
	 
	// Constructor
public Circulo() {	this.centroX = 0; this.centroY = 0; this.radio = 0;	this.colorBorde = null;	this.colorRelleno = null;}
public Circulo(int x, int y, int r) {this.centroX = x;this.centroY = y;this.radio = r;this.colorBorde = null;this.colorRelleno = null;}
public Circulo(int x, int y, int r, Color borde, Color relleno){this.centroX = x;this.centroY = y;this.radio = r;this.colorBorde = borde;this.colorRelleno = relleno;}
	
	// métodos Set
public void setCentro (int x, int y) {this.centroX = x;	this.centroY = y;}
public void setRadio (int r) {this.radio = r;}
public void setBorde (Color color) {this.colorBorde = color;}	
public void setRelleno (Color color) {this.colorRelleno = color;}		

	// métodos Get
public int[] getCentro () {
int[] centro = new int[2];
centro[0]= this.centroX;
centro[1]= this.centroY;
return centro;
}
public int getRadio () {return this.radio;}	
public Color getBorde () {return this.colorBorde;}		
public Color getRelleno () {return this.colorRelleno;}		
	
	// métodos adicionales
public  boolean tieneRelleno (){return (this.colorRelleno!=null);}	
public boolean tieneBorde(){return (this.colorBorde!=null);}
public void desactivarBorde(){this.colorBorde = null;}	
public void desactivarRelleno(){this.colorRelleno = null;}
public void mover(int dx, int dy){setCentro(this.centroX + dx, this.centroY + dy);}
public double area () {return Math.PI * this.radio * this.radio;}
public int diametro () {return this.radio + this.radio;	}
public double perimetro (){	return  Math.PI * 2 * this.radio;}
public double distancia (Circulo c){
int[] centro = c.getCentro();
return Math.sqrt(((this.centroX-centro[0]) * (this.centroX-centro[0])) + ((this.centroY-centro[1]) * (this.centroY-centro[1])) );}
public double distancia (Rectangulo r){
int[] centro = r.getCentro();
return Math.sqrt(((this.centroX-centro[0]) * (this.centroX-centro[0])) + ((this.centroY-centro[1]) * (this.centroY-centro[1])) );}
public Color mezclaColor (Circulo c){
Color resultado = null;int rojo, verde, azul;
if (this.tieneRelleno() & c.tieneRelleno()){	
rojo = ((this.colorRelleno.getRed() +  c.getRelleno().getRed()) < 255) ? (this.colorRelleno.getRed() +  c.getRelleno().getRed()) : 255; 
verde = ((this.colorRelleno.getGreen() +  c.getRelleno().getGreen()) < 255) ? (this.colorRelleno.getGreen() +  c.getRelleno().getGreen()) : 255; 
azul = ((this.colorRelleno.getBlue() +  c.getRelleno().getBlue()) < 255) ? (this.colorRelleno.getBlue() +  c.getRelleno().getBlue()) : 255; 
resultado = new Color(rojo, verde, azul);}
return resultado;}
	
public Color mezclaColor (Rectangulo r){
Color resultado = null;int rojo, verde, azul;
if (this.tieneRelleno() & r.tieneRelleno()){	
rojo = ((this.colorRelleno.getRed() +  r.getRelleno().getRed()) < 255) ? (this.colorRelleno.getRed() +  r.getRelleno().getRed()) : 255; 
verde = ((this.colorRelleno.getGreen() +  r.getRelleno().getGreen()) < 255) ? (this.colorRelleno.getGreen() +  r.getRelleno().getGreen()) : 255; 
azul = ((this.colorRelleno.getBlue() +  r.getRelleno().getBlue()) < 255) ? (this.colorRelleno.getBlue() +  r.getRelleno().getBlue()) : 255; 
resultado = new Color(rojo, verde, azul);}
return resultado;}
	
public String toString(){
String cadena = "CIRCULO: Centro = [" + this.centroX + ", " + this.centroY + "]; Radio = " + this.radio;
if (this.tieneRelleno()){cadena = cadena + "; Color relleno [= " + this.colorRelleno.getRed() + ", " + this.colorRelleno.getGreen() + ", " + this.colorRelleno.getBlue() + "]";}
else{cadena = cadena + "; Sin relleno";}
if (this.tieneBorde()){cadena = cadena + "; Color borde [= " + this.colorBorde.getRed() + ", " + this.colorBorde.getGreen() + ", " + this.colorBorde.getBlue() + "]";}
else{cadena = cadena + "; Sin borde";}
return cadena;}	
}
