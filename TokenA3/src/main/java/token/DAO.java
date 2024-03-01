package main.java.token;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {
    public boolean existe (Usuario usuario)throws Exception{
        String sql = "SELECT * FROM Funcionario WHERE nome =? AND senha =?";
        try(Connection conn = ConexaoDB.obtemConexao()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            
    try(ResultSet rs = ps.executeQuery()){
        return rs.next();
    }
        }
}
    public boolean cadastro(Paciente paciente)throws Exception{
  
        //inserir no atendimento
          String sql = "insert into Paciente(cpf, nome) VALUES (?, ?)";
      try(Connection conn = ConexaoDB.obtemConexao()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            
            ps.execute();
            return true;
        }
        catch(Exception e){
            return false;
        }
                
    }
        // consulta atendimento para gerar a fila
       public boolean gerarFila (String cpf)throws Exception{ 
        String sql = ("select * from paciente where cpf=?");
        try(Connection conn = ConexaoDB.obtemConexao()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);     
    try(ResultSet rs = ps.executeQuery()){
        return rs.next();
}
        }
    }

    int getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private TipoAtendimento TipoAtendimento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}