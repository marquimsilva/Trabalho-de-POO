package controll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Palco;


public class FXMLLoginUseController implements Initializable {

    Usuario use = new Usuario();

    
    @FXML  private TextField txtPass;
        @FXML  private TextField txtUser;


    @FXML  void Entrar() throws IOException{

    
        
            use.setUser(txtUser.getText());
            use.setPass(txtPass.getText());
            
            if(use.getUser().equals("wilton") && use.getPass().equals("12345")){
                
                JOptionPane.showMessageDialog(null, "Logado com sucesso !!"); 
                
                //Palco.trocaTela(3);
                limpar();
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos");
                }
            
            
            
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //todo 
    }    
    public void limpar(){
        txtUser.setText("");
        txtPass.setText("");
    
    
    }
}
