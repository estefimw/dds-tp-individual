package dds_ordenes_de_trabajo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class usoRepuesto extends imputable{
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private repuesto repuesto;
	
	public usoRepuesto(){
		super();
	}
	
	public usoRepuesto(Double monto, String descripcion, repuesto repuesto){
		super(monto, descripcion);
		this.repuesto=repuesto;
	}
	
	public void terminar(){
		repuesto.descontarStock();
		this.setTerminado(true);
	}
}
	
	
	