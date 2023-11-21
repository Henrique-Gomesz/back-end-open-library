    package com.example.exemploJPA.model.entities;

    import java.io.Serializable;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.EnumType;
    import jakarta.persistence.Enumerated;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;

    @Entity
    @Table(name = "categoria")
    public class Categoria implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "categ_id")
        private Long id;

        @Enumerated(EnumType.STRING)
        @Column(name = "categ_nome", nullable = false)
        private EnumCategorias nome;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public EnumCategorias getNome() {
            return nome;
        }

        public void setNome(EnumCategorias nome) {
            this.nome = nome;
        }

    }
