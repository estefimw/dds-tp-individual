package dds_ordenes_de_trabajo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class repuesto{
	@Id @GeneratedValue
	private int idRepuesto;
	private Integer stock;
	private String descripcion;
	
	public repuesto(){
		
	}
	
	public repuesto(Integer stock, String descrip){
		this.stock=stock;
		this.descripcion=descrip;
	}
	
	public void descontarStock(){
			this.stock--;
	}

	public int getIdRepuesto() {
		return idRepuesto;
	}

	public void setIdRepuesto(int idRepuesto) {
		this.idRepuesto = idRepuesto;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}