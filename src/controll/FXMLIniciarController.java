package controll;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author 1 informatica
 */
public class FXMLIniciarController implements Initializable {

   @FXML 
   void btnAdm(){
       Palco.trocaTela(1);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JOptionPane.showMessageDialog(null, "Seja bem vindo");
    }    
    
}
