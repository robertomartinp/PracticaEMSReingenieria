/**
 * Asignatura Evolución y Mantenimiento Software.
 * ETS. Ing. Sistemas Informáticos - Universidad Politécnica de Madrid.
 * Sesión práctica.
 * 
 * Clase GeometriaGrafica.
 * (c) Jessica Díaz & Carolina Gallardo
 * (c) Jennifer Pérez Benedí, Soledad Delgado Sanz, Jessica Díaz Fernández.
*/

import java.awt.*;

public class GeometriaGrafica extends Frame{

	public Circulo c1, c2;
	public Rectangulo r1, r2;

  public GeometriaGrafica(){
    Panel panelTapiz = new Panel(null);
	Panel panelDatos = new Panel(new GridLayout(0,1));
		
	c1 = new Circulo(100,100,100, Color.MAGENTA, new Color(255,128,0));
	c2 = new Circulo(200,200,70, Color.BLACK, new Color(170, 57, 153));
	r1 = new Rectangulo(250,50,200,40, Color.RED, new Color(228,218, 0));
	r2 = new Rectangulo(300,130,30,220, Color.RED, new Color(0, 156, 156));
	
    //tapiz en el que se dibujan las cuatro figuras
	CanvasTapiz tapiz = new CanvasTapiz();
	tapiz.setSize(370,300);
	panelTapiz.add(tapiz);
	panelTapiz.setLocation(10,40);
	panelTapiz.setSize(400,300);

    //panel en el que aparecen los datos de las figuras
    panelDatos.setLocation(410,40);
	panelDatos.setSize(600,300);
	panelDatos.setBackground(new Color(231, 200, 200));		
	panelDatos.add(new Label("  DATOS DE LAS FIGURAS CONSEGUIDOS CON toString:"));
	panelDatos.add(new Label("             C1: " + c1.toString()));
	panelDatos.add(new Label("             C2: " + c2.toString()));
	panelDatos.add(new Label("             R1: " + r1.toString()));
	panelDatos.add(new Label("             R2: " + r2.toString()));
	panelDatos.add(new Label("  DISTANCIAS ENTRE CENTROS"));
	panelDatos.add(new Label("              C1 a C2:   " + c1.distancia(c2)));
	panelDatos.add(new Label("              C1 a R1:   " + c1.distancia(r1)));
	panelDatos.add(new Label("              C1 a R2:   " + c1.distancia(r2)));
	panelDatos.add(new Label("              C2 a R1:   " + c2.distancia(r1)));		
	panelDatos.add(new Label("              C2 a R2:   " + c2.distancia(r2)));
	panelDatos.add(new Label("              R1 a R2:   " + r1.distancia(r2)));		
	panelDatos.add(new Label("  CALCULOS SOBRE LAS FIGURAS"));
	panelDatos.add(new Label("              C1. Area: " + c1.area() + ". Perímetro: " + c1.perimetro() + ". Diámetro: "+ c1.diametro()));
	panelDatos.add(new Label("              C2. Area: " + c2.area() + ". Perímetro: " + c2.perimetro() + ". Diámetro: "+ c2.diametro()));
	panelDatos.add(new Label("              R1. Area: " + r1.area() + ". Perímetro: " + r1.perimetro() ));
	panelDatos.add(new Label("              R2. Area: " + r2.area() + ". Perímetro: " + r2.perimetro() ));	

    this.setLayout(new FlowLayout());
	this.add(panelTapiz);
	this.add(panelDatos);
	
	this.setSize(1130,430);
	this.setResizable(false);
	this.setVisible(true);
  }

  public static void main(String[] args){
    new GeometriaGrafica();
  }

  // clase interna que se encarga de pintar el tapiz en el que se visualizan las figuras
  class CanvasTapiz extends Canvas{

    public void paint(Graphics g){
	  g.setColor(c1.getBorde());
	  g.drawOval(c1.getCentro()[0]-c1.getRadio(), c1.getCentro()[1]-c1.getRadio(), c1.getRadio()*2, c1.getRadio()*2);
	  g.setColor(c1.getRelleno());
	  g.fillOval(c1.getCentro()[0]-c1.getRadio()+1, c1.getCentro()[1]-c1.getRadio()+1, (c1.getRadio()*2)-2, (c1.getRadio()*2)-2);
	  
	  g.setColor(c2.getBorde());
	  g.drawOval(c2.getCentro()[0]-c2.getRadio(), c2.getCentro()[1]-c2.getRadio(), c2.getRadio()*2, c2.getRadio()*2);
	  g.setColor(c2.getRelleno());
	  g.fillOval(c2.getCentro()[0]-c2.getRadio()+1, c2.getCentro()[1]-c2.getRadio()+1, (c2.getRadio()*2)-2, (c2.getRadio()*2)-2);
	  	    
	  g.setColor(r1.getBorde());
	  g.drawRect(r1.getCentro()[0]-(r1.getBase()/2), r1.getCentro()[1]-(r1.getAltura()/2), r1.getBase(), r1.getAltura());
	  g.setColor(r1.getRelleno());
	  g.fillRect(r1.getCentro()[0]-(r1.getBase()/2)+1, r1.getCentro()[1]-(r1.getAltura()/2)+1, r1.getBase()-2, r1.getAltura()-2);
	  
	  g.setColor(r2.getBorde());
	  g.drawRect(r2.getCentro()[0]-(r2.getBase()/2), r2.getCentro()[1]-(r2.getAltura()/2), r2.getBase(), r2.getAltura());
	  g.setColor(r2.getRelleno());
	  g.fillRect(r2.getCentro()[0]-(r2.getBase()/2)+1, r2.getCentro()[1]-(r2.getAltura()/2)+1, r2.getBase()-2, r2.getAltura()-2);

	  g.setColor(c1.mezclaColor(c2));
	  g.fillOval(150, 160, 15, 15);		  

	  g.setColor(c1.mezclaColor(r1));
	  g.fillOval(155, 40, 15, 15);		  
	
	  g.setColor(r1.mezclaColor(r2));
	  g.fillRect(290, 40, 15, 15);		  
	  }
  }	

}

