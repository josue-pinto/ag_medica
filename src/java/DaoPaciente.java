import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DAO OU MODEL DO MVC
 * @author Josue Jr- Jair Silva e Vitor
 */
public class DaoPaciente {
    private Connection con;

    public void conexaoBanco(){
        try{
             //Statement stmt = con.createStatement();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/ag_medica","root","mysql");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro "+e);
        }
    }
    public void inserirBanco(Paciente contato){
        conexaoBanco();
        try{
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO pacientes values(NULL,'"+contato.getNm_Pac()+"','"+contato.getTel_Pac()+"','"+contato.getEmail_Pac()+"');");
            stmt.close();
        }catch(SQLException e){
            System.out.println("Erro "+e);
        } 
    }
    public void excluirBanco(int codigo){
        conexaoBanco();
        try{
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM pacientes WHERE id_pac = "+codigo);
            stmt.close();
        }catch(SQLException e){
            System.out.println("Erro "+e);
        }
    }
    //public List<Dados> listar(){
    public List consultarBanco(){
        conexaoBanco();
        List<Paciente> lista = new ArrayList<Paciente>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes");
            while(rs.next()){
                Paciente d = new Paciente();
                d.setNm_Pac(rs.getString("nm_pac"));                
                d.setTel_Pac(rs.getString("tel_pac"));
                d.setEmail_Pac(rs.getString("email_pac"));
                lista.add(d);
		}
            stmt.close();
        }catch(SQLException e){
            System.out.println("Erro "+e);
        }
        return lista;
    }
    public List alterarBanco(int codigo){
        conexaoBanco();
        List<Paciente> lista = new ArrayList<Paciente>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes WHERE id_pac = "+codigo);
            while(rs.next()){
                Paciente d = new Paciente();
                d.setNm_Pac(rs.getString("nm_pac"));                
                d.setTel_Pac(rs.getString("tel_pac"));
                d.setEmail_Pac(rs.getString("email_pac"));
                lista.add(d);
		}
            stmt.close();
        }catch(SQLException e){
            System.out.println("Erro "+e);
        }
        return lista;
    }
    public void gravarAltBanco(Paciente contato, int codigo){
        conexaoBanco();
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE pacientes SET nm_pac='"+contato.getNm_Pac()+"',tel_pac='"+contato.getTel_Pac()+"',email_pac='"+contato.getEmail_Pac()+"' WHERE id_pac="+codigo);
            }catch(SQLException e){
            System.out.println("Erro "+e);
        }
    }
}
