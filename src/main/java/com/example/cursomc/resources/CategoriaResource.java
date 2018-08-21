package com.example.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.cursomc.domain.Categoria;

import java.util.*;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @RequestMapping(method=RequestMethod.GET)
    public List<Categoria> listar(){
        Categoria cat1 = new Categoria(1,"informaticac");
        Categoria cat2 = new Categoria(2,"Escritorio");

        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;

    }
}
