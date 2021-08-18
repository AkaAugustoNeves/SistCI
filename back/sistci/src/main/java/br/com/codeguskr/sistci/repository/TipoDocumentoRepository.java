package br.com.codeguskr.sistci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codeguskr.sistci.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

}
