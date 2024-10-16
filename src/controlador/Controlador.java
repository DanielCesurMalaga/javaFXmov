package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

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
    ArrayList<Movimiento> pelotas;
    @FXML
    Pane principal;

    @FXML
    Button boton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contador = 0;
        pelotas = new ArrayList<Movimiento>();
    }

    public void nuevaPelota(MouseEvent e) {
        Circle circle = new Circle(e.getX(), e.getY(), 10, Color.RED);

        circle.setId("circulo"+contador);
        contador++;
        
        principal.getChildren().add(circle);
        
        Movimiento movimiento = new Movimiento(circle, principal, 15);
        movimiento.start();
        

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
