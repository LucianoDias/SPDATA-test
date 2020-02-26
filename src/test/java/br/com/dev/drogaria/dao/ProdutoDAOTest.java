package br.com.dev.drogaria.dao;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.dev.drogaria.domain.Fabricante;
import br.com.dev.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigoFabricante = 2l;
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		produto.setDescricao("TV 60 polegada");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("1885.80"));
		produto.setQuantidade(new Short("12"));
		
		produtoDAO.salvar(produto);
		System.out.println("Salvo com sucesso !");
	}
	
	@Test
	@Ignore
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Produto produto = produtoDAO.buscar(2l);
		Fabricante fabricante = fabricanteDAO.buscar(2l);
		
		if(produto !=null && fabricante !=null){
			produto.setDescricao("Tv 60 polegada led");
			produto.setPreco(new BigDecimal("1699.99"));
			produtoDAO.editar(produto);
			System.out.println("Alterando com sucesso ");
		}else{
			System.out.println("Não foi possivel edita o produto");
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoProduto = 1l;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if(produto != null){
			System.out.println("Codigo "+ produto.getCodigo());
			System.out.println("Descrição "+ produto.getDescricao());
			System.out.println("Valor "+ produto.getPreco());
			System.out.println("Quantidade "+ produto.getQuantidade());
			System.out.println("Fabricante "+ produto.getFabricante().getDescricao());
		}else{
			System.out.println("Nenhum produto encontrado !");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		if(resultado.size() >0){
			for(Produto produto : resultado){
				System.out.println("Codigo "+produto.getCodigo());
				System.out.println("Descrição "+produto.getDescricao());
				System.out.println("Valor "+produto.getPreco());
				System.out.println("Quantidade "+produto.getQuantidade());
			}
		}else{
			System.out.println("Nenhum resultado encontrado !");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoProduto = 3l;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if(produto !=null){
			produtoDAO.excluir(produto);
			System.out.println("Excluindo com sucesso ! ");
		}else{
			System.out.println("Não foi possivel excluir ");
		}
	}

}
