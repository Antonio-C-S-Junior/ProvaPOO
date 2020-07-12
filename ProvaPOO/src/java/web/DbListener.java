
package web;

import db.Disciplina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbListener implements ServletContextListener {
    public static final String URL = "jdbc:sqlite:C:\\BD Prova\\dbProva.db";
    
    public static String exceptionMessage = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String step = "Starting database";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            step = "'disciplina' table creation";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplina("
                    + "sgCurso VARCHAR(6) UNIQUE NOT NULL, "
                    + "nmCurso VARCHAR(50) NOT NULL, "
                    + "ddSemana VARCHAR(30) NOT NULL, "
                    + "qtAulas NUMERIC(3) NOT NULL, "
                    + "hrAulas VARCHAR(50) NOT NULL, "
                    + "vlNotaCurso NUMERIC(4,2) NOT NULL "
                    + ")");
            if(Disciplina.getList().isEmpty()){
                step = "default disciplina creations";
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'ILP007', 'Linguagem de Programação Orientada a Objetos', "+"'Segunda-feira', "+"80, "+"'19:00 - 22:30', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'IES300', 'Engenharia de Software III', "+"'Terça-Feira', "+"80, "+"'19:00 - 22:30', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'ISO200', 'Sistemas Operacionais', "+"'Quarta-Feita', "+"80, "+"'19:00 - 22:30', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'ILP512', 'Linguagem de Programação  - Internet', "+"'Quinta-Feira', "+"80, "+"'19:00 - 22:30', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'ISG003', 'Segurança da Informação', "+"'Sexta-Feira', "+"40, "+"'19:00 - 20:40', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'TTG001', 'Metodologia de Pesquisa Ciêntifica-Tecnológica', "+"'Sexta-Feira', "+"40, "+"'19:00 - 20:40', "+"0"+")");
                stmt.executeUpdate("INSERT INTO disciplina VALUES("
                        + "'IDB002', 'Banco de Dados', "+"'Sábado', "+"80, "+"'8:00 - 11:30', "+"0"+")");
            }
            stmt.close();
            con.close();
        }catch(Exception ex){
            exceptionMessage = step + ": " + ex.getMessage();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
