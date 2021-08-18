package br.com.codeguskr.sistci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.codeguskr.sistci.model.Coordenacao;
import br.com.codeguskr.sistci.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	@Query(value = "SELECT * FROM DOCUMENTO WHERE date > ?1 and date < ?2", nativeQuery= true)
	List<Documento> buscarPorDatas(String dataInicio, String dataFinal);

	@Query(value= "SELECT * FROM documento WHERE tipo_documento_id = ?1 AND coordenacao_id = ?2", nativeQuery= true)
	List<Documento> findByCoordenacaoAndTipoDoc(Long tipoDoc ,Long coordenacao);
	 
}
