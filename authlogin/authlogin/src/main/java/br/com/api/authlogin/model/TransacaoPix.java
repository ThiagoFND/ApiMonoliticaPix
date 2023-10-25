package br.com.api.authlogin.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacaopix")
public class TransacaoPix {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User usuario;

	private String tipo;
	private BigDecimal valor;
	private Date data;

	public TransacaoPix() {
		super();
	}

	public TransacaoPix(String id, User usuario, String tipo, BigDecimal valor, Date data) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, tipo, usuario, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoPix other = (TransacaoPix) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valor, other.valor);
	}

}
