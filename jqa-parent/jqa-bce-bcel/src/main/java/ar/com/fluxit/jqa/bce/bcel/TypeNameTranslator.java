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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BasicType;
import org.apache.bcel.generic.ObjectType;

/**
 * @author Paul Cantrell
 */
final class TypeNameTranslator {

	private static Pattern classSuffixRE;
	private static Pattern arrayExtractorRE;
	private static Pattern sigExtractorRE;
	private static Map<String, String> primitiveTypeMap;
	private static Map<String, JavaClass> primitiveClassMap;

	static {
		classSuffixRE = Pattern.compile("\\.class$");
		arrayExtractorRE = Pattern.compile("^(\\[+([BSIJCFDZV])|\\[+L([^;]*);)$");
		sigExtractorRE = Pattern.compile("^\\(?\\)?(\\[*([BSIJCFDZV])|\\[*L([^;]*);)");
		final String javaIdent = "[\\p{Alpha}$_][\\p{Alnum}$_]*";
		Pattern.compile("^(" + javaIdent + ")(\\.(" + javaIdent + "))*$");
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
			primitiveClassMap.put("byte", renameJavaClass(Repository.lookupClass(Byte.class), byte.class.getName()));
			primitiveClassMap.put("short", renameJavaClass(Repository.lookupClass(Short.class), short.class.getName()));
			primitiveClassMap.put("int", renameJavaClass(Repository.lookupClass(Integer.class), int.class.getName()));
			primitiveClassMap.put("long", renameJavaClass(Repository.lookupClass(Long.class), long.class.getName()));
			primitiveClassMap.put("char", renameJavaClass(Repository.lookupClass(Character.class), char.class.getName()));
			primitiveClassMap.put("float", renameJavaClass(Repository.lookupClass(Float.class), float.class.getName()));
			primitiveClassMap.put("double", renameJavaClass(Repository.lookupClass(Double.class), double.class.getName()));
			primitiveClassMap.put("boolean", renameJavaClass(Repository.lookupClass(Boolean.class), boolean.class.getName()));
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

	static String getClassName(org.apache.bcel.generic.Type type) {
		if (type == null) {
			throw new IllegalArgumentException("Type can not be null");
		}
		String signatureClassName;
		if (type instanceof BasicType) {
			signatureClassName = type.toString();
		} else if (type instanceof ObjectType) {
			signatureClassName = ((ObjectType) type).getClassName();
		} else {
			signatureClassName = getClassName(((ArrayType) type).getBasicType());
		}
		return signatureClassName;
	}

	static JavaClass getPrimitive(String className) {
		return primitiveClassMap.get(className);
	}

	private static JavaClass renameJavaClass(JavaClass javaClass, String newName) {
		JavaClass result = javaClass.copy();
		try {
			Field classNamefield = result.getClass().getDeclaredField("class_name");
			classNamefield.setAccessible(true);
			classNamefield.set(result, newName);
			return result;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private static String resourceToClassName(final String className) {
		return classSuffixRE.matcher(className).replaceAll("").replace('/', '.').intern();
	}

	static List<String> signatureToTypeNames(String signature) {
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

	static List<String> signatureToTypeNames2(String signature) {
		List<String> result = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<([^>]*)>");
		Matcher matcher = pattern.matcher(signature.replace("*", ""));
		if (matcher.find()) {
			int size = matcher.groupCount();
			for (int i = 1; i <= size; i++) {
				String typeNames = matcher.group(i);
				if (!typeNames.isEmpty()) {
					if (typeNames.contains(":")) {
						typeNames = typeNames.substring(typeNames.lastIndexOf(':') + 1);
					}
					for (String type : typeNames.split(";")) {
						if (type.startsWith("L")) {
							result.add(typeConstantToClassName(type).substring(1));
						}
					}
				}
			}
		}
		return result;
	}

	private static String typeConstantToClassName(final String typeName) {
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
	private TypeNameTranslator() {

	}
}
