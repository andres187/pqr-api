/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.controller.usuario.IMPL;

import com.uninorte.proyecto.controller.usuario.LoginResponse;
import com.uninorte.proyecto.controller.usuario.security.SecurityConstants;
import com.uninorte.proyecto.controller.usuario.interfaces.UsuarioRepositorio;
import com.uninorte.proyecto.controller.usuario.interfaces.UsuarioService;
import com.uninorte.proyecto.entities.usuario.Usuario;
import com.uninorte.proyecto.entities.usuario.Credencial;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.BufferedWriter;
import java.sql.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 *
 * @author Andres Bolivar
 */
@Service
public class UsuarioServiceIMPL implements UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;
    
    @Override
    public List<Usuario> listar() {
        
        List<Usuario> lista = new ArrayList<>();
        
        String connectionUrl = "jdbc:sqlserver://andrespru.database.windows.net:1433;database=consware;user=andres187@andrespru;password=*q1w2e3r4t5;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";		
        // Declaramos los sioguientes objetos
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Establecemos la conexión
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT id,nombre,apellido, usuario,password FROM users";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Usuario itm = new Usuario();
                itm.setId(rs.getInt("id"));
                itm.setNombre(rs.getString("nombre"));
                itm.setApellido(rs.getString("apellido"));
                itm.setUsuario(rs.getString("usuario"));
                itm.setPassword(rs.getString("password"));
                lista.add(itm);
            }
            
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch(SQLException e) {}
            if (con != null) try { con.close(); } catch(SQLException e) {}
        }
                
        //return repositorio.findAll();
        return lista;
    }

    @Override
    public Usuario add(Usuario u) {        
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(u.getPassword().getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        u.setPassword(sha1);
        
        return repositorio.save(u);
    }
    
    private static String byteToHex(final byte[] hash){
        String result;
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash)
            {
                formatter.format("%02x", b);
            }   result = formatter.toString();
        }
        return result;
    }

    @Override
    public void archivo() {
        
        String connectionUrl = "jdbc:sqlserver://andrespru.database.windows.net:1433;database=consware;user=andres187@andrespru;password=*q1w2e3r4t5;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";		
        // Declaramos los sioguientes objetos
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        
        try {
            //Establecemos la conexión
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT id,nombre,apellido, usuario,password FROM users";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            
           
            FileWriter fw = new FileWriter("C:\\Datos\\Prueba.txt");            
            BufferedWriter bw = new BufferedWriter(fw);
            while (rs.next()) {
               
                bw.append(rs.getString("nombre"));
                bw.append(";");
                bw.append(rs.getString("apellido"));
                bw.append(";");
                bw.append(rs.getString("usuario"));
                bw.append(";");
                bw.append(rs.getString("password"));
                bw.newLine();
                System.out.println(rs.getString("nombre"));
                
            }
            
            bw.close();
            
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioServiceIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (rs != null) try { rs.close(); } catch(SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch(SQLException e) {}
            if (con != null) try { con.close(); } catch(SQLException e) {}
        }
        
    }

    @Override
    public LoginResponse login(Credencial credencial) {
        LoginResponse loginResponse = new LoginResponse();
        Usuario user = repositorio.getUserByUsuario(credencial.getUsuario());
        if(user!=null){
                    String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(credencial.getPassword().getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        credencial.setPassword(sha1);
        if(user.getPassword().equals(credencial.getPassword())){
            String token=appendJSonWebToken(user);
			loginResponse.setToken(token); 
			loginResponse.setStatus(LoginResponse.OK);
			loginResponse.setUserId(user.getId());
			loginResponse.setUsername(user.getNombre());
        }
        }
        
        return loginResponse;
    }
    
    	private String appendJSonWebToken (Usuario user) {
		Date date=getExpirationDate();
		String token=Jwts.builder().setSubject(String.valueOf(user.getId()))
					  .setExpiration(date)
					  .signWith(SignatureAlgorithm.HS512, SecurityConstants.getSecret())
					  .compact();
		return token;
	}
	
	private Date getExpirationDate () {
		Date date = new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME);
		return date;
	}
    
}
