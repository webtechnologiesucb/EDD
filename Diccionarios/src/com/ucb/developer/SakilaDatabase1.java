package com.ucb.developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class SakilaDatabase1 {
	public static void main(String[] args) {
        LinkedList<Country> countries = new LinkedList<>();
        try {
            // Conectar a la base de datos
        	int countryId = 0;
        	Connection con = Conexion.getInstance().getConnection();
        	String consulta = "SELECT country_id, country, last_update " 
        			+ "FROM country " 
    				+ "WHERE country_id > ?";
    		PreparedStatement pst = con.prepareStatement(consulta);
    		pst.setInt(1, countryId);
    		ResultSet rs = pst.executeQuery();
    		System.out.println(pst.toString());
            // Leer los datos y almacenarlos en la LinkedList
            while (rs.next()) {
            	Country c = new Country();
            	c.setCountryId(rs.getInt("country_id"));
                c.setCountry(rs.getString("country"));
                c.setLastUpdate(rs.getDate("last_update"));
                countries.add(c);
            }
            // Cerrar la conexión
            rs.close();
            pst.close();
            con.close();
            // Mostrar los datos
            for (Country c : countries) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}