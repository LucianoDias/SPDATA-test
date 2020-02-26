package br.com.dev.drogaria.dao;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dev.drogaria.domain.Estado;

public class EstadoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);		
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		System.out.println("Quantidade de registro "+resultado.size());
		for(Estado estado : resultado){
			System.out.println(estado.getSigla()+" - "+estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo =10l;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			System.out.println(estado.getSigla()+" - "+estado.getNome());
		}	
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 7l;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido com sucesso!");
			System.out.println(estado.getSigla()+" - "+estado.getNome());
		}	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 10l;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);
			System.out.println("Registro alterado com sucesso!");
			System.out.println(estado.getSigla()+" - "+estado.getNome());
		}	
	}

}
