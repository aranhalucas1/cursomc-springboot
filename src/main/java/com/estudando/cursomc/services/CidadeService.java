package com.estudando.cursomc.services;

import com.estudando.cursomc.domain.Cidade;
import com.estudando.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findCidades(Integer estado_id) {
        return cidadeRepository.findCidades(estado_id);
    }
}
