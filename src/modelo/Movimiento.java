package modelo;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Movimiento extends Thread {
    private Circle circulo;
    private long velocidad;
    private Pane pane;

    public Movimiento(Circle circulo, Pane pane, long velocidad) {
        this.circulo = circulo;
        this.velocidad = velocidad;
        this.pane = pane;
    }

    public void mover() throws InterruptedException {

        double finX = pane.getPrefWidth();
        double ppioX = 0;
        double sentidoX = obtenerSentido(-2);
        double posX = circulo.getCenterX();

        double finY = pane.getPrefHeight();
        double ppioY = 0;
        double sentidoY = obtenerSentido((int) sentidoX);
        double posY = circulo.getCenterY();

        double radio = circulo.getRadius();

        while (true) {
            posX = posX + sentidoX;

            if ((posX + radio >= finX) || (posX - radio <= ppioX)) {
                sentidoX = sentidoX * (-1);
                posX = posX + sentidoX;
            }

            posY = posY + sentidoY;
            if ((posY + radio >= finY) || (posY - radio <= ppioY)) {
                sentidoY = sentidoY * (-1);
                posY = posY + sentidoY;
            }

            circulo.setCenterX(posX);
            circulo.setCenterY(posY);

            Thread.sleep(velocidad);

        }
    }

    public void aumentar() throws InterruptedException {
        double finX = pane.getPrefWidth();
        double finY = pane.getPrefHeight();

        double posX = circulo.getCenterX();
        double posY = circulo.getCenterY();

        double radio = circulo.getRadius();
        boolean dentro = true;

        while (dentro) {
            circulo.setRadius(radio + 1);
            radio++;
            Thread.sleep(velocidad);
            if ((posX + radio >= finX) || (posX - radio <= 0))
                dentro = false;
            if ((posY + radio >= finY) || (posY - radio <= 0))
                dentro = false;
        }

    }

    private static int obtenerSentido(int anterior) {
        Random aleatorio = new Random();
        int valor;
        if (anterior != 0) {
            valor = aleatorio.nextInt(0, 2);
            if (aleatorio.nextBoolean()) {
                valor = valor * (-1);
            } 
            return valor;
        } else {
            valor = aleatorio.nextInt(0, 1);
            if (valor == 0) return (-1);
            return valor;
        }

    }

    public void run() {
        try {
            mover();
        } catch (InterruptedException e) {

        }

    }

}
