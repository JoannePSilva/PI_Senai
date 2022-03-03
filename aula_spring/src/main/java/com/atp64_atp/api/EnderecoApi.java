package com.atp64_atp.api;

import java.util.List;

import com.atp64_atp.model.EnderecoCliente;
import com.atp64_atp.repository.EnderecoClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoApi {

@Autowired    
private EnderecoClienteRepository repository;
    
       

@GetMapping
public List<EnderecoCliente> enderecos(String nome){
    return (List<EnderecoCliente>)repository.findAll();
}


@PostMapping
public String create(@RequestBody EnderecoCliente model){
    repository.save(model);
    return "Salvo com sucesso";
     
}

@DeleteMapping("/{id}")
public String delete(@PathVariable int id){
    repository.deleteById(id);
    return "Deletado com sucesso";
    }

@PutMapping("/{id}")
public String update(@RequestBody EnderecoCliente model, @PathVariable int id){
    if(model.getId() == id){
        repository.save(model);
        return "Alterado com sucesso";
    }
    return "Id da url diferente do body";
    }
}



