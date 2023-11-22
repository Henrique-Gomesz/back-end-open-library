package com.example.exemploJPA.facedes;

import com.example.exemploJPA.model.entities.*;
import com.example.exemploJPA.model.repositories.*;
import com.example.exemploJPA.requests.ReservaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaFacede {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepositoryRepository;

    public boolean reservarLivro(ReservaRequest request){
        try{
            Reserva reserva = new Reserva();
            Usuarios usuario;
            Exemplar exemplar;
            Livro livro;
            Funcionario funcionario;
            Optional <Usuarios> usuarioOptional = usuarioRepository.findByCpf(request.getUsuarioCPF());
            if(usuarioOptional.isPresent()){
                usuario = usuarioOptional.get();
                Optional<Exemplar> exemplarOptional = exemplarRepository.findDisponivelReserva(request.getLivrosID(), "Ativo");
                if(exemplarOptional.isPresent()){
                    Optional<Livro> livroOptional = livroRepository.findById(request.getLivrosID());
                    if(livroOptional.isPresent()){
                        livro = livroOptional.get();
                        Optional<Funcionario> funcionarioOptional = funcionarioRepositoryRepository.findById(request.getFuncionarioID());
                        if(funcionarioOptional.isPresent()){
                            funcionario = funcionarioOptional.get();

                            reserva.setDataReserva(request.getDataReserva());
                            reserva.setFuncionario(funcionario);
                            reserva.setUsuario(usuario);
                            reserva.setLivro(livro);

                            reservaRepository.save(reserva);
                            return true;
                        }
                    }
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
