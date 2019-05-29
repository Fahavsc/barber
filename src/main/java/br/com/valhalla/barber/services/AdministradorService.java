package br.com.valhalla.barber.services;

import br.com.valhalla.barber.domain.Administrador;
import br.com.valhalla.barber.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;

    //Pesquisar todos
    public List<Administrador> findAll() {
        return this.repository.findAll();
    }

    //Pesquisar por id
    public Optional<Administrador> findById(Integer id) {
        return this.repository.findById(id);
    }

    //Salvar
    public Administrador save(Administrador administrador) {
        return this.repository.save(administrador);
    }

    //Deletar
    public Optional<Administrador> deleteById(Integer id) {

        Optional<Administrador> fetchedAdministrador = this.repository.findById(id);

        if (fetchedAdministrador.isPresent()) {

            this.repository.deleteById(id);
        }
        return fetchedAdministrador;
    }
}
