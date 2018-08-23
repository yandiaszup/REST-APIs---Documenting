package com.example.cursomc.services;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.servicesexceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServices {

    @Autowired
    private PedidoRepository repo;


    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
