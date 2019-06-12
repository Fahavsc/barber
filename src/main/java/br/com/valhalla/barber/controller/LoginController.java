package br.com.valhalla.barber.controller;

import br.com.valhalla.barber.domain.Login;
import br.com.valhalla.barber.domain.Servico;
import br.com.valhalla.barber.repositories.LoginRepository;
import br.com.valhalla.barber.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/{usuario}/{senha}")
    public ResponseEntity get(@PathVariable String usuario, @PathVariable String senha) {

        Login login = this.loginRepository.findByUsuarioAndSenha(usuario, senha);

        return new ResponseEntity(login, HttpStatus.OK);
    }

    public Login post (String usuario, String senha, String tipo){
        Login login = new Login();
        login.setUsuario(usuario);
        login.setSenha(senha);
        login.setTipo(tipo);
        return this.loginRepository.save(login);
    }

}