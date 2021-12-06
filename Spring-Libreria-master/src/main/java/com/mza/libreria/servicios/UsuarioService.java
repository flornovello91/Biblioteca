package com.mza.libreria.servicios;

import com.mza.libreria.MyException.MyException;
import com.mza.libreria.entidades.Usuario;
import com.mza.libreria.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private RepositorioUsuario repositorioUsuario;
            
            
    public void registrarUsuario(String nombre,String apellido,String email,Integer contraseña) throws Exception{
        try {
            
            Usuario usuario = new Usuario();
            
            validarDatos(nombre,apellido,email,contraseña);
            
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setContraseña(contraseña);
            
            repositorioUsuario.save(usuario);
            
        }catch(Exception e){
            System.out.println("El usuario no pudo ser registrado.");
        }
    }
    
    public void validarDatos(String nombre,String apellido,String email,Integer contraseña) throws Exception{
        
        if (nombre==null || nombre.isEmpty() || nombre.contains(" ")){
            throw new Exception("Inserte un nombre.");
        }
        if (apellido==null || apellido.isEmpty() || apellido.contains(" ")){
            throw new Exception("Inserte un apellido.");
        }
        if (email==null || email.isEmpty() || email.contains(" ")){
            throw new Exception("Inserte un email.");
        }
        if (contraseña<8){
            throw new MyException("Debe indicar una contraseña correcta.");
        }
    }
}
