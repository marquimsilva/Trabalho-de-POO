package controll;

import dao.ProdDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Produtos;
import view.Palco;

public class FXMLMostraProdutosController implements Initializable {
    
    @FXML private TableColumn<Produtos, Integer> MostraCodigo;

    @FXML private TableColumn<Produtos, String> MostraProd;
    @FXML private TableView<Produtos> tabela;
    @FXML private TableColumn<Produtos, Double> MostraValor;
    
    ProdDAO dao = new ProdDAO();
    
   @Override
      public void initialize(URL url, ResourceBundle rb) {
        try {
            mostrarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMostraProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
        
    @FXML void btVoltar() throws IOException {
                Palco.trocaTela(3);
    }
    
    @FXML void btVender() {

    }

    @FXML void btDeletar() throws SQLException {
        Produtos prod = new Produtos();
        prod = tabela.getSelectionModel().getSelectedItem();        
        if(prod != null){
            
            ProdDAO dao= new ProdDAO();
                    if(dao.deletar(prod.getCod())){
                    JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
                mostrarTabela();
            }else{
                System.out.println("Erro ao excluir");
            }                             
        }else{
                JOptionPane.showMessageDialog(null, "O produto não foi deletado");
        }        
    }
    
    
    
    

    
    public ObservableList<Produtos> listaProdutos() throws SQLException{
        List<Produtos> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    
    
    @FXML void btAtualizar() throws SQLException, IOException {
                Produtos prod = tabela.getSelectionModel().getSelectedItem();
        if(prod != null){
            boolean buttonConfirmaClick = showTela(prod);
            if(buttonConfirmaClick){                
                dao.atualizar(prod);
                mostrarTabela();
            }            
        }else{

            JOptionPane.showMessageDialog(null,"Você deve selecionar um aluno para alterar");
            
        }           
    }
    public void mostrarTabela() throws SQLException{
        MostraCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        MostraProd.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        MostraValor.setCellValueFactory(new PropertyValueFactory<>("preco"));         
        tabela.setItems(listaProdutos());
        }

  
       private boolean showTela(Produtos aluno)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAtualizarProdutoController.class.getResource("/view/FXMLAtualizarProduto.fxml"));
        AnchorPane pagina = (AnchorPane) loader.load();        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualizar Produto");
        Scene scener = new Scene(pagina);
        dialogStage.setScene(scener);
        
        FXMLAtualizarProdutoController alterarController = loader.getController();
        alterarController.setStage(dialogStage);
        alterarController.setAluno(aluno);
        dialogStage.showAndWait();
        return alterarController.isBtnSalvar();
    }
    }


    