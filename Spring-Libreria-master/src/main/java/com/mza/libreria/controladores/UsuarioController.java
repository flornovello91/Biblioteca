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
        return "registro";
    }
    
    @PostMapping("/registro")
    public String registrar (ModelMap modelo,@RequestParam String nombre,@RequestParam String apellido, @RequestParam String email, @RequestParam String contraseña) throws Exception{
        try {
            usuarioService.registrarUsuario(nombre, apellido, email, contraseña);
            //modelo.put("exito", "Guardado de manera exitosa!");
            return ("registro");
        }catch (Exception e){
            //modelo.put("error", "Error en la carga del libro.");
            return ("registro");
        }
    }
    
    @GetMapping("/ingreso")
    public String ingreso(){
        return "ingreso.html";
    }

}
/*
@PostMapping("/registro")
    public String registrar(ModelMap modelo,
                            @RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam String email,
                            @RequestParam String clave1,
                            @RequestParam String clave2) {

        try {
            sUsuario.registrar(nombre, apellido, email, clave1, clave2);
        } catch (MiExcepcion ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("email", email);
            modelo.put("clave1", clave1);
            modelo.put("clave2", clave2);
            return "nUsuario";
        }
        modelo.put("titulo", "Bienvenido al Sistema de Gestion de Biblioteca");
        modelo.put("descripcion", "Tu usuario fue registrado correctamente");
        return "registro-exitoso";
    }
*/