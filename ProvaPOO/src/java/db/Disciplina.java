
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import web.DbListener;

public class Disciplina {
    private String sgCurso;
    private String nmCurso;
    private String ddSemana;
    private int qtAulas;
    private String hrAulas;
    private int vlNotaCurso;
    

    public static ArrayList<Disciplina> getList() throws Exception{
        ArrayList<Disciplina> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(DbListener.URL);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from disciplina");
        while (rs.next()) {
            list.add(new Disciplina(rs.getString("sgCurso"), rs.getString("nmCurso"), rs.getString("ddSemana"),rs.getInt("qtAulas"),rs.getString("hrAulas"), rs.getInt("vlNotaCurso")));
            }
        
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    public static String getSg(int rowid)throws Exception{
        String sigla;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT sgCurso FROM disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        sigla = rs.getString("sgCurso");
        rs.close();
        stmt.close();
        con.close();
        return sigla;
    }
    
    public static String getNm(int rowid)throws Exception{
        String nome;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT nmCurso FROM disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        nome = rs.getString("nmCurso");
        rs.close();
        stmt.close();
        con.close();
        return nome;
    }
    
    public static int getQtAulas(int rowid)throws Exception{
        int qt;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT qtAulas from disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        qt = rs.getInt("qtAulas");
        rs.close();
        stmt.close();
        con.close();
        return qt;
    }
    
    public static String getDdSemana(int rowid)throws Exception{
        String dia;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT ddSemana from disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        dia = rs.getString("ddSemana");
        rs.close();
        stmt.close();
        con.close();
        return dia;
    }
    
    public static String getHrAulas(int rowid)throws Exception{
        String hora;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT hrAulas from disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        hora = rs.getString("hrAulas");
        rs.close();
        stmt.close();
        con.close();
        return hora;
    }
    
    public static int getVlNota(int rowid)throws Exception{
        int nota;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("SELECT vlNotaCurso from disciplina WHERE rowid=?");
        stmt.setInt(1, rowid);
        ResultSet rs = stmt.executeQuery();
        nota = rs.getInt("vlNotaCurso");
        rs.close();
        stmt.close();
        con.close();
        return nota;
    }
    
    public static void UpdateNota(int rowid, double nota)throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(web.DbListener.URL);
        PreparedStatement stmt = con.prepareStatement
        ("UPDATE disciplina SET vlNotaCurso=? WHERE rowid=?");
        stmt.setDouble(1, nota);
        stmt.setInt(2, rowid);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public Disciplina(String sgCurso, String nmCurso, String ddSemana, int qtAulas, String hrAulas, int vlNotaCurso) {
        this.sgCurso = sgCurso;
        this.nmCurso = nmCurso;
        this.ddSemana = ddSemana;
        this.qtAulas = qtAulas;
        this.hrAulas = hrAulas;
        this.vlNotaCurso = vlNotaCurso;
    }

    public String getSgCurso() {
        return sgCurso;
    }

    public void setSgCurso(String sgCurso) {
        this.sgCurso = sgCurso;
    }

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }

    public String getDdSemana() {
        return ddSemana;
    }

    public void setDdSemana(String ddSemana) {
        this.ddSemana = ddSemana;
    }

    public int getQtAulas() {
        return qtAulas;
    }

    public void setQtAulas(int qtAulas) {
        this.qtAulas = qtAulas;
    }

    public String getHrAulas() {
        return hrAulas;
    }

    public void sethrAulas(String hrAulas) {
        this.hrAulas = hrAulas;
    }

    public int getVlNotaCurso() {
        return vlNotaCurso;
    }

    public void setVlNotaCurso(int vlNotaCurso) {
        this.vlNotaCurso = vlNotaCurso;
    }
}
