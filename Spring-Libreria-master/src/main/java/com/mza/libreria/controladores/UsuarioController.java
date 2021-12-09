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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/registro")
    public String registro(){
        return "registro.html";
    }
    
    @PostMapping("/registro")
    public String registrar (ModelMap modelo,@RequestParam String nombre,@RequestParam String apellido, @RequestParam String email, @RequestParam String contraseña) throws Exception{
        try {
            usuarioService.registrarUsuario(nombre, apellido, email, contraseña);
            //modelo.put("exito", "Guardado de manera exitosa!");
            return ("registro.html");
        }catch (Exception e){
            //modelo.put("error", "Error en la carga del libro.");
            return ("registro.html");
        }
    }
    
    @GetMapping("/ingreso")
    public String ingreso(){
        return "ingreso.html";
    }

}
