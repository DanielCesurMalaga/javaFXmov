package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.Movimiento;

public class Controlador implements Initializable {

    // atributos
    int contador;
    @FXML
    Pane principal;

    @FXML
    Button boton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contador = 0;
    }

    public void nuevaPelota(MouseEvent e) {
        Circle circle = new Circle(e.getX(), e.getY(), 10, Color.RED);
        circle.setId("circulo"+contador);
        contador++;
        Movimiento movimiento = new Movimiento(circle, principal, 15);
        movimiento.start();
        principal.getChildren().add(circle);
        

    }

    public void aumentaPelota(MouseEvent e){
        Circle circle = new Circle(e.getX(), e.getY(), 10, Color.RED);
        circle.setId("circulo"+contador);
        contador++;
        Movimiento movimiento = new Movimiento(circle, principal, 15);
        movimiento.start();
        principal.getChildren().add(circle);
    }

}
