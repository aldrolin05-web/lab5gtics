package com.example.lab5.controller;

import com.example.lab5.entity.Customer;
import com.example.lab5.repository.ClienteRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@AllArgsConstructor
public class InicioController {

    private final ClienteRepository clienteRepository;

    @GetMapping("/inicio")
    public String listaInicio() {
        return "inicio";
    }

    @GetMapping("/listar")
    public String listarClientes(Model model) {
        model.addAttribute("clientes-lista", clienteRepository.findAll());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String crearCliente(Model model, Customer customer) {
        return ("nuevo");
    }

    @GetMapping("/editar/{id}")
    public String editarClientes(Model model, @PathVariable("id") Integer id) {
        Customer customer = clienteRepository.findById(id).orElse(new Customer());
        model.addAttribute("Cliente", customer);
        return "editar";
    }

    @GetMapping("/guardar")
    public String guardarClientes(@Valid @ModelAttribute Customer customer, BindingResult result) {
        return "guardar";
    }

}