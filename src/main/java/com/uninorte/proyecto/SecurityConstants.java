/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto;

/**
 *
 * @author Marbel
 */
public class SecurityConstants {
    
    	public static final String SECRET = "K3763RA71ONN33DS570B31NVOSIDHJSKDSS987YWAU77";
	public static final long EXPIRATION_TIME = 86_400_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/usuario/add";
	
   
   
    public SecurityConstants() {
    	super();
    }



	public static byte[] getSecret() {
		return SECRET.getBytes();
	}
    
   
	
}
