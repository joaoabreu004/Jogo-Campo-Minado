package br.com.cod3r.com.modelo; 

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

import br.com.cod3r.com.excecao.ExplosaoException;
import br.com.cod3r.com.modelo.Campo;


public class CampoTeste{
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo(){
		campo = new Campo(3,3); 
	}	


	@Test
	void testeVizinhoRealDistancia1Esquerda(){
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeVizinhoRealDistancia1Direita(){
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeVizinhoRealDistancia1EmCima(){
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeVizinhoRealDistancia1Embaixo(){
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeVizinhoRealDistancia2(){
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeNaoVizinhoDistancia2(){
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertTrue(resultado); 
	}

	@Test
	void testeNaoVizinho(){
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho); 		
		assertFalse(resultado); 
	}

	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertTrue(campo.abrir());
	}
	
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		}); 
		
	}
	
	
	@Test
	void testeAbrirComVizinhos1() {
		
		Campo campo11 = new Campo(1,1); 
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11); 
		
		campo.adicionarVizinho(campo22); 
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinho2() {
		
		Campo campo11 = new Campo(1,1); 
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11); 
		
		campo.adicionarVizinho(campo22); 
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	
	
	
	
	
	
}