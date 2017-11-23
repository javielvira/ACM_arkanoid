package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

/*
 * Autor: Javi Elvira
 * 
 * El Arkanoid pero orientado a objetos
 */

import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(10, Color.YELLOW);
	Barra barra1 = new Barra(390, 5, Color.RED);
	int anchoLadrillo = 25;
	int altoLadrillo = 15;
	int numeroLadrillos=14;
	int espacioMenu = 200;

	int puntuacion = 0;
	Marcador marcador = new Marcador(40, 25);

	public void init(){
		addMouseListeners();
		setSize(600, 600);
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(),0);
		add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		add(barra1, 0, getHeight()*0.80);
		dibujaNivel01();

	}

	public void run(){
		
		marcador.dibuja(this);

		while (true){
			pelota1.muevete(this);
			pause(1);
		}
	}

	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth());
	}

	private void dibujaNivel01(){
		for (int j=0; j < numeroLadrillos; j++){
			for (int i=j; i < numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo* i - anchoLadrillo* j/2 + (getWidth()-espacioMenu)/2 - numeroLadrillos*anchoLadrillo/2,
						altoLadrillo*j + altoLadrillo,
						anchoLadrillo, altoLadrillo, Color.green);
				add(miLadrillo);
				pause(7);
			}
		}
	}

}
