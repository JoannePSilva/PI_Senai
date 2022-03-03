package com.atp64_atp.api;


    import java.util.List;

import com.atp64_atp.TipoCliente;
import com.atp64_atp.repository.TipoClienteRepository;

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
@RequestMapping("/api/tipo_cliente")
public class TipoClienteApi {

@Autowired    
private TipoClienteRepository repository;
    
       

@GetMapping
public List<TipoCliente> enderecos(String nome){
    return (List<TipoCliente>)repository.findAll();
}


@PostMapping
public String create(@RequestBody TipoCliente model){
    repository.save(model);
    return "Salvo com sucesso";
    }  
     

@DeleteMapping("/{id}")
public String delete(@PathVariable int id){
    repository.deleteById(id);
    return "Deletado com sucesso";
    }

@PutMapping("/{id}")
public String update(@RequestBody TipoCliente model, @PathVariable int id){
    if(model.getId() == id){
        repository.save(model);
        return "Alterado com sucesso";
    }
    return "Id da url diferente do body";
    }
}


    

