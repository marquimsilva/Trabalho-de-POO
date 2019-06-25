package dao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.Produtos;


public class ProdDAO {
    Connection con = null;
    public ProdDAO(){
         con = Conexao.abrirConexao();
    }
    public void salvar(Produtos prod){
        try {
            String sql = "INSERT INTO produto(codigo, descricao, preco)VALUES(?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, prod.getCod());
            pstm.setString(2, prod.getProduto());
            pstm.setDouble(3, prod.getValor());
            
            if(pstm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Produto Cadastrado Com Sucesso");
                
            }else{
                 JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e.getMessage());
        }
    
    
    }
    
    
    
    
    
    
    
    public void atualizar(Produtos prod){
        try {
            String sql = "UPDATE PRODUTO SET DESCRICAO= ?, VALOR = ? WHERE CODIGO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, prod.getProduto());
            ps.setDouble(2, prod.getValor());
            ps.setInt(3, prod.getCod());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
 public List pesquisarAll() throws SQLException{
 List<Produtos> lista = new ArrayList<Produtos>();
       try{
               
            String sql = "SELECT * FROM PRODUTO";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
               
               
               Produtos prod = new Produtos();
                prod.setCod(rs.getInt("codigo"));
                prod.setProduto(rs.getString("descricao"));
                prod.setValor(rs.getInt("preco"));
                lista.add(prod);              
                
            }            
       } catch (Exception e){
            System.out.println("Deu Erro");
       }   
       return lista;
 }
 
 
 
    public boolean deletar(int cod){
        try {
            String sql = "DELETE FROM PRODUTO WHERE CODIGO = '"+cod+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

       
           
    

