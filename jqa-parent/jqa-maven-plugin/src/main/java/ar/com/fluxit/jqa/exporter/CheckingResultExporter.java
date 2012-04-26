/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.exporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;

import ar.com.fluxit.jqa.result.CheckingResult;

import com.thoughtworks.xstream.XStream;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CheckingResultExporter {

	public static CheckingResultExporter INSTANCE = new CheckingResultExporter();

	private CheckingResultExporter() {
	}

	public void export(CheckingResult checkingResult, String projectName, File exportDir, File xsltFile, Logger logger) throws ExporterException {
		// Writes the results in XML
		final File xmlFile = new File(exportDir, "results-" + projectName + ".xml");
		logger.debug("Writing the results on " + xmlFile);
		Writer out = null;
		try {
			final Writer w = new FileWriter(xmlFile);
			out = new BufferedWriter(w);
			final XStream xs = new XStream();
			xs.setMode(XStream.NO_REFERENCES);
			xs.toXML(checkingResult, out);

			// Writes the results in HTML
			logger.debug("Writing the results on " + xmlFile);
			final File htmlFile = new File(exportDir, "results-" + projectName + ".html");
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source source;
			if (xsltFile != null) {
				source = new StreamSource(xsltFile);
			} else {
				source = new StreamSource(getDefaultTransformer());
			}
			Transformer transformer = transformerFactory.newTransformer(source);
			Result result = new StreamResult(htmlFile);
			transformer.transform(new StreamSource(xmlFile), result);
		} catch (Exception e) {
			throw new ExporterException("An error has occured while exporting to the checking result to HTML", e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				logger.error("An error has occured while exporting to the checking result to HTML", e);
			}
		}
	}

	private InputStream getDefaultTransformer() {
		return getClass().getResourceAsStream("/defaultTransformer.xsl");
	}
}
