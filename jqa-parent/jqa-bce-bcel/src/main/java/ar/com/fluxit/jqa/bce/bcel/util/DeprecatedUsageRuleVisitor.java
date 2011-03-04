package ar.com.fluxit.jqa.bce.bcel.util;

import java.util.Collection;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;

import com.sun.org.apache.bcel.internal.classfile.ConstantClass;
import com.sun.org.apache.bcel.internal.classfile.EmptyVisitor;

public class DeprecatedUsageRuleVisitor extends EmptyVisitor {

	private boolean match;
	private final Collection<JavaClass> classes;

	public DeprecatedUsageRuleVisitor(Collection<JavaClass> classes) {
		this.match = false;
		this.classes = classes;
	}

	public Collection<JavaClass> getClasses() {
		return classes;
	}

	public boolean getMatch() {
		return match;
	}

	private void setMatch(boolean result) {
		this.match = result;
	}

	@Override
	public void visitConstantClass(ConstantClass obj) {
		if (!getMatch()) {
			JavaClass lookupClass;
			try {
				lookupClass = RepositoryLocator.getRepository().lookupClass(
						obj.getClass());
				if (getClasses().contains(lookupClass)) {
					setMatch(true);
				}
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException(e);
			}
		}
	}
}
