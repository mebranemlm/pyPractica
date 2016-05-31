package DAO.Local;

import java.util.List;

import model.jpa.Transporte;

public interface TransporteDAOLocal {
	public abstract Transporte buscarTransporte(Transporte obj) throws Exception;
	public abstract void agregarTransporte(Transporte obj) throws Exception;
	public abstract void editarTransporte(Transporte obj) throws Exception;
	public abstract void eliminarTransporte(Transporte obj) throws Exception;
	public abstract List<Transporte> buscarListaTransporte(Transporte obj) throws Exception;
}
