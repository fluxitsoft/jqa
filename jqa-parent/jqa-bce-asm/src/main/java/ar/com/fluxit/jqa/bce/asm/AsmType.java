package ar.com.fluxit.jqa.bce.asm;

import java.io.InputStream;

import net.sourceforge.pmd.ast.CharStream;
import net.sourceforge.pmd.ast.JavaCharStream;
import net.sourceforge.pmd.ast.JavaParser;
import ar.com.fluxit.jqa.bce.Type;

public class AsmType implements Type {

	private String name;
	private boolean isAbstract;
	private boolean isInterface;
	private Integer declarationLineNumber;

	public AsmType(InputStream dstream) {
		CharStream stream = new JavaCharStream(dstream);
		final JavaParser javaParser = new JavaParser(stream);
	}

	public Integer getDeclarationLineNumber() {
		return declarationLineNumber;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isAbstract() {
		return isAbstract;
	}

	@Override
	public boolean isInterface() {
		return isInterface;
	}

}
