package br.unitins.loja.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.loja.model.Compra;

@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra> {
    
}
