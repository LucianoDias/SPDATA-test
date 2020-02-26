package br.com.dev.drogaria.dao;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Cidade;
import br.com.dev.drogaria.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(10l);
		if(estado == null){
			System.out.println("Estado não encontrado");
		}else{
			System.out.println("Cidade salva com successo!");
			Cidade cidade = new Cidade();
			cidade.setNome("Belo Horizonte");
			cidade.setEstado(estado);
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);	
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade: resultado){
			System.out.println("Contigo: "+cidade.getCodigo());
			System.out.println("Nome: "+cidade.getNome());
			System.out.println("Estado "+cidade.getEstado().getNome());
			System.out.println("Sigla: "+cidade.getEstado().getSigla());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1l;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if(cidade != null){
			System.out.println("Contigo: "+cidade.getCodigo());
			System.out.println("Nome: "+cidade.getNome());
			System.out.println("Estado "+cidade.getEstado().getNome());
			System.out.println("Sigla: "+cidade.getEstado().getSigla());
		}else{
			System.out.println("Nenhum resuldado !");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5l;
		CidadeDAO  cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if(cidade !=null){
			cidadeDAO.excluir(cidade);
			System.out.println("Cidade excluida com sucesso " + cidade.getNome());
		}else{
			System.out.println("Não foi possivel excluir");
		}	
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 7l;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade != null){
			EstadoDAO estaDAO = new EstadoDAO();
			Estado estado = estaDAO.buscar(5l);
			cidade.setNome("Esmeralda");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
			System.out.println("Cidade alterada "+cidade.getNome());
		}else{
			System.out.println("Não e possivel editar ");
		}
	}
	
	@Test
	@Ignore
	public void buscarPorEstado(){
		Long estadoCodigo = 5l;
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		
		for(Cidade cidade: resultado){
			System.out.println("Contigo: "+cidade.getCodigo());
			System.out.println("Nome: "+cidade.getNome());
			System.out.println("Estado "+cidade.getEstado().getNome());
			System.out.println("Sigla: "+cidade.getEstado().getSigla());
			
		}
	}
	

}
