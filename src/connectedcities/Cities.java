package connectedCities;

import edu.princeton.cs.algs4.AdjMatrixEdgeWeightedDigraph;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;

public class Cities {
	private AdjMatrixEdgeWeightedDigraph matrix;
	private EdgeWeightedDigraph digraph;
	private DijkstraSP sp;
	ST<Integer, String> st;

	Cities() {
		this.matrix = new AdjMatrixEdgeWeightedDigraph(14);
		this.matrix.addEdge(new DirectedEdge(0, 1, 808));
		this.matrix.addEdge(new DirectedEdge(0, 9, 2060));
		this.matrix.addEdge(new DirectedEdge(1, 0, 808));
		this.matrix.addEdge(new DirectedEdge(1, 2, 414));
		this.matrix.addEdge(new DirectedEdge(1, 8, 2257));
		this.matrix.addEdge(new DirectedEdge(2, 1, 414));
		this.matrix.addEdge(new DirectedEdge(2, 3, 272));
		this.matrix.addEdge(new DirectedEdge(2, 6, 1440));
		this.matrix.addEdge(new DirectedEdge(3, 2, 272));
		this.matrix.addEdge(new DirectedEdge(3, 9, 1780));
		this.matrix.addEdge(new DirectedEdge(4, 8, 1771));
		this.matrix.addEdge(new DirectedEdge(5, 7, 792));
		this.matrix.addEdge(new DirectedEdge(6, 2, 1440));
		this.matrix.addEdge(new DirectedEdge(6, 7, 949));
		this.matrix.addEdge(new DirectedEdge(6, 10, 571));
		this.matrix.addEdge(new DirectedEdge(6, 11, 1614));
		this.matrix.addEdge(new DirectedEdge(7, 5, 792));
		this.matrix.addEdge(new DirectedEdge(7, 6, 949));
		this.matrix.addEdge(new DirectedEdge(7, 11, 1217));
		this.matrix.addEdge(new DirectedEdge(8, 1, 2257));
		this.matrix.addEdge(new DirectedEdge(8, 4, 1771));
		this.matrix.addEdge(new DirectedEdge(8, 12, 811));
		this.matrix.addEdge(new DirectedEdge(9, 0, 2060));
		this.matrix.addEdge(new DirectedEdge(9, 3, 1780));
		this.matrix.addEdge(new DirectedEdge(9, 10, 948));
		this.matrix.addEdge(new DirectedEdge(9, 13, 1423));
		this.matrix.addEdge(new DirectedEdge(10, 6, 571));
		this.matrix.addEdge(new DirectedEdge(10, 9, 948));
		this.matrix.addEdge(new DirectedEdge(11, 6, 1614));
		this.matrix.addEdge(new DirectedEdge(11, 7, 1217));
		this.matrix.addEdge(new DirectedEdge(11, 12, 237));
		this.matrix.addEdge(new DirectedEdge(12, 8, 811));
		this.matrix.addEdge(new DirectedEdge(12, 11, 237));
		this.matrix.addEdge(new DirectedEdge(13, 9, 1423));
		this.digraph = new EdgeWeightedDigraph(new In("src/connectedCities/CitiesEwd.txt"));

		st = new ST<Integer, String>();
		this.st.put(0, "SEA");
		this.st.put(1, "SFR");
		this.st.put(2, "LA");
		this.st.put(3, "LV");
		this.st.put(4, "PHO");
		this.st.put(5, "OKC");
		this.st.put(6, "DAL");
		this.st.put(7, "MIN");
		this.st.put(8, "MIL");
		this.st.put(9, "CHI");
		this.st.put(10, "NOR");
		this.st.put(11, "NYC");
		this.st.put(12, "WDC");
		this.st.put(13, "MIA");
	}

	String shortestPath(int start, int end) {
		this.sp = new DijkstraSP(this.digraph, start);
		return getName(this.sp.pathTo(end));
	}

	String getName(Iterable<DirectedEdge> e) {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		double weight = 0;
		for (DirectedEdge edge : e) {
			weight += edge.weight();
			sb.append(st.get(edge.from()) + " -> " + st.get(edge.to()) + " (" + edge.weight() + ") ");
		}
		sb.append(NEWLINE);
		sb.append("Total Distance: " + weight + " miles");
		return sb.toString();
	}

	String connectedCities() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		for (int v = 0; v < this.matrix.V(); v++) {
			s.append(st.get(v) + ": ");
			for (DirectedEdge e : this.matrix.adj(v)) {
				s.append(st.get(e.from()) + " -> " + st.get(e.to()) + " (" + e.weight() + ") ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String args[]) {
		Cities cities = new Cities();
		System.out.println(cities.shortestPath(0, 2));
	}
}
