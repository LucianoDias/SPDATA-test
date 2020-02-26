package br.com.dev.drogaria.dao;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricante.setDescricao("Samsung");
		fabricanteDAO.salvar(fabricante);
		System.out.println("Fabricante salvo com sucesso");		
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		if(resultado.size() >0){
			for(Fabricante fabricante : resultado){
				System.out.println("Codigo  "+fabricante.getCodigo());
				System.out.println("Nome "+fabricante.getDescricao());	
			}
		}else{
			System.out.println("Nenhum resultado ");
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2l;
		FabricanteDAO fabricanteDAO = new  FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante != null){
			System.out.println("Codigo "+fabricante.getCodigo());
			System.out.println("Descrição "+fabricante.getDescricao());
		}else{
			System.out.println("Nenhum registro encontrado!");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5l;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante != null){
			fabricanteDAO.excluir(fabricante);
			System.out.println("Excluindo com sucesso !");
		}else{
			System.out.println("Não foi possivel excluir o fabricante");
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2l;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante != null){
			fabricante.setDescricao("Lg eletronic");
			fabricanteDAO.editar(fabricante);
			System.out.println("Alterando com sucesso !");
		}else{
			System.out.println("Não foi possivel editar o fabricante");
		}
	}
	
	
	
	@Test
	@Ignore
	public void merge(){
		//Fabricante fabricante = new Fabricante();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(4l);
		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);
		System.out.println("Fabricante salvo com sucesso");		
		
	}
	
	

}
