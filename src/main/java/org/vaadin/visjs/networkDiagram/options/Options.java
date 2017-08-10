package org.vaadin.visjs.networkDiagram.options;

import org.vaadin.visjs.networkDiagram.options.cluster.Cluster;
import org.vaadin.visjs.networkDiagram.options.edges.ArrowHead;
import org.vaadin.visjs.networkDiagram.options.edges.Arrows;
import org.vaadin.visjs.networkDiagram.options.edges.Edges;
import org.vaadin.visjs.networkDiagram.options.edges.Layout;
import org.vaadin.visjs.networkDiagram.options.nodes.Icon;
import org.vaadin.visjs.networkDiagram.options.nodes.Nodes;
import org.vaadin.visjs.networkDiagram.options.physics.Physics;
import org.vaadin.visjs.networkDiagram.util.Shape;

import java.util.HashMap;
import java.util.List;

/**
 * Created by roshans on 10/10/14.
 * Updated with new modules by Martin Prause 9.8.2017
 */
public class Options {

    private boolean clickToUse = false;
    private boolean autoResize = false;
    private String locale = "en";
    private String height = "300px";
    private String width = "300px";
    private HashMap<String,Locale> locales;
    private Configure configure;
    private Manipulation manipulation;   
    private Interaction interaction;   
    private HashMap<String, Group> groups;
    
    public Options(){
    	configure=new Configure();
    	manipulation=new Manipulation();
    	interaction=new Interaction();
    	locales=new HashMap<String,Locale>();
    	locales.put("en", new Locale());
       	Arrows ar=new Arrows(new ArrowHead());
     	edges=new Edges();
    	edges.setArrows(ar);
    	nodes=new Nodes();
    	groups=new HashMap<String,Group>();

    }
    
    private Physics physics;
    private Edges edges;
    private Nodes nodes;
    //private Cluster clustering;

    private Layout layout;
    
    

	

	public HashMap<String, Group> getGroups() {
		return groups;
	}

	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}

	public void addGroup(String name,Group group){
		this.groups.put(name,group);
	}
	
	public void removeGroup(String name){
		this.groups.remove(name);
	}
	public void clearGroups(){
		this.groups.clear();
	}
	
	public Interaction getInteraction() {
		return interaction;
	}

	public void setInteraction(Interaction interaction) {
		this.interaction = interaction;
	}
  	
	public boolean isAutoResize() {
		return autoResize;
	}

	public void setAutoResize(boolean autoResize) {
		this.autoResize = autoResize;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Configure getConfigure() {
		return configure;
	}

	public void setConfigure(Configure configure) {
		this.configure = configure;
	}

	public Manipulation getManipulation() {
		return manipulation;
	}
	
	public void setManipulation(Manipulation manipulation) {
		this.manipulation = manipulation;
	}

	public boolean isClickToUse() {
        return clickToUse;
    }

    public void setClickToUse(boolean clickToUse) {
        this.clickToUse = clickToUse;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

	public HashMap<String, Locale> getLocales() {
		return locales;
	}

	public void setLocales(HashMap<String, Locale> locales) {
		this.locales = locales;
	}

	public Physics getPhysics() {
		return physics;
	}

	public void setPhysics(Physics physics) {
		this.physics = physics;
	}

	public Edges getEdges() {
		return edges;
	}

	public void setEdges(Edges edges) {
		this.edges = edges;
	}

	public Nodes getNodes() {
		return nodes;
	}

	public void setNodes(Nodes nodes) {
		this.nodes = nodes;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}
    
    

}
