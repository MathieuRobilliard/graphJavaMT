package exception;

public class NotUndirectedEdge extends Exception {

	public String toString() {
		return "Vous essayez d'ajouter une ar�te qui est dirig�e � un graphe qui ne l'est pas.";
	}
	
}
