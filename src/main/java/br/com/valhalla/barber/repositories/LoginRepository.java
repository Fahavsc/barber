package br.com.valhalla.barber.repositories;

import br.com.valhalla.barber.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository <Login, Integer> {
    Login findByUsuarioAndSenha(String usuario, String senha);
}
