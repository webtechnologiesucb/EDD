package com.ucb.developer;

import java.util.Random;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Persona {
	int posX;
	int posY;
	int accion;
	int cCar;
	int comprando;
	int color;
	Persona next;

	public Persona() {
		this.posX = 55;
		this.posY = 1;
		this.accion = 1;
		this.comprando = 0;
		this.cCar = 0;
		this.color = new Random().nextInt(15) + 1;
	}

	public Persona move() {
		switch (accion) {
			case 1 -> {
				posY += 10;
				if (posY >= 260) {
					return this;
				}
			}
			case 2 -> {
			}
			case 3 -> {
				if (posX < 130)
					posX += 10;	
				else if ((posY>20)&&(posX<210))
					posY-=10;
				else if (posX<210)
					posX+=10;
				else if ((posY<260)&&(posX<300))
					posY+=10;
				else if (posY<300)
					posX+=10;
				else if (posY>20)
					posY-=10;
				else if (posX<410)
					posX+=10;
				else
					accion=5;//CheckCajas()+5;
			}
		}
		return null;
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(getColorFromCode(color));
		gc.fillOval(posX, posY, 10, 10); // Dibujamos como un círculo básico
	}

	private Color getColorFromCode(int code) {
		switch (code) {
		case 1:
			return Color.RED;
		case 2:
			return Color.GREEN;
		case 3:
			return Color.BLUE;
		// Otros colores...
		default:
			return Color.BLACK;
		}
	}
}