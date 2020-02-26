package br.com.dev.drogaria.dao;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dev.drogaria.domain.Pessoa;
import br.com.dev.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3l);
		if(pessoa != null){
			String senha = "123456";
			Usuario usuario = new Usuario();
			usuario.setSenha(senha);
			usuario.setAtivo(true);
			usuario.setTipo('A');
			usuario.setPessoa(pessoa);
			usuarioDAO.salvar(usuario);
			System.out.println("Salvo com sucesso !");
		}else{
			System.out.println("Impossivel salvar");
		}	
	}
	
	@Test
	@Ignore
	public void editar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1l);
		if(usuario != null){
			usuario.setTipo('U');
			usuarioDAO.editar(usuario);
			System.out.println("Alterado com sucesso !");
		}else{
			System.out.println("Nenhum restro encontrado!");
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1l);
		
		if(usuario != null){
			System.out.println("Usuario");
			System.out.println("Usuario " + usuario.getPessoa().getNome());
			System.out.println("Tipo " + usuario.getTipo());	
		}else{
			System.out.println("Nenhum resgistro encontrado !");
		}	
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		
		if(resultado.size() >0 ){
			for(Usuario usuario : resultado){
				System.out.println("Usuario!");
				System.out.println("Usuario " + usuario.getPessoa().getNome());
				System.out.println("Tipo " + usuario.getTipo());	
				System.out.println("Nenhum restro encontrado!");
			}
		}else{
			System.out.println("Nenhum restro encontrado!");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(2l);
		
		if(usuario != null){
			usuarioDAO.excluir(usuario);
			System.out.println("Excluindo com sucesso !");
		}else{
			System.out.println("Nenhum restro encontrado!");
		}	
	}
	

}
