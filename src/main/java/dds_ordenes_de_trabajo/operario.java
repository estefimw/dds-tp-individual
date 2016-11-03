package dds_ordenes_de_trabajo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class operario{
	@Id @GeneratedValue
	private int idOperario;
	private String nombre;
	private String apellido;
	private Double comision;
	
	public operario(){
		
	}
	
	public operario(String nombre, String apellido, Double comision){
		this.nombre=nombre;
		this.apellido=apellido;
		this.comision=comision;
	}
	
	public void incrementarComision(){
		this.comision++;
	}
}