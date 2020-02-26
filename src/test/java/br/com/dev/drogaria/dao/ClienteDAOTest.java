package br.com.dev.drogaria.dao;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Cliente;
import br.com.dev.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Cliente  cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1l);
		
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		clienteDAO.salvar(cliente);
		System.out.println("CLiente salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoCliente =2l;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		if(cliente != null){
			cliente.setLiberado(false);
			clienteDAO.editar(cliente);
			System.out.println("Alterado com sucesso !");
		}else{
			System.out.println("Não é porssivel altera os dados");
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoCliente = 1l;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		if(cliente != null){
			System.out.println("Cliete");
			System.out.println("Nome "+cliente.getPessoa().getNome());
			System.out.println("Status "+cliente.getLiberado());
		}else{
			System.out.println("Nenhum resultado encontrado !");
		}			
	}
	
	@Test
	@Ignore
	public void listar(){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		
		if(resultado.size() >0){
			for(Cliente cliente : resultado){
				System.out.println("Cliete");
				System.out.println("Nome "+cliente.getPessoa().getNome());
				System.out.println("Status "+cliente.getLiberado());	
			}
		}else{
			System.out.println("Nenhum resultado encontrado !");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(4l);
		
		if(cliente != null){
			clienteDAO.excluir(cliente);
			System.out.println("Excluindo com sucesso !");
		}else{
			System.out.println("Nenhum resultado encontrado !");
		}
	}

}
