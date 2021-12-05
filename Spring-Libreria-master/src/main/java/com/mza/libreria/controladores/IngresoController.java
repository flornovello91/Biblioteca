package com.mza.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IngresoController {
    
    @GetMapping("/ingreso")
    public String ingreso(){
        return "ingreso.html";
    }
    
}
