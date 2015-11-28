package beziehungsrechner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Dies ist die Hauptklasse des Dabendorfer Beziehungsrechners. Dieser berechnet anhand mathematischer Methoden durch sprachliche Eigenschaften der Namen,
 * wie gut zwei Menschen zusammenpassen. Die Ergebnisse sind offiziell und durch den grossen N zur Verfuegung gestellt worden.<br>
 * Diese Hauptklasse kontrolliert die Namenseingabe und leitet bei erfolgreicher Eingabe in die Berechnungsklasse weiter.
 * 
 * @author Lukas Schramm und Miriam Fischer
 * @version 1.1
 *
 */
public class Rechner {
	
	private String[] ursprungsname = new String[2];
	
	public Rechner() {
		namenseingabe();
		new Beziehung().ordne(ursprungsname);
	}
	
	/**
	 * Diese Methode fragt bei Programmstart nach den beiden Namen der Beziehungstragenden.<br>
	 * Es gibt auch Fehlermeldungen aus, wenn die beiden Namen gleich sind oder ein Name nicht eingegeben wurde.
	 */
	public void namenseingabe() {
		JTextField textfeldname1 = new JTextField(new Feldbegrenzung(50), "", 0);
		JTextField textfeldname2 = new JTextField(new Feldbegrenzung(50), "", 0);
		
		Object[] namensfrage = {"Wie heißt die erste Person?", textfeldname1, "Wie heißt die zweite Person?", textfeldname2};
	    JOptionPane pane = new JOptionPane(namensfrage, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
	    pane.createDialog(null, "Wie heißen die Liebenden?").setVisible(true);
	    
	    ursprungsname[0] = textfeldname1.getText();
	    ursprungsname[1] = textfeldname2.getText();
	    
	    if(ursprungsname[0].equals("") || ursprungsname[1].equals("")) {
	    	JOptionPane.showMessageDialog(null, "Bitte gib beide Namen ein!", "Unvollständige Eingabe", JOptionPane.ERROR_MESSAGE);
	    	namenseingabe();
	    } else if(ursprungsname[0].equalsIgnoreCase(ursprungsname[1])) {
	    	JOptionPane.showMessageDialog(null, "Bitte benenne die Spieler unterschiedlich!", "Namensgleichheit", JOptionPane.ERROR_MESSAGE);
	    	namenseingabe();
	    }
	}
	
	public static void main(String[] args) {
		new Rechner();
	}
}