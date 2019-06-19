package br.com.valhalla.barber.services;

import br.com.valhalla.barber.domain.Cliente;
import br.com.valhalla.barber.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<Cliente> findByUsuario(String usuario){ return this.repository.findByUsuarioContaining(usuario); }

    //Pesquisar todos
    public List<Cliente> findAll() {
        return this.repository.findAll();
    }

    //Pesquisar por id
    public Optional<Cliente> findById(Integer id) {
        return this.repository.findById(id);
    }

    //Salvar
    public Cliente save(Cliente cliente) {
        return this.repository.save(cliente);
    }

    //Deletar
    public Optional<Cliente> deleteById(Integer id) {

        Optional<Cliente> fetchedCliente = this.repository.findById(id);

        if (fetchedCliente.isPresent()) {

            this.repository.deleteById(id);
        }
        return fetchedCliente;
    }
}
