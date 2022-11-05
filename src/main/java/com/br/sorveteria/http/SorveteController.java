package com.br.sorveteria.http;

import com.br.sorveteria.entity.Sorvete;
import com.br.sorveteria.service.SorveteNaoEncontradoException;
import com.br.sorveteria.service.SorveteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SorveteController {
    @Autowired
    private SorveteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Sorvete sorvete) {
        service.salvar(sorvete);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SorveteResponse> findAll() {
        return service.findAll();
    }

    @SneakyThrows
    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SorveteResponse findByid(@RequestParam("id") Long id) {
        return service.findByid(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deletebyId(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Sorvete sorvete) throws SorveteNaoEncontradoException {
        service.atualizar(id, sorvete);
    }


}
