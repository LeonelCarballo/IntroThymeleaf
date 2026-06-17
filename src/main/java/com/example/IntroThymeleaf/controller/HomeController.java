package com.example.IntroThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

import java.time.LocalTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(
            @RequestParam(name = "nombre", required = false, defaultValue = "Invitado") String nombre,
            Model model,
            HttpSession session
    ) {
        model.addAttribute("mensajeBienvenida", "¡Hola mundo desde Spring Boot y Thymeleaf!");
        model.addAttribute("nombreUsuario", nombre);

        session.setAttribute("operador", "Admin");

        return "index";
    }

    @GetMapping("/saludo")
    public String saludo(Model model) {
        LocalTime ahora = LocalTime.now();

        int hora = ahora.getHour();

        String saludo;
        String claseCss;

        if (hora >= 5 && hora < 12) {
            saludo = "¡Buenos días! Hora de programar";
            claseCss = "color: #198754";
        } else if (hora >= 12 && hora < 19) {
            saludo = "¡Buenas tardes! Sigue así";
            claseCss = "color: #0d6efd";
        } else {
            saludo = "¡Buenas noches! A descansar";
            claseCss = "color: #dc3545";
        }
    }



}