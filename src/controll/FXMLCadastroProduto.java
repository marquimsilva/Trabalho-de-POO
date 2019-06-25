package controll;

import dao.ProdDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Produtos;
import view.Palco;


public class FXMLCadastroProduto implements Initializable {
    Produtos prod = new Produtos();
      ProdDAO dao = new ProdDAO();
      
    @FXML private TextField TxtProduto;

    @FXML private TextField txtValor;

    @FXML private TextField TxtCod;
    
    @FXML void btVoltar() throws IOException {
        Palco.trocaTela(3);
        limpar();

    }

    @FXML
    void salvar() {
        
       prod.setProduto(TxtProduto.getText());
       prod.setCod(Integer.parseInt(TxtCod.getText()));
       prod.setValor(Double.parseDouble(txtValor.getText()));
        dao.salvar(prod);
        limpar();
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        
        //JOptionPane.showMessageDialog(null, "Olá , Seja Bem Vindo");
        
    }    
    
    

    
        public void limpar(){
        TxtProduto.setText("");
        txtValor.setText("");
        TxtCod.setText("");
    
    
    }
    
}
