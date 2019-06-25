package controll;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import view.Palco;
public class FXMLTelaAdmController implements Initializable {

    @FXML void cadProduto() throws IOException {
        Palco.trocaTela(4);

    }


    @FXML void mostraProduto() throws IOException {
       Palco.trocaTela(2);

    }
    
    @FXML void btSair() throws IOException {
        Palco.trocaTela(4);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
