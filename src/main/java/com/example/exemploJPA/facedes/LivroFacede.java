package com.example.exemploJPA.facedes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemploJPA.model.entities.AutorLivro;
import com.example.exemploJPA.model.entities.Categoria;
import com.example.exemploJPA.model.entities.Editora;
import com.example.exemploJPA.model.entities.Livro;
import com.example.exemploJPA.model.entities.LivroSpecifications;
import com.example.exemploJPA.model.repositories.AutorLivroRepository;
import com.example.exemploJPA.model.repositories.CategoriaRepository;
import com.example.exemploJPA.model.repositories.EditoraRepository;
import com.example.exemploJPA.model.repositories.LivroRepository;
import com.example.exemploJPA.requests.AddLivroRequest;

@Service
public class LivroFacede {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorLivroRepository autoresLivrosRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public boolean inserirLivro(AddLivroRequest request) {
        try {
            Livro livroSalvo = new Livro();
            Optional<Editora> editora = editoraRepository.findById(request.getEditoraId().longValue());
            Optional<Categoria> categoria = categoriaRepository.findById(request.getCategoriaId().longValue());
            if (!editora.isPresent() && !categoria.isPresent())
                return false;
            livroSalvo.setEditora(editora.get());
            livroSalvo.setGeneroId(categoria.get());
            livroSalvo.setLivroNome(request.getNome());
            livroSalvo.setLancaAno(request.getDataLancamento());
            livroRepository.save(livroSalvo);
            request.getAutoresId().forEach((autor) -> insertAutorLivros(autor, livroSalvo.getLivroId()));
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    private void insertAutorLivros(Number autorId, Long livroId) {
        AutorLivro autorLivro = new AutorLivro();
        autorLivro.setAutorId(autorId.longValue());
        autorLivro.setLivroId(livroId);

        autoresLivrosRepository.save(autorLivro);

    }

    public List<Livro> getLivros(String livroNome, Date dataLancamento, Long categoriaId, Long editoraId) {
       
        Optional<Editora> editora = this.editoraRepository.findById(editoraId);
        Optional<Categoria> categoria = this.categoriaRepository.findById(categoriaId);

        return this.livroRepository
                .findAll(LivroSpecifications.comFiltros(livroNome, dataLancamento, categoria.orElse(null),
                        editora.orElse(null)));
    }

}
