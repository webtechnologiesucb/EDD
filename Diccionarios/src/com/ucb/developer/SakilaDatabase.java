package com.ucb.developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

public class SakilaDatabase {

	public static void main(String[] args) {
        LinkedList<Actor> actors = new LinkedList<>();

        try {
            // Conectar a la base de datos
        	int actorId = 0;
        	Connection con = Conexion.getInstance().getConnection();
        	String consulta = "SELECT actor_id, first_name, last_name, last_update " 
        			+ "FROM actor " 
    				+ "WHERE actor_id>?";
    		PreparedStatement pst = con.prepareStatement(consulta);
    		pst.setInt(1, actorId);
    		ResultSet rs = pst.executeQuery();
    		System.out.println(pst.toString());
  
            // Leer los datos y almacenarlos en la LinkedList
            while (rs.next()) {
            	Actor actor = new Actor();
                actor.setActorId(rs.getInt("actor_id"));
                actor.setFirstName(rs.getString("first_name"));
                actor.setLastName(rs.getString("last_name"));
                actor.setLastUpdate(rs.getDate("last_update"));
                actors.add(actor);
            }

            // Cerrar la conexión
            rs.close();
            pst.close();
            con.close();

            // Mostrar los datos
            for (Actor actor : actors) {
                System.out.println(actor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
