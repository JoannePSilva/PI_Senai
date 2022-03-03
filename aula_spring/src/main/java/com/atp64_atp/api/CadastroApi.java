package com.atp64_atp.api;

import java.util.List;

import com.atp64_atp.model.Cliente;
import com.atp64_atp.repository.ClienteRepository;

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
@RequestMapping("api/cadastro")
public class CadastroApi {

@Autowired    
private ClienteRepository repository;
    
       

@GetMapping
public List<Cliente> clientes(String nome){
    if(nome != null){
        return (List<Cliente>)repository.findByNome(nome);
       
    }
    return (List<Cliente>)repository.findAll();
}


@PostMapping
public String salvar(@RequestBody Cliente model){
    repository.save(model);
    return "Salvo com sucesso";
    }  
     

@DeleteMapping("/{id}")
public String delete(@PathVariable int id){
    repository.deleteById(id);
    return "Deletado com sucesso";
    }

@PutMapping("/{id}")
public String update(@RequestBody Cliente model, @PathVariable int id){
    if(model.getId() == id){
        repository.save(model);
        return "Alterado com sucesso";
    }
    return "Id da url diferente do body";
    }
}

