/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
package ar.com.fluxit.jqa.log;

import org.apache.maven.plugin.logging.Log;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class MavenLogLoggerAdapter extends MarkerIgnoringBase {

	private static final long serialVersionUID = -3534494345007204280L;
	private final Log logger;

	public MavenLogLoggerAdapter(Log logger) {
		this.logger = logger;
	}

	@Override
	public void debug(final String _text) {
		logger.debug(_text);
	}

	@Override
	public void debug(final String _messagePattern, final Object _arg) {
		logger.debug(MessageFormatter.format(_messagePattern, _arg).getMessage());
	}

	@Override
	public void debug(final String _messagePattern, final Object _arg1, final Object _arg2) {
		logger.debug(MessageFormatter.format(_messagePattern, _arg1, _arg2).getMessage());
	}

	@Override
	public void debug(final String _messagePattern, final Object[] _args) {
		logger.debug(MessageFormatter.arrayFormat(_messagePattern, _args).getMessage());
	}

	@Override
	public void debug(final String _text, final Throwable _e) {
		logger.debug(_text, _e);
	}

	@Override
	public void error(final String _text) {
		logger.error(_text);
	}

	@Override
	public void error(final String _messagePattern, final Object _arg) {
		logger.error(MessageFormatter.format(_messagePattern, _arg).getMessage());
	}

	@Override
	public void error(final String _messagePattern, final Object _arg1, final Object _arg2) {
		logger.error(MessageFormatter.format(_messagePattern, _arg1, _arg2).getMessage());
	}

	@Override
	public void error(final String _messagePattern, final Object[] _args) {
		logger.error(MessageFormatter.arrayFormat(_messagePattern, _args).getMessage());
	}

	@Override
	public void error(final String _text, final Throwable _e) {
		logger.error(_text, _e);
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public void info(final String _text) {
		logger.info(_text);
	}

	@Override
	public void info(final String _messagePattern, final Object _arg) {
		logger.info(MessageFormatter.format(_messagePattern, _arg).getMessage());
	}

	@Override
	public void info(final String _messagePattern, final Object _arg1, final Object _arg2) {
		logger.info(MessageFormatter.format(_messagePattern, _arg1, _arg2).getMessage());
	}

	@Override
	public void info(final String _messagePattern, final Object[] _args) {
		logger.info(MessageFormatter.arrayFormat(_messagePattern, _args).getMessage());
	}

	@Override
	public void info(final String _text, final Throwable _e) {
		logger.info(_text, _e);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public void trace(final String _text) {
		logger.debug(_text);
	}

	@Override
	public void trace(final String _messagePattern, final Object _arg) {
		logger.debug(MessageFormatter.format(_messagePattern, _arg).getMessage());
	}

	@Override
	public void trace(final String _messagePattern, final Object _arg1, final Object _arg2) {
		logger.debug(MessageFormatter.format(_messagePattern, _arg1, _arg2).getMessage());
	}

	@Override
	public void trace(final String _messagePattern, final Object[] _args) {
		logger.debug(MessageFormatter.arrayFormat(_messagePattern, _args).getMessage());
	}

	@Override
	public void trace(final String _text, final Throwable _e) {
		logger.debug(_text, _e);
	}

	@Override
	public void warn(final String _text) {
		logger.warn(_text);
	}

	@Override
	public void warn(final String _messagePattern, final Object _arg) {
		logger.warn(MessageFormatter.format(_messagePattern, _arg).getMessage());
	}

	@Override
	public void warn(final String _messagePattern, final Object _arg1, final Object _arg2) {
		logger.warn(MessageFormatter.format(_messagePattern, _arg1, _arg2).getMessage());
	}

	@Override
	public void warn(final String _messagePattern, final Object[] _args) {
		logger.warn(MessageFormatter.arrayFormat(_messagePattern, _args).getMessage());
	}

	@Override
	public void warn(final String _text, final Throwable _e) {
		logger.warn(_text, _e);
	}
}
