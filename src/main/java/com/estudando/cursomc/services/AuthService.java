package com.estudando.cursomc.services;

import com.estudando.cursomc.domain.Cliente;
import com.estudando.cursomc.repositories.ClienteRepository;
import com.estudando.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if(cliente == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();
        cliente.setSenha(passwordEncoder.encode(newPass));

        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente, newPass);
    }

    public String newPassword() {
        char[] vet = new char[10];
        for(int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    public char randomChar() {
        int opt = random.nextInt(3);
        if(opt == 1){ // gera um digito
            return (char) (random.nextInt(10) + 48);
        }
        else if (opt == 2) { // gera letra maiuscula
            return (char)(random.nextInt(26)+ 65);
        }
        else { // gera letra minuscula
            return (char)(random.nextInt(26)+ 97);
        }
    }
}
