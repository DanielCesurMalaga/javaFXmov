package modelo;

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
        double sentidoX = +1;
        double posX = circulo.getCenterX();
        double finY = pane.getPrefHeight();
        double ppioY = 0;
        double sentidoY = +1;
        double posY = circulo.getCenterY();
        double radio = circulo.getRadius();

        while (true) {
            posX = posX + sentidoX;

            if ((posX + radio >= finX) || (posX - radio <= ppioX)) {
                sentidoX = sentidoX * (-1);
                posX = posX + sentidoX;
                circulo.setRadius(radio+1);
                radio++;
            }
            circulo.setCenterX(posX);

            posY = posY + sentidoY;
            if ((posY + radio >= finY) || (posY - radio <= ppioY)) {
                sentidoY = sentidoY * (-1);
                posY = posY + sentidoY;
                circulo.setRadius(radio+1);
                radio++;
            }
            circulo.setCenterY(posY);

            Thread.sleep(velocidad);

        }
    }

    public void aumentar() throws InterruptedException{
        double finX = pane.getPrefWidth();
        double finY = pane.getPrefHeight();

        double posX = circulo.getCenterX();       
        double posY = circulo.getCenterY();

        double radio = circulo.getRadius();
        boolean dentro = true;

        while (dentro){
            circulo.setRadius(radio+1);
            radio++;
            Thread.sleep(velocidad);
            if ((posX+radio>=finX)||(posX-radio<=0)) dentro = false;
            if ((posY+radio>=finY)||(posY-radio<=0)) dentro = false;
        }

    }

    public void run() {
        try {
            aumentar();
        } catch (InterruptedException e) {

        }

    }

}
