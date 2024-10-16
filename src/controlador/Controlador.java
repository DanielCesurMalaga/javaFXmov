package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Controlador implements Initializable {
    // atributos
    @FXML
    VBox escenarioPrincipal;
    @FXML
    Pane escenarioArriba;
    @FXML
    Pane escenarioAbajo;
    @FXML
    Label etiqueta1;
    @FXML
    Label etiqueta2;
    @FXML
    Label etiqueta3;
    @FXML
    Label etiqueta4;
    @FXML
    Label etiqueta5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escenarioPrincipal.setStyle("-fx-background-color:darkgreen");
        escenarioArriba.setStyle("-fx-background-color:grey");
        escenarioAbajo.setStyle("-fx-background-color:white");
    }

    public void etiquetaSeleccionada(MouseEvent evento) {
        Label etiqueta = (Label) evento.getSource();
        if (etiqueta1.getTextFill() == Color.RED) {
            etiqueta1.setTextFill(Color.BLACK);
        }
        if (etiqueta2.getTextFill() == Color.RED) {
            etiqueta2.setTextFill(Color.BLACK);
        }
        if (etiqueta3.getTextFill() == Color.RED) {
            etiqueta3.setTextFill(Color.BLACK);
        }
        if (etiqueta4.getTextFill() == Color.RED) {
            etiqueta4.setTextFill(Color.BLACK);
        }
        if (etiqueta5.getTextFill() == Color.RED) {
            etiqueta5.setTextFill(Color.BLACK);
        }
        etiqueta.setTextFill(Color.RED);
    }

    public void posicionRaton(MouseEvent evento) {

        if (etiqueta1.getTextFill() == Color.RED) {
            etiqueta1.setText("Bola1 (" +
                    (int) evento.getX() + "," + (int) evento.getY() + ")");
        } else if (etiqueta2.getTextFill() == Color.RED) {
            etiqueta2.setText("Bola2 (" +
                    (int) evento.getX() + "," + (int) evento.getY() + ")");
        } else if (etiqueta3.getTextFill() == Color.RED) {
            etiqueta3.setText("Bola3 (" +
                    (int) evento.getX() + "," + (int) evento.getY() + ")");
        } else if (etiqueta4.getTextFill() == Color.RED) {
            etiqueta4.setText("Bola4 (" +
                    (int) evento.getX() + "," + (int) evento.getY() + ")");
        } else if (etiqueta5.getTextFill() == Color.RED) {
            etiqueta5.setText("Bola5 (" +
                    (int) evento.getX() + "," + (int) evento.getY() + ")");
        }

    }
}
