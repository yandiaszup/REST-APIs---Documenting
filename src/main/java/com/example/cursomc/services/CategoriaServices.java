package com.example.cursomc.services;

import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.servicesexceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cursomc.domain.Categoria;
import java.util.*;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repo;


    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
