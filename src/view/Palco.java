package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Palco extends Application {
    public static Stage stage;
    public static Scene iniciar, cadastro , login , vsCl , TlAdm , mosTod; 
    @Override
    public void start(Stage Pstage) throws IOException{
        stage = Pstage;
    
        Parent fxmlInicio = FXMLLoader.load(getClass().getResource("FXMLIniciar.fxml"));
        iniciar= new Scene(fxmlInicio,600,600);
       stage.setTitle("Bem Vindo");
        stage.setScene(iniciar);
        stage.setResizable(false);
        
        
        
        Parent Login = FXMLLoader.load(getClass().getResource("FXMLLoginUse.fxml"));
        Parent Prod = FXMLLoader.load(getClass().getResource("FXMLCadastroProduto.fxml"));
        Parent  rooting = FXMLLoader.load(getClass().getResource("FXMLTelaAdm.fxml"));
        Parent mostProd = FXMLLoader.load(getClass().getResource("FXMLMostraProdutos.fxml"));



                       

        
        mosTod = new Scene(mostProd,600,600);
        login = new Scene(Login,400,400);              
        TlAdm = new Scene(rooting ,400,400);
        cadastro = new Scene(Prod,400, 400); 

       


        
        
    }
    
    public static void trocaTela(int numero){
        

    switch (numero){
            case 1:            
            stage.setTitle("Login de Administrador");
            stage.setScene(login);
            stage.setResizable(false);
            break;  
            case 2:
             stage.setTitle("Todos os Produtos");
             stage.setScene(mosTod);
            stage.setResizable(false);
                break;
            case 3:            
            stage.setTitle("Bem Vindo Administrador");
            stage.setScene(TlAdm);
            stage.setResizable(false);
            break;
                
            case 4 :
            stage.setTitle("Bem Vindo");
            stage.setScene(iniciar);
            stage.setResizable(false);
             break;
                
            case 5 :
            stage.setTitle("Cadastrar Produtos");
            stage.setScene(cadastro);
           stage.setResizable(false);
             break;
                
                
   }
}
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
                       
        
    
}
