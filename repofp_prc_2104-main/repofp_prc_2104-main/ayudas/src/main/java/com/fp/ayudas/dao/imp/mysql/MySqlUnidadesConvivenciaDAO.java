package com.fp.ayudas.dao.imp.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fp.ayudas.dao.GenericDAO;
import com.fp.ayudas.dao.IUnidadesConvivenciaDAO;
import com.fp.ayudas.modelo.IUnidadesConvivencia;
import com.fp.ayudas.modelo.imp.UnidadesConvivencia;

public class MySqlUnidadesConvivenciaDAO extends GenericDAO<IUnidadesConvivencia> implements IUnidadesConvivenciaDAO {

	private static final Logger logger = LoggerFactory.getLogger(MySqlUnidadesConvivenciaDAO.class);

	private static final String SQL = "Select * from unidad_convivencia"; //$NON-NLS-1$
	private static final String C_ID_UC = "id_uc"; //$NON-NLS-1$
	private static final String C_NOMBRE = "nombre"; //$NON-NLS-1$

	@Override
	public List<IUnidadesConvivencia> find(IUnidadesConvivencia criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(IUnidadesConvivencia val) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(IUnidadesConvivencia val) {
		// TODO Auto-generated method stub

	}

	@Override
	public IUnidadesConvivencia getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IUnidadesConvivencia> getAll() {

		List<IUnidadesConvivencia> resultado = new ArrayList<IUnidadesConvivencia>();

		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		IUnidadesConvivencia uc = null;

		try {
			conn = getConnection();
			preparedStatement = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						"fila id: " + resultSet.getString(C_ID_UC) + " nombre: " + resultSet.getString(C_NOMBRE)); //$NON-NLS-1$ //$NON-NLS-2$

				logger.debug("fila id: " + resultSet.getString(C_ID_UC) + " nombre: " + resultSet.getString(C_NOMBRE)); //$NON-NLS-1$ //$NON-NLS-2$

				uc = new UnidadesConvivencia(); // Ligamos a modelo, podria hacer un DTO implmente interfaz

				uc.setID(resultSet.getLong(C_ID_UC));
				uc.setNombre(resultSet.getString(C_NOMBRE));

				resultado.add(uc);

			}

		} catch (SQLException e) {
			System.err.format(Messages.getString("MySqlUnidadesConvivenciaDAO.7"), e.getSQLState(), e.getMessage()); //$NON-NLS-1$

			logger.error("SQL State: %s\n%s", e.getSQLState(), e.getMessage()); //$NON-NLS-1$

			closeAll(preparedStatement, resultSet, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Messages.getString("MySqlUnidadesConvivenciaDAO.0"), e); //$NON-NLS-1$
			closeAll(preparedStatement, resultSet, conn);
		} finally {
			closeAll(preparedStatement, resultSet, conn);
		}

		return resultado;

	}
}
