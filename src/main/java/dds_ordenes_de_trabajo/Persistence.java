package dds_ordenes_de_trabajo;

import java.util.List;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;


public class Persistence implements  WithGlobalEntityManager{
	
	public Persistence(){
	}
	
	public void agregarOrdenDeTrabajo(ordenDeTrabajo orden){
		entityManager().persist(orden);
	}
	
	public List<ordenDeTrabajo> obtenerOrdenesDeTrabajo() {
		return (List<ordenDeTrabajo>) entityManager().createQuery("FROM ordenDeTrabajo").getResultList();
	}
	
	
	
}