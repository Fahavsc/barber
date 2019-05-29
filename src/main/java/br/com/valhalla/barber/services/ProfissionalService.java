package br.com.valhalla.barber.services;

import br.com.valhalla.barber.domain.Profissional;
import br.com.valhalla.barber.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository repository;

    //Pesquisar todos
    public List<Profissional> findAll() {
        return this.repository.findAll();
    }

    //Pesquisar por id
    public Optional<Profissional> findById(Integer id) {
        return this.repository.findById(id);
    }

    //Salvar
    public Profissional save(Profissional profissional) {
        return this.repository.save(profissional);
    }

    //Deletar
    public Optional<Profissional> deleteById(Integer id) {

        Optional<Profissional> fetchedProfissional = this.repository.findById(id);

        if (fetchedProfissional.isPresent()) {

            this.repository.deleteById(id);
        }
        return fetchedProfissional;
    }
}
