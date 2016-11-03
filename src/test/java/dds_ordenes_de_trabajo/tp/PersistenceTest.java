package dds_ordenes_de_trabajo.tp;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import dds_ordenes_de_trabajo.Persistence;
import dds_ordenes_de_trabajo.cliente;
import dds_ordenes_de_trabajo.ordenDeTrabajo;
import dds_ordenes_de_trabajo.usoRepuesto;
import dds_ordenes_de_trabajo.repuesto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class PersistenceTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
	
	@Test
	public void testPersistirOrdenDeTrabajo(){

		cliente cliente =new cliente("Estefi","Imw",1523880);
		ordenDeTrabajo orden = new ordenDeTrabajo(cliente);
		repuesto mesa = new repuesto();
		usoRepuesto imputable =new usoRepuesto(500.0,"mesa", mesa);
		orden.agregarImputable(imputable);
		Persistence persist = new Persistence();

		withTransaction(() -> {
		persist.agregarOrdenDeTrabajo(orden);
		entityManager().flush();
		});
		
		withTransaction(() -> {
			entityManager().clear();
		List<ordenDeTrabajo> lista = persist.obtenerOrdenesDeTrabajo();
		Assert.assertEquals(orden.getIdOrden(),lista.get(0).getIdOrden());
		});
	}

	@Test
	public void testFindOrdenDeTrabajo(){

		cliente cliente =new cliente("Estefi","Imw",1523880);
		ordenDeTrabajo orden = new ordenDeTrabajo(cliente);
		repuesto mesa = new repuesto();
		usoRepuesto imputable =new usoRepuesto(500.0,"mesa", mesa);
		orden.agregarImputable(imputable);
		Persistence persist = new Persistence();
		withTransaction(() -> {
		persist.agregarOrdenDeTrabajo(orden);
		});
		withTransaction(() -> {
			entityManager().clear();
			ordenDeTrabajo ordenInstance = entityManager().find(orden.getClass(),orden.getIdOrden());
			Assert.assertEquals(orden.getIdOrden(), ordenInstance.getIdOrden());
			Assert.assertEquals(orden.getEstadoOrden(), ordenInstance.getEstadoOrden());
			Assert.assertEquals(orden.getFechaOrden(), ordenInstance.getFechaOrden());
			Assert.assertEquals(orden.getPrimerImputable().getId_imputable(), ordenInstance.getPrimerImputable().getId_imputable());
			Assert.assertEquals(orden.getCliente().getIdCliente(), ordenInstance.getCliente().getIdCliente());
		});
	}
	
@Test 
	public void testPersistirRepuesto(){
		repuesto mesa = new repuesto(2,"mesa");

		withTransaction(() -> {
		entityManager().persist(mesa);
		entityManager().flush();
		entityManager().clear();
		});
		
		withTransaction(()->{
			repuesto mesa2 = entityManager().find(mesa.getClass(),mesa.getIdRepuesto());
			Assert.assertEquals(mesa.getIdRepuesto(),mesa2.getIdRepuesto());
		});
	}

@Test 
public void testPersistirUsoRepuesto(){
	repuesto mesa = new repuesto(2,"mesa");
	usoRepuesto imp= new usoRepuesto(2.0,"mesa", mesa);

	withTransaction(() -> {
	entityManager().persist(imp);
	entityManager().flush();
	entityManager().clear();
	});

	withTransaction(() -> {
		usoRepuesto imp2= entityManager().find(imp.getClass(), imp.getId_imputable());
		Assert.assertEquals(imp.getId_imputable(), imp2.getId_imputable());
		});
}

@Test 
public void testPersistirCliente(){
	cliente cliente =new cliente("Estefi","Imw",1523880);
	withTransaction(() -> {
		entityManager().persist(cliente);
		entityManager().flush();
		entityManager().clear();
	});
	
	withTransaction(() -> {
		cliente cliente2= entityManager().find(cliente.getClass(), cliente.getIdCliente());
		Assert.assertEquals(cliente.getIdCliente(), cliente2.getIdCliente());
		});
}
}