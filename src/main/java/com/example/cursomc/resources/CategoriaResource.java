package com.example.cursomc.resources;

import com.example.cursomc.DTO.CategoriaDTO;
import com.example.cursomc.domain.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cursomc.domain.Categoria;
import com.example.cursomc.services.CategoriaServices;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
@Api(description="EndPoint que representa as categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaServices service;

    @ApiOperation(value = "Retorna uma categoria pelo id.",response = Categoria.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Insere uma nova categoria.",response = Categoria.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@Valid @RequestBody CategoriaDTO objDTO){
        Categoria obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @ApiOperation(value = "Atualiza uma categoria pelo id.")
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id){
        Categoria obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @ApiOperation(value = "Deleta uma categoria pelo id.")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna todas as categorias.", response = Categoria.class) // response -> Objeto de resposta
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> findall(){
        List<Categoria> lista = service.findall();
        List<CategoriaDTO> listDto = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<?> findpage(@RequestParam(value="page", defaultValue="0") Integer page,
                                      @RequestParam(value="linesperpage", defaultValue = "24") Integer linesPerPage,
                                      @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                      @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        Page<Categoria> lista = service.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoriaDTO> listDto = lista.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}
