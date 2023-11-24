package com.example.exemploJPA.facedes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.Emprestimo;
import com.example.exemploJPA.model.entities.EmprestimoSpecifications;
import com.example.exemploJPA.model.entities.Exemplar;
import com.example.exemploJPA.model.entities.ExemplaresEmprestimos;
import com.example.exemploJPA.model.entities.Funcionario;
import com.example.exemploJPA.model.entities.Usuario;
import com.example.exemploJPA.model.repositories.EmprestimoRepository;
import com.example.exemploJPA.model.repositories.ExemplarRepository;
import com.example.exemploJPA.model.repositories.ExemplaresEmprestimosRepository;
import com.example.exemploJPA.model.repositories.FuncionarioRepository;
import com.example.exemploJPA.model.repositories.UsuarioRepository;

@Service
public class EmprestimoFacede {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Autowired
    private EmprestimoRepository emprestimoReposiiory;

    @Autowired
    ExemplaresEmprestimosRepository exemplaresEmprestimosRepository;

    public boolean efetuarEmprestimo(Long usuId, Long funcId, List<Long> exempId, Date empData) {
        try {

            Optional<Usuario> usuario = this.usuarioRepository.findById(usuId);
            Optional<Funcionario> funcionario = this.funcionarioRepository.findById(funcId);
            List<Exemplar> exemplar = this.exemplarRepository.findAllById(exempId);

            List<ExemplaresEmprestimos> list = this.exemplaresEmprestimosRepository.findAll();
            for (Long id : exempId)
                if (exemplarJaEmprestado(id, list))
                    return false;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(empData);
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            if (usuario.isEmpty() || funcionario.isEmpty() || exemplar.isEmpty())
                return false;

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setEmprestData(empData);
            emprestimo.setEmprestDataPrevista(calendar.getTime());
            emprestimo.setEmprestimoStatus("EMPRESTADO");
            emprestimo.setFuncionario(funcionario.get());
            emprestimo.setUsuario(usuario.get());

            Emprestimo saved = emprestimoReposiiory.save(emprestimo);
            exempId.forEach((exemplarId) -> this.inserirEmprestimoExemplares(saved.getEmprestId(), exemplarId));
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    private void inserirEmprestimoExemplares(Long emprestimoId, Long exemplarId) {
        ExemplaresEmprestimos emprestimoExemplares = new ExemplaresEmprestimos();
        emprestimoExemplares.setDataDevolucao(null);
        emprestimoExemplares.setExemplar_id(exemplarId);
        emprestimoExemplares.setEmprestimo_id(emprestimoId);

        this.exemplaresEmprestimosRepository.save(emprestimoExemplares);

    }

    private boolean exemplarJaEmprestado(Long exemplarId, List<ExemplaresEmprestimos> exemplaresEmp) {
        for (ExemplaresEmprestimos exem : exemplaresEmp) {
            if (exem.getExemplar_id() == exemplarId) {
                Optional<Emprestimo> emp = this.emprestimoReposiiory.findById(exem.getEmprestimo_id());
                if (emp.isPresent()) {
                    if (emp.get().getEmprestimoStatus().equals("EMPRESTADO"))
                        return true;
                }
            }
        }
        return false;
    }

    public List<Emprestimo> getEmprestimos(Long usuId, Long funcId, Date dataEmp, String status) {
        Optional<Usuario> usu = this.usuarioRepository.findById(usuId);
        Optional<Funcionario> func = this.funcionarioRepository.findById(funcId);

        return this.emprestimoReposiiory
                .findAll(EmprestimoSpecifications.comFiltros(dataEmp, usu.orElse(null), func.orElse(null), status));

    }
}
