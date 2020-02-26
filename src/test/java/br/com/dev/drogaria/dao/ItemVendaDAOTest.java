package br.com.dev.drogaria.dao;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Funcionario;
import br.com.dev.drogaria.domain.ItemVenda;
import br.com.dev.drogaria.domain.Produto;

public class ItemVendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);
		ItemVenda itemVenda = new ItemVenda();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2l);
		
		if(produto !=null && funcionario != null ){
			itemVenda.setProduto(produto);
			itemVenda.setPrecoParcial(new BigDecimal(500.00));
			itemVenda.setQuantidade(new Short((short) 10));
			itemVenda.setFuncionario(funcionario);
			itemVendaDAO.salvar(itemVenda);
			System.out.println("Salvo com sucesso ");
		}else{
		System.out.println("Produto não encontrado");
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);
		ItemVenda itemVenda = new ItemVenda();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1l);
		
		if(produto !=null && funcionario != null ){
			itemVenda.setProduto(produto);
			itemVenda.setPrecoParcial(new BigDecimal(300.00));
			itemVenda.setQuantidade(new Short((short) 20));
			itemVenda.setFuncionario(funcionario);
			itemVenda.setCodigo(1l);
			itemVendaDAO.editar(itemVenda);
			System.out.println("Alterado com sucesso ");
		}else{
		System.out.println("Produto não encontrado");
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(1l);
		
		if(itemVenda != null){
			System.out.println(" Imtem ");
			System.out.println(" Codigo "+itemVenda.getCodigo());
			System.out.println(" Nome "+itemVenda.getProduto().getDescricao());
		}else{
			System.out.println(" Registro não encontrado ");
		}	
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemVendaDAO.listar();
		
		if(resultado.size() > 0){
			for(ItemVenda itemVenda : resultado){
				System.out.println(" Imtem ");
				System.out.println(" Codigo "+itemVenda.getCodigo());
				System.out.println(" Nome "+itemVenda.getProduto().getDescricao());
			}
		}else{
			System.out.println(" Registro não encontrado ");
		}	
	}
	
	@Test
	public void excluir(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(5l);
		
		if(itemVenda != null){
			itemVendaDAO.excluir(itemVenda);
			System.out.println(" Excluido com sucesso ");
		}else{
			System.out.println(" Registro não encontrado ");
		}	
	}

}
