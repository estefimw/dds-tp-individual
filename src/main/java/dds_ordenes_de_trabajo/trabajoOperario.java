package dds_ordenes_de_trabajo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class trabajoOperario extends imputable{
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private operario operario;
	
	public trabajoOperario(){
		super();
	}
	
	public trabajoOperario(Double monto, String descripcion, operario operario){
		super(monto, descripcion);		
		this.operario=operario;
	}
	
	public void terminar(){
		operario.incrementarComision();
		this.setTerminado(true);
	}
}