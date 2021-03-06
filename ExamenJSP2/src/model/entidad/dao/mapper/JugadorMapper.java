package model.entidad.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.Jugador;

public interface JugadorMapper {
	public ArrayList<Jugador> busquedaGeneral();
	public Jugador buscarJugador(@Param("id") Integer id);
	public void borrarJugador(@Param("id") int id);

}
