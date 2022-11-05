package com.br.sorveteria.service;

import com.br.sorveteria.entity.Sorvete;
import com.br.sorveteria.http.SorveteResponse;
import com.br.sorveteria.repository.SorveteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SorveteService {

    private SorveteRepository repository;

    public void salvar(Sorvete sorvete) {
        repository.save(sorvete);
    }

    public List<SorveteResponse> findAll() {
        List<Sorvete> entity = repository.findAll();
        List<SorveteResponse> response = new ArrayList<>();

        for (Sorvete e : entity
        ) {
            SorveteResponse sorvete = new SorveteResponse();
            sorvete.setSorveteMassa(e.getSorveteMassa());
            sorvete.setSorvetePalito(e.getSorvetePalito());
        }
        return response;
    }

    public SorveteResponse findByid(Long id) throws SorveteNaoEncontradoException {
        Optional<Sorvete> entity = repository.findById(id);
        if (entity.isPresent()) {
            Sorvete e = entity.get();
            SorveteResponse sorvete = new SorveteResponse();
            sorvete.setSorveteMassa(e.getSorveteMassa());
            sorvete.setSorvetePalito(e.getSorvetePalito());
            return sorvete;
        } else {
            throw new SorveteNaoEncontradoException();
        }
    }

    public void deletebyId(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Sorvete sorvete) throws SorveteNaoEncontradoException {
        Optional<Sorvete> res = repository.findById(id);
        if (res.isPresent()) {
            Sorvete sorvete1 = res.get();
            sorvete1.setSorveteMassa(sorvete1.getSorveteMassa());
            sorvete1.setSorvetePalito(sorvete1.getSorvetePalito());
            repository.save(sorvete);
        } else {
            throw new SorveteNaoEncontradoException();
        }
    }
}
