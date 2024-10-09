package com.api.agendafacil.models;

/*classe modelo para o banco de dados
 *é ela que define o formato do banco de dados
 *com ela é possivel adicionar ou remover colunas de informações a
 *serem escritas no banco de dados
*/

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * Cria uma classe de UBS que recebe um endereco,
 *  e opcionalmente cronograma e agendamento
 * 
 * @author Allan
 * @author Alcielma
 * @author Pedro
 */
@Entity
public class UBS implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ubs_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 200)
	private String imagemUBS;
	@Column(nullable = false, length = 200)
	private String nomeUBS;
	//cada UBS tem uma relação de 1 para 1 com um endereço
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;
	//guarda uma lista de cronogramas, que dizem quais dias da 
	//semana aquela UBS atende
	@OneToMany(mappedBy = "ubs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cronograma> cronograma;
    @OneToMany(mappedBy = "ubs", cascade = CascadeType.ALL)
    private List<Agendamento> agendamento;
	
    //construtores
    public UBS(String imagemUBS, String nomeUBS, Endereco endereco) {
    	this.imagemUBS = imagemUBS;
    	this.nomeUBS = nomeUBS;
    	this.endereco = endereco;
    }
    
    public UBS() {
    	
    }
    
	//getters e setters
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getImagemUBS() {
		return imagemUBS;
	}
	public void setImagemUBS(String imagemUBS) {
		this.imagemUBS = imagemUBS;
	}
	public String getNomeUBS() {
		return nomeUBS;
	}
	public void setNomeUBS(String nomeUBS) {
		this.nomeUBS = nomeUBS;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Agendamento> getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}
	public List<Cronograma> getCronograma() {
		return cronograma;
	}
	public void setCronograma(List<Cronograma> cronograma) {
		this.cronograma = cronograma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
