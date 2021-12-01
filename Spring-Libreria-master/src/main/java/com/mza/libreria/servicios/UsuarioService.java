package com.mza.libreria.servicios;

import com.mza.libreria.MyException.MyException;
import com.mza.libreria.entidades.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    
    public void registrarUsuario(String nombre,String apellido,String email,long contraseña){
        try {
            Usuario usuario = new Usuario();
            
        }
    }
    
    
    public void validarDatos(String nombre,String apellido,String email,long contraseña) throws Exception{
        
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
