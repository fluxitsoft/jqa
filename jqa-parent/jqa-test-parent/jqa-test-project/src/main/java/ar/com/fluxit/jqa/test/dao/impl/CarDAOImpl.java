/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.test.dao.impl;

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
