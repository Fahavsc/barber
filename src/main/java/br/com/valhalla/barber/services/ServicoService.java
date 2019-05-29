package br.com.valhalla.barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.barber.domain.Servico;
import br.com.valhalla.barber.repositories.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    //Pesquisar todos
    public List<Servico> findAll() {
        return this.repository.findAll();
    }

    //Pesquisar por id
    public Optional<Servico> findById(Integer id) {
        return this.repository.findById(id);
    }

    //Salvar
    public Servico save(Servico servico) {
        return this.repository.save(servico);
    }

    //Deletar
    public Optional<Servico> deleteById(Integer id) {

        Optional<Servico> fetchedServico = this.repository.findById(id);
        
        if (fetchedServico.isPresent()) {
            this.repository.deleteById(id);
            
        }
        return fetchedServico;
    }
}
