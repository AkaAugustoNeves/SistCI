package br.com.codeguskr.sistci.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.codeguskr.sistci.model.Coordenacao;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CoordenacaoServiceTest {

	@Autowired
	private CoordenacaoService coordenacaoService;
	
	@Test
	public void buscarPorIdTest() {
		Coordenacao coord = coordenacaoService.porId(1L);
		assertEquals(Long.parseLong("1"), coord.getId());
	}
	
}
