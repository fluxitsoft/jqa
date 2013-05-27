package ar.com.fluxit.jqa.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Layer {

	public static List<Layer> buildStandardLayers() {
		List<Layer> result = new ArrayList<Layer>();
		result.add(new Layer("Entity"));
		result.add(new Layer("Business Object API"));
		result.add(new Layer("Data Access Object API"));
		result.add(new Layer("Service API"));
		result.add(new Layer("View"));
		result.add(new Layer("Business Object Impl"));
		result.add(new Layer("Data Access Object Impl"));
		result.add(new Layer("Service Impl"));
		return result;
	}

	private String name;

	private final List<String> packages;

	public Layer(String name) {
		this.name = name;
		this.packages = new ArrayList<String>();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else {
			if (obj instanceof Layer) {
				return ((Layer) obj).getName().equals(this.getName());
			} else {
				return false;
			}
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getPackages() {
		return Collections.unmodifiableList(packages);
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
