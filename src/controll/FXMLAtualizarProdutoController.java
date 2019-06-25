package controll;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Produtos;
import static view.Palco.stage;

/**
 * FXML Controller class
 *
 * @author Marcos_Vinicius
 */
public class FXMLAtualizarProdutoController implements Initializable {

   @FXML private TextField cod;

   @FXML private TextField value;

   @FXML private TextField desc;
   private Stage stage;
   private boolean btnAtualizar = false;
   Produtos prod = new Produtos();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
        public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnAtualizar;
    }
     public void setBtnSalvar(boolean btnSalvar) {
        this.btnAtualizar = btnSalvar;
    }
         @FXML
    void handleSalvar() {        
        prod.setCod(Integer.parseInt(cod.getText()));
        prod.setProduto(desc.getText());
        prod.setValor(Double.parseDouble(value.getText()));
       
        btnAtualizar = true;
        stage.close();
        
    }
     
     
         @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setAluno(Produtos prod){
        this.prod = prod;
        cod.setText(String.valueOf(prod.getCod()));
        value.setText(String.valueOf(prod.getValor()));
        desc.setText(String.valueOf(prod.getProduto()));
    }
}
