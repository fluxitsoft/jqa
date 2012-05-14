/*______________________________________________________________________________
 *
 * Macker   http://innig.net/macker/
 *
 * Copyright 2002-2003 Paul Cantrell
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2, as published by the
 * Free Software Foundation. See the file LICENSE.html for more information.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, including the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the license for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc. / 59 Temple
 * Place, Suite 330 / Boston, MA 02111-1307 / USA.
 *______________________________________________________________________________
 */

package ar.com.fluxit.jqa.bce.bcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BasicType;
import org.apache.bcel.generic.ObjectType;

/**
 * @author Paul Cantrell
 */
final class ClassNameTranslator {

	private static Pattern classSuffixRE;

	private static Pattern arrayExtractorRE;

	private static Pattern sigExtractorRE;

	private static Pattern legalJavaIdentRE;

	private static Map<String, String> primitiveTypeMap;
	private static Map<String, JavaClass> primitiveClassMap;

	static {
		classSuffixRE = Pattern.compile("\\.class$");
		arrayExtractorRE = Pattern.compile("^(\\[+([BSIJCFDZV])|\\[+L([^;]*);)$");
		sigExtractorRE = Pattern.compile("^\\(?\\)?(\\[*([BSIJCFDZV])|\\[*L([^;]*);)");
		final String javaIdent = "[\\p{Alpha}$_][\\p{Alnum}$_]*";
		legalJavaIdentRE = Pattern.compile("^(" + javaIdent + ")(\\.(" + javaIdent + "))*$");

		primitiveTypeMap = new HashMap<String, String>();
		primitiveTypeMap.put("B", "byte");
		primitiveTypeMap.put("S", "short");
		primitiveTypeMap.put("I", "int");
		primitiveTypeMap.put("J", "long");
		primitiveTypeMap.put("C", "char");
		primitiveTypeMap.put("F", "float");
		primitiveTypeMap.put("D", "double");
		primitiveTypeMap.put("Z", "boolean");
		primitiveTypeMap.put("V", "void");

		try {
			primitiveClassMap = new HashMap<String, JavaClass>();
			primitiveClassMap.put("byte", Repository.lookupClass(Byte.class));
			primitiveClassMap.put("short", Repository.lookupClass(Short.class));
			primitiveClassMap.put("int", Repository.lookupClass(Integer.class));
			primitiveClassMap.put("long", Repository.lookupClass(Long.class));
			primitiveClassMap.put("char", Repository.lookupClass(Character.class));
			primitiveClassMap.put("float", Repository.lookupClass(Float.class));
			primitiveClassMap.put("double", Repository.lookupClass(Double.class));
			primitiveClassMap.put("boolean", Repository.lookupClass(Boolean.class));
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

	public static String classToResourceName(final String resourceName) {
		return (resourceName.replace('.', '/') + ".class").intern();
	}

	public static String getClassName(org.apache.bcel.generic.Type type) {
		String signatureClassName;
		if (type instanceof BasicType) {
			signatureClassName = Constants.CLASS_TYPE_NAMES[type.getType()];
		} else if (type instanceof ObjectType) {
			signatureClassName = ((ObjectType) type).getClassName();
		} else {
			signatureClassName = getClassName(((ArrayType) type).getBasicType());
		}
		return signatureClassName;
	}

	public static JavaClass getPrimitive(String className) {
		return primitiveClassMap.get(className);
	}

	public static boolean isJavaIdentifier(final String className) {
		return legalJavaIdentRE.matcher(className).matches();
	}

	public static String resourceToClassName(final String className) {
		return classSuffixRE.matcher(className).replaceAll("").replace('/', '.').intern();
	}

	public static List<String> signatureToClassNames(final String signature) {
		final List<String> names = new ArrayList<String>();
		for (int pos = 0; pos < signature.length();) {
			final String remaining = signature.substring(pos);
			final Matcher sigMatcher = sigExtractorRE.matcher(remaining);
			if (!sigMatcher.find()) {
				throw new IllegalArgumentException("Unable to extract type info from: " + remaining);
			}
			if (sigMatcher.group(2) != null) {
				names.add(primitiveTypeMap.get(sigMatcher.group(2)));
			}
			if (sigMatcher.group(3) != null) {
				names.add(resourceToClassName(sigMatcher.group(3)));
			}
			pos += sigMatcher.end();
		}
		return names;
	}

	public static List<String> signatureToClassNames2(String signature) {
		List<String> result = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<([^>]*)>");
		Matcher matcher = pattern.matcher(signature.replace("*", "").replace("T:", ""));
		if (matcher.find()) {
			int size = matcher.groupCount();
			for (int i = 1; i <= size; i++) {
				String typeNames = matcher.group(i);
				if (!typeNames.isEmpty()) {
					result.addAll(signatureToClassNames(typeNames));
				}
			}
		}
		return result;
	}

	public static String typeConstantToClassName(final String typeName) {
		final Matcher arrayMatcher = arrayExtractorRE.matcher(typeName);
		if (arrayMatcher.matches()) {
			if (arrayMatcher.group(2) != null) {
				return primitiveTypeMap.get(arrayMatcher.group(2));
			}
			if (arrayMatcher.group(3) != null) {
				return resourceToClassName(arrayMatcher.group(3));
			}
		}
		return resourceToClassName(typeName);
	}

	/**
	 * Private constructor for utility class.
	 */
	private ClassNameTranslator() {

	}
}
