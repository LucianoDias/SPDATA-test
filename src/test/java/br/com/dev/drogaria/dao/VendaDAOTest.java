package br.com.dev.drogaria.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Cliente;
import br.com.dev.drogaria.domain.Funcionario;
import br.com.dev.drogaria.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		VendaDAO vendaDAO = new VendaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(12l);
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1l);
		
		if(cliente != null && funcionario != null){
			Venda venda = new Venda();
			venda.setCliente(cliente);
			venda.setHorario(new Date());
			venda.setPrecoTotal(new BigDecimal(200.30));
			venda.setFuncionario(funcionario);
			vendaDAO.salvar(venda);
			System.out.println("Venda realizada com sucesso");
		}else{
			System.out.println("Venda não foi possivel");
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1l);
		
		if(venda != null){
			venda.setPrecoTotal(new BigDecimal(4000.30));
			vendaDAO.editar(venda);
			System.out.println("Alterada com sucesso ");
		}else{
			System.out.println("Nenhum registro encontrado");
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1l);
		if(venda != null){
			System.out.println("Venda ");
			System.out.println("Codigo "+venda.getCodigo());
			System.out.println("Valor "+venda.getPrecoTotal());
		}else{
			System.out.println("Nenhum registro encontrado");
		}
		
	}
	
   @Test
   @Ignore
	public void listar(){
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();
		
		if(resultado.size() > 0){
			for(Venda venda : resultado){
				System.out.println("Venda ");
				System.out.println("Codigo "+venda.getCodigo());
				System.out.println("Valor "+venda.getPrecoTotal());
			}		
		}else{
			System.out.println("Nenhum registro encontrado");
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(2l);
		
		if(venda != null){
			vendaDAO.excluir(venda);
			System.out.println("Excluido com sucesso");
		}else{
			System.out.println("Nenhum registro encontrado");
		}	
	}

}
