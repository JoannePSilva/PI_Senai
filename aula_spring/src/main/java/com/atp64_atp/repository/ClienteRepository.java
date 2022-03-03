package com.atp64_atp.repository;

import java.util.List;

import com.atp64_atp.model.Cliente;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;


    public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
//para ser utilizado em mais pontos da aplicação
    @Override
    default Iterable<Cliente> findAll() {
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    List<Cliente> findByNome(String nome);
    }
    