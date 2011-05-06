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
package ar.com.fluxit.jqa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import ar.com.fluxit.jqa.exception.RegExSyntaxException;

/**
 * TODO javadoc
 * 
 * @author Paul Cantrell
 * @author Juan Ignacio Barisich
 */
public final class RegEx {

	private static class ExpPart implements Part {
		private final String exp;

		public ExpPart(final String exp) {
			this.exp = exp;
		}

		public String getExp() {
			return exp;
		}

		@Override
		public String toString() {
			return "exp(" + getExp() + ")";
		}
	}

	private static interface Part {
	}

	private static class VarPart implements Part {
		private final String varName;

		public VarPart(final String varName) {
			this.varName = varName;
		}

		public String getVarName() {
			return varName;
		}

		@Override
		public String toString() {
			return "var(" + getVarName() + ")";
		}
	}

	private final String patternString;

	private Pattern regex;

	private List<Part> parts;

	private Map<String, Boolean> matchCache;

	private Map<String, String> matchResultCache;

	private static Pattern var;
	private static Pattern allowable;
	private static Pattern allowableNoParts;
	static {
		final String varS = "\\$\\{([A-Za-z0-9_\\.\\-]+)\\}";
		final String partS = "(([A-Za-z_]|[\\(\\)]|\\*|\\+|" + varS + ")" + "([A-Za-z0-9_]|[\\(\\)]|\\*|\\+|" + varS + ")*)";
		var = Pattern.compile(varS);
		allowable = Pattern.compile("^([\\$\\./]?" + partS + ")+$");
		allowableNoParts = Pattern.compile("^" + partS + "$");
	}

	public RegEx(final String patternString) throws RegExSyntaxException {
		this(patternString, true);
	}

	public RegEx(final String patternString, final boolean allowParts) throws RegExSyntaxException {
		if (patternString == null) {
			throw new IllegalArgumentException("patternString == null");
		}

		this.patternString = patternString;
		setParts(null);
		setRegex(null);
		setPrevVarValues(new HashMap<String, String>());

		final Pattern pattern;
		if (allowParts) {
			pattern = allowable;
		} else {
			pattern = allowableNoParts;
		}

		if (!pattern.matcher(patternString).matches()) {
			throw new RegExSyntaxException(patternString);
		}
	}

	public String getMatch(final String s) throws RegExSyntaxException {
		parseExpr();
		Boolean match = getMatchCache().get(s);
		if (match != null) {
			if (match) {
				return getMatchResultCache().get(s);
			}

			return null;
		}
		final Matcher matcher = getRegex().matcher('.' + s);
		match = matcher.matches();
		getMatchCache().put(s, match);
		if (match) {
			final String matchResult = matcher.group(matcher.groupCount());
			getMatchResultCache().put(s, matchResult);
			return matchResult;
		}
		return null;
	}

	private Map<String, Boolean> getMatchCache() {
		return matchCache;
	}

	private Map<String, String> getMatchResultCache() {
		return matchResultCache;
	}

	private List<Part> getParts() {
		return parts;
	}

	public String getPatternString() {
		return patternString;
	}

	private Pattern getRegex() {
		return regex;
	}

	public boolean matches(final String s) throws RegExSyntaxException {
		return getMatch(s) != null;
	}

	private void parseExpr() throws RegExSyntaxException {
		if (getParts() == null) {
			setParts(new ArrayList<Part>());
			final Matcher varMatcher = var.matcher(getPatternString());
			for (int pos = 0; pos >= 0;) {
				final boolean hasAnotherVar = varMatcher.find(pos);
				final int expEnd;
				if (hasAnotherVar) {
					expEnd = varMatcher.start();
				} else {
					expEnd = getPatternString().length();
				}
				if (pos < expEnd) {
					getParts().add(new ExpPart(parseSubexpr(getPatternString().substring(pos, expEnd))));
				}
				if (hasAnotherVar) {
					getParts().add(new VarPart(varMatcher.group(1)));
				}
				pos = -1;
				if (hasAnotherVar) {
					pos = varMatcher.end();
				}
			}
		}

		// Building the regexp is expensive; there's no point in doing it if we
		// already have one cached, and the relevant variables haven't changed

		final boolean changed = getRegex() == null;

		if (changed) {
			final StringBuffer builtRegexStr = new StringBuffer("^\\.?");
			for (final Part part : getParts()) {
				builtRegexStr.append(((ExpPart) part).getExp());
			}
			builtRegexStr.append('$');
			try {
				setRegex(Pattern.compile(builtRegexStr.toString()));
			} catch (final PatternSyntaxException pse) {
				System.out.println("builtRegexStr = " + builtRegexStr);
				throw new RegExSyntaxException(getPatternString(), pse);
			}
			setMatchCache(new HashMap<String, Boolean>());
			setMatchResultCache(new HashMap<String, String>());
		}
	}

	private String parseSubexpr(final String exp) {
		return exp.replace(".", "[\\.\\$]").replace("/", "\\.").replace("$", "\\$").replace("*", "\uFFFF").replace("+", "\uFCFC").replace("\uFFFF\uFFFF", ".*")
				.replace("\uFFFF", "[^\\.]*").replace("\uFCFC", "[^\\.]+");
	}

	private void setMatchCache(final Map<String, Boolean> matchCache) {
		this.matchCache = matchCache;
	}

	private void setMatchResultCache(final Map<String, String> matchResultCache) {
		this.matchResultCache = matchResultCache;
	}

	private void setParts(final List<Part> parts) {
		this.parts = parts;
	}

	private void setPrevVarValues(final Map<String, String> prevVarValues) {
	}

	private void setRegex(final Pattern regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		return '"' + getPatternString() + '"';
	}
}
