package ar.com.fluxit.jqa.mock.usage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CarDAOImpl {

	DataSource getDataSource() {
		return new DataSource() {

			@Override
			public Connection getConnection() throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public Connection getConnection(String username, String password) throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public int getLoginTimeout() throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public PrintWriter getLogWriter() throws SQLException {
				throw new UnsupportedOperationException();
			}

			@SuppressWarnings("unused")
			public Logger getParentLogger() throws SQLFeatureNotSupportedException {
				return null;
			}

			@Override
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setLoginTimeout(int seconds) throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public void setLogWriter(PrintWriter out) throws SQLException {
				throw new UnsupportedOperationException();
			}

			@Override
			public <T> T unwrap(Class<T> iface) throws SQLException {
				throw new UnsupportedOperationException();
			}
		};

	}

}
