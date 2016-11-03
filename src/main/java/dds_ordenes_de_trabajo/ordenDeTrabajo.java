package dds_ordenes_de_trabajo;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.LinkedList;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateConverter;
import java.time.LocalDate;

@Entity
public class ordenDeTrabajo{
	
	@Id @GeneratedValue
	private int idOrden;
	private EstadoOrden estadoOrden = EstadoOrden.Creada;
	@Convert(converter = LocalDateConverter.class)
	private LocalDate fechaOrden;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<imputable> imputables ;
	@OneToOne(cascade=CascadeType.PERSIST)
	private cliente cliente;
	
	public ordenDeTrabajo(){
		
	}
	
	public ordenDeTrabajo(cliente cliente){
		this.fechaOrden= LocalDate.now();
		this.cliente=cliente;
		this.imputables=new LinkedList<imputable>();
	}
	
	public void agregarImputable(imputable imput){
		this.imputables.add(imput);
	}
	
	public imputable getPrimerImputable(){
		return this.imputables.get(0);
	}
	
	public void pagar(){
		
	}
	
	public Double getMontoTotal(){
		Double montoTotal =imputables.stream().mapToDouble(imputable-> imputable.getMonto()).sum();
		//Double montoTotal =0.0;
		return montoTotal;
	}
	
	public void comenzarTrabajo(){
		this.estadoOrden=EstadoOrden.EnCurso;
	}
	
	public void chequearTermino(){//cambiar foreach imputable -> imputable.terminado ==true
		
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public EstadoOrden getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(EstadoOrden estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public List<imputable> getImputables() {
		return imputables;
	}

	public void setImputables(List<imputable> imputables) {
		this.imputables = imputables;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
}
