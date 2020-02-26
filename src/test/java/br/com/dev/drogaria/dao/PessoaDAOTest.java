package br.com.dev.drogaria.dao;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bruno Eduarto");
		pessoa.setEmail("bumbum@gmail.com");
		pessoa.setTelefone("3356-9865");
		pessoa.setCelular("999586545");
		pessoa.setCpf("64646544656");
		pessoa.setRg("mg54645646");
		pessoa.setCep("313213213");
		pessoa.setRua("maria seila");
		pessoa.setBairro("kennedy");
		pessoa.setNumero(new Short((short) 20));
		pessoaDAO.salvar(pessoa);
		System.out.println("Salvo com sucesso ");	
	}
	
	@Test
	@Ignore
	public void editar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(5l);
		
		if(pessoa != null){
			pessoa.setEmail("teste@gamil.com");
			pessoaDAO.editar(pessoa);
			System.out.println("Alterado com sucesso  ");
		}else{
			System.out.println("Nenhum registro encontrado ! ");	
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		PessoaDAO  pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(5l);
		
		if(pessoa != null){
			System.out.println("Codigo "+pessoa.getCodigo());	
			System.out.println("Nome "+pessoa.getNome());	
		}else{
			System.out.println("Nenhum registro encontrado ! ");	
		}	
	}
	
	@Test
	@Ignore
	public void listar(){
		PessoaDAO  pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		if(resultado.size() > 0){
			for(Pessoa pessoa : resultado){
				System.out.println("Codigo "+pessoa.getCodigo());	
				System.out.println("Nome "+pessoa.getNome());	
			}
		}else{
			System.out.println("Nenhum registro encontrado ! ");	
		}	
	}
	
	@Test
	@Ignore
	public void excluir(){
		PessoaDAO  pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(6l);
		
		if(pessoa != null){
			pessoaDAO.excluir(pessoa);	
			System.out.println("Excluido com sucesso");	
		}else{
			System.out.println("Nenhum registro encontrado ! ");	
		}		
	}
	

}
