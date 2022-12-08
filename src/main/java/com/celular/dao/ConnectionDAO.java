package com.celular.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.celular.model.Celular;

public class ConnectionDAO {
  Connection con;
	
  ResultSet rs;
  PreparedStatement ps;

  // db postgres

  String url = "jdbc:postgresql://localhost:5432/celular";
  String user = "postgres";
  String password = "postgres";
  
  public void addCelular(Celular c) throws SQLException, ClassNotFoundException {
		try {
      Class.forName("org.postgresql.Driver");
		  con = DriverManager.getConnection(url, user, password);
			String q="INSERT INTO celular (marca,modelo,cor,camera,memoria) VALUES (?,?,?,?,?)";
      ps = con.prepareStatement(q);
      ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getCor());
			ps.setString(4, c.getCamera());
			ps.setInt(5, c.getMemoria());
			ps.execute();

			System.out.println("Dados do celular foram inseridos!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    con.close();
	}

  public Celular getCelular(Integer idCelular) throws SQLException {
    Celular celular = new Celular();

    try {
        String q = "SELECT * FROM celular WHERE id=?";
        ps = con.prepareStatement(q);

        ResultSet rs = ps.executeQuery();
  
        while(rs.next()) {
          celular.setId(rs.getInt("id"));
          celular.setMarca(rs.getString("marca "));
          celular.setModelo(rs.getString("modelo"));
          celular.setCor(rs.getString("cor"));
          celular.setCamera(rs.getString("camera"));
          celular.setMemoria(rs.getInt("memoria"));
        }

        rs.close(); 
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return celular;
  }

  public List<Celular> listcelulars() throws SQLException{
    List<Celular> celulares = new ArrayList<>();
    
    try {
        String q = "SELECT * FROM celular";

        ps = con.prepareStatement(q);

        ResultSet rs = ps.executeQuery();
  
        while(rs.next()) {
          Celular celular = new Celular();
  
          celular.setId(rs.getInt("id"));
          celular.setMarca(rs.getString("marca "));
          celular.setModelo(rs.getString("modelo"));
          celular.setCor(rs.getString("cor"));
          celular.setCamera(rs.getString("camera"));
          celular.setMemoria(rs.getInt("memoria"));
          celulares.add(celular);
        }
  
        rs.close(); 
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return celulares;
}
}
