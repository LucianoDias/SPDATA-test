package br.com.dev.drogaria.dao;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Funcionario;
import br.com.dev.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(4l);
		if(pessoa !=null){
			funcionario.setPessoa(pessoa);
			funcionario.setCarteiraTrabalho("21415454545");
			funcionario.setDataAdmissao(new Date());
			funcionarioDAO.salvar(funcionario);
			System.out.println("Salvo com sucesso !");
		}else{
			System.out.println("Nenhuma pessoa encontrada !");
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);
		
		if(funcionario != null){
			funcionario.setCarteiraTrabalho("555555555555");
			funcionarioDAO.editar(funcionario);
			System.out.println("Alterado com sucesso !");
		}else{
			System.out.println("Nenhuma registro encontrado !");
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);
		
		if(funcionario != null){
			System.out.println("Funcionario ");
			System.out.println("Nome "+funcionario.getPessoa().getNome());
		}else{
			System.out.println("Nenhuma funcionario encontrada !");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		
		if(resultado.size() > 0){
			for(Funcionario funcionario : resultado){
				System.out.println("Funcionario ");
				System.out.println("Nome "+funcionario.getPessoa().getNome());
			}	
		}else{
			System.out.println("Nenhuma Funcionario encontrada !");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(4l);
		
		if(funcionario != null){
			funcionarioDAO.excluir(funcionario);
			System.out.println("Excluindo com sucesso");
		}else{
			System.out.println("Não foi possivel excluir !");
		}	
	}
	
	

}
