package br.com.dev.drogaria.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dev.drogaria.dao.EstadoDAO;
import br.com.dev.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean  implements Serializable{
	private Estado estado;
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void listar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		estado= new Estado();
	}
	
	public void salvar(){
		
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			novo();
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Salvo com sucesso");
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao salvar o estado");
			erro.printStackTrace();
		}	
	}
	
	public void excluir(ActionEvent evento){
		try{
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Estado removido com sucesso");
			
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao excluir o estado");
			erro.printStackTrace();
		}	
	}
	
	public void editar(ActionEvent evento){
		
		try{
			estado =  (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	
		}catch( RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao editar o estado");
			erro.printStackTrace();
		}	
		
	}
	

}
