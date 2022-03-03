package com.atp64_atp.controller;

import java.util.List;

import com.atp64_atp.model.Cliente;
import com.atp64_atp.repository.ClienteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    private ClienteRepository repository;

public ClienteController(ClienteRepository repository){
    this.repository = repository;
}

//mapear/encontrar o caminho
@GetMapping("/cadastro")
public String cadastro(Model req, String nome){
    List<Cliente> listaClientes; 
    if(nome != null){
        listaClientes = (List<Cliente>)repository.findByNome(nome);
       
    }else{
        listaClientes = (List<Cliente>)repository.findAll();
}
    req.addAttribute("cliente", listaClientes);
    return "cadastro";
}

@GetMapping("/cadastro/form")
    public String formulario(Model req){
        Cliente model = new Cliente();
        req.addAttribute("cliente", model);  
        return "cadastro-form";
    }
    @PostMapping("/cadastro/salvar")
        public String salvar(Cliente model){
            repository.save(model);
            return "redirect:/cadastro";
        }  
     

    @GetMapping("/cadastro/deletar/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/cadastro";
    }

    @GetMapping("/cadastro/editar/{id}")
    public String editar(@PathVariable int id, Model req){
        System.out.println("editou");
        Cliente model = repository.findById(id).get();
        req.addAttribute("cliente", model);
        return "cadastro-form";
    }
}

