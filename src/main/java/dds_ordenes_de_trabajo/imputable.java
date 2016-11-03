package dds_ordenes_de_trabajo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class imputable {
	
	@Id@GeneratedValue
	private int id_imputable;
	private Double monto;
	private String descripcion;
	private Boolean terminado=false;
	
	public imputable(){
	}
	
	public imputable(Double monto, String descripcion){
		this.monto=monto;
		this.descripcion=descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}
	
	public Boolean getTerminado(){
		return this.terminado;
	}
	
	public Double getMonto(){
		return this.monto;
	}
	
	public void terminar(){
		
	}
	
	public void setTerminado(Boolean valor){
		this.terminado=valor;		
	}

	public int getId_imputable() {
		return id_imputable;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
