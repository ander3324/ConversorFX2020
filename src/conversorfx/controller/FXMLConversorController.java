/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorfx.controller;

import conversorfx.ConversorFX;
import conversorfx.model.Temperatura;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author ander
 */
public class FXMLConversorController implements Initializable {

    @FXML
    private Button btnConvertir;
    @FXML
    private TextField txfCelsius;
    @FXML
    private TextField txfFahrenheit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void borrarOtro_OnKeyTyped(KeyEvent event) {
        
        //Verificar que sólo uno de los textfields tengan valor:
        if(txfFahrenheit.isFocused() && !txfCelsius.getText().isEmpty())
            txfCelsius.clear();
        else if(txfCelsius.isFocused() && !txfFahrenheit.getText().isEmpty())
            txfFahrenheit.clear();
    }

    @FXML
    private void convertir_OnAction(ActionEvent event) {
        
        //Variables locales
        float grado = 0.0F, conversion = 0.0F;
        
        //Instancia de la clase Temperatura:
        Temperatura t = new Temperatura();
        
        //Verficar que no estés vacios los cuadros
        if(txfCelsius.getText().isEmpty() && txfFahrenheit.getText().isEmpty())
            mostrarError("Tiene que ingresar una temperatura.");
        else if(!txfCelsius.getText().isEmpty()) {
            grado = Float.parseFloat(txfCelsius.getText());
            conversion = t.convertirCelsiusToFahrenheit(grado);
            
            //Mostrar la conversión
            txfFahrenheit.setText(String.format("%.2f",conversion));
            
        } else if(!txfFahrenheit.getText().isEmpty()) {
            grado = Float.parseFloat(txfFahrenheit.getText());
            conversion = t.convertirFahrenheitToCelsius(grado);
            
            txfCelsius.setText(String.format("%.2f",conversion));
        }
    }
    
    void mostrarError(String mensaje) {
        Alert msj = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        
        //Añadir el icono:
        Stage st = (Stage)msj.getDialogPane().getScene().getWindow();
        Image ico = new Image(ConversorFX.class.getResourceAsStream("resources/temp.jpg"));
        st.getIcons().add(ico);
        
        msj.showAndWait();
    }
    
}
