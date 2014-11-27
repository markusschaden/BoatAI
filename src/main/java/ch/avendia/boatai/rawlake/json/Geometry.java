package ch.avendia.boatai.rawlake.json;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Geometry {

	@Expose
	private String type;
	@Expose
	private Integer id;
	@Expose
	private Properties properties;
	@Expose
	private List<List<Integer>> arcs = new ArrayList<List<Integer>>();

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Geometry withType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Geometry withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 
	 * @return The properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * 
	 * @param properties
	 *            The properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Geometry withProperties(Properties properties) {
		this.properties = properties;
		return this;
	}

	/**
	 * 
	 * @return The arcs
	 */
	public List<List<Integer>> getArcs() {
		return arcs;
	}

	/**
	 * 
	 * @param arcs
	 *            The arcs
	 */
	public void setArcs(List<List<Integer>> arcs) {
		this.arcs = arcs;
	}

	public Geometry withArcs(List<List<Integer>> arcs) {
		this.arcs = arcs;
		return this;
	}

}
