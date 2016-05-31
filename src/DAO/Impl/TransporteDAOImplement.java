package DAO.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import utilitario.Conexion;

import model.jpa.Transporte;
import DAO.Local.TransporteDAOLocal;

public class TransporteDAOImplement implements TransporteDAOLocal {

	Conexion cn = new Conexion();

	
	@Override
	public Transporte buscarTransporte(Transporte obj) throws Exception {
		cn.abrir();
		Transporte oTransporte = new Transporte();
		
		try {
			
			oTransporte=cn.em.find(Transporte.class, obj.getIdTransporte());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return oTransporte;
	}

	@Override
	public void agregarTransporte(Transporte obj) throws Exception {
		cn.abrir();
		cn.em.getTransaction().begin();
		Transporte oTransporte= new Transporte();
		try {
			oTransporte.setIdTransporte(obj.getIdTransporte());
			oTransporte.setIdTipoTransporte(obj.getIdTipoTransporte());
			oTransporte.setDescTransporte(obj.getDescTransporte());
			oTransporte.setStock(obj.getStock());
			oTransporte.setCosto(obj.getCosto());
			oTransporte.setIdMarca(obj.getIdMarca());
			oTransporte.setIdModelo(obj.getIdModelo());
			oTransporte.setFechaRegistro(obj.getFechaRegistro());
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public void editarTransporte(Transporte obj) throws Exception {
		cn.abrir();
		cn.em.getTransaction().begin();
		Transporte oTransporte= new Transporte();
		try {
			oTransporte.setIdTransporte(obj.getIdTransporte());
			oTransporte.setIdTipoTransporte(obj.getIdTipoTransporte());
			oTransporte.setDescTransporte(obj.getDescTransporte());
			oTransporte.setStock(obj.getStock());
			oTransporte.setCosto(obj.getCosto());
			oTransporte.setIdMarca(obj.getIdMarca());
			oTransporte.setIdModelo(obj.getIdModelo());
			oTransporte.setFechaRegistro(obj.getFechaRegistro());
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public void eliminarTransporte(Transporte obj) throws Exception {
		cn.abrir();
		Transporte oTransporte= new Transporte();
		try {
			oTransporte=cn.em.find(Transporte.class, obj.getIdTransporte());
			cn.em.getTransaction().begin();
			cn.em.remove(oTransporte);
			//Query q= cn.em.createQuery("delete a from Transporte a  where a.descTransporte ");
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public List<Transporte> buscarListaTransporte(Transporte obj) throws Exception {
		List<Transporte> lista=null;
		try {
			Query q = cn.em.createQuery("select t from Transporte t where t.descTransporte like :p1 and t.idMarca = :p2");
			q.setParameter("p1",'%'+obj.getDescTransporte()+'%' );
			q.setParameter("p2", obj.getIdMarca());
			lista=q.getResultList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista;
	}

	
}
