package model.entidad.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Tipos;
import model.entidad.dao.mapper.AccidentesMapper;

public class AccidenteDAO implements AccidentesMapper{
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AccidenteDAO.class);

	public ArrayList<Accidente> busquedaGeneral() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaGeneral();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Tipos TipoPorId(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.TipoPorId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Tipos t = new Tipos();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Accidente getAccidente(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getAccidente(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Accidente t = new Accidente();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Distritos distritoPorId(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.distritoPorId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Distritos t = new Distritos();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Estadisticas> getEstadisticas() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getEstadisticas();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Estadisticas> uArr = new ArrayList<Estadisticas>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaAccidente(tipo, fecha);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Tipos> getTipos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getTipos();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Tipos> t = new ArrayList<Tipos>();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaAccidenteDespues(tipo, fecha);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}
}
