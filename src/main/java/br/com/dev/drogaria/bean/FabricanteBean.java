package br.com.dev.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dev.drogaria.dao.FabricanteDAO;
import br.com.dev.drogaria.domain.Fabricante;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante(){
		return fabricante;
	}
    public void setFabricante(Fabricante fabricante){
    	this.fabricante = fabricante;
    }
    public List<Fabricante> getFabricantes(){
    	return fabricantes;
    }
    public void setFabricantes(List<Fabricante> fabricantes){
    	this.fabricantes = fabricantes;
    }
    
    @PostConstruct
	public void listar(){
		try{
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao listar os fabricantes");
			erro.printStackTrace();
		}
	}
    
    public void novo(){
		fabricante = new Fabricante();
	}
	
	public void salvar(){
		
		try{
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);
			novo();
			fabricantes = fabricanteDAO.listar();
			Messages.addGlobalInfo("Salvo com sucesso");
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao salvar o estado");
			erro.printStackTrace();
		}	
	}
	
	public void excluir(ActionEvent evento){
		try{
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			fabricantes = fabricanteDAO.listar();
			Messages.addGlobalInfo("Fabricante removido com sucesso");
			
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao excluir o fabricante");
			erro.printStackTrace();
		}	
	}
	
	public void editar(ActionEvent evento){
		
		try{
			fabricante =  (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao editar o estado");
			erro.printStackTrace();
		}	
	}

}
