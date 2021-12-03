package com.mza.libreria.controladores;

import com.mza.libreria.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class RegistroController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }
    
    @PostMapping("/registro")
    public String registrar(ModelMap modelo,@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email , @RequestParam Integer contraseña){
        try{
            usuarioService.registrarUsuario(nombre, apellido, email, contraseña);
            return ("registro");
        }catch (Exception e){
            return null;
        }
    }
    
}

/*
@Autowired
    @PostMapping("/registro")
    public String guardarLibro(ModelMap modelo,@RequestParam (required = false) Long isbn,@RequestParam String titulo,@RequestParam String autor,@RequestParam String editorial,@RequestParam (required = false) Integer anio)throws MyException{
        try{
            libroService.guardarLibro(isbn,titulo,autor,editorial,anio);
            modelo.put("exito", "Guardado de manera exitosa!");
            return ("formularioIngreso");
        }catch (MyException e){
            modelo.put("error", "Error en la carga del libro.");
            return ("formularioIngreso");
        }
    }
}

*/