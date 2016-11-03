package dds_ordenes_de_trabajo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class cliente{
	
	@Id @GeneratedValue
	protected int idCliente;
	protected String nombreCliente;
	protected String apellidoCliente;
	protected int patenteCliente;
	
	public cliente(){
		
	}
	
	public cliente(String nombre, String apellido, int patente){
		this.nombreCliente= nombre;
		this.apellidoCliente=apellido;
		this.patenteCliente=patente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getPatenteCliente() {
		return patenteCliente;
	}

	public void setPatenteCliente(int patenteCliente) {
		this.patenteCliente = patenteCliente;
	}
	
}