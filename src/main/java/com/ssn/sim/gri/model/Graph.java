package com.ssn.sim.gri.model;

import java.io.File;
import java.util.List;

public class Graph {

	public String path;
	public List<Vertex> vertexes;
	public List<Edge> edges;
	
	public Graph(String path, List<Vertex> vertexes, List<Edge> edges) {
		super();
		this.path = path;
		this.vertexes = vertexes;
		this.edges = edges;
		initVertexNeighbors();
	}
	
	private void initVertexNeighbors(){
		for(Edge edge : edges){
			for(Vertex vertex : vertexes){
				if(edge.getStart().equals(vertex.getName())){
					vertex.addNeighbor(getVertexByName(edge.getEnd()));
				}
				
				if(edge.getEnd().equals(vertex.getName())){
					vertex.addNeighbor(getVertexByName(edge.getStart()));
				}
			}
		}
	}
	
	private Vertex getVertexByName(String name){
		for(Vertex vertex : vertexes){
			if(vertex.getName().equals(name)){
				return vertex;
			}
		}
		throw new NullPointerException("No Vertex found with name [" + name + "].");
	}

	public List<Vertex> getNodes() {
		return vertexes;
	}

	public List<Vertex> getVertexes(){
		return vertexes;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}

	public String getPath() {
		return path;
	}

	public String getFileName() {
		return new File(path).getName();
	}
}
