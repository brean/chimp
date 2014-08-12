package pfd0;

import org.metacsp.framework.VariablePrototype;

import pfd0.TaskApplicationMetaConstraint.markings;

public class PFD0Precondition {
	
	private static String component = "PRE";
	
	private String fluenttype;
	
	private String[] arguments;
	
	private int[] connections;

	public PFD0Precondition(String fluenttype, String[] arguments, int[] connections) {
		this.fluenttype = fluenttype;
		this.arguments = arguments;
		this.connections = connections;
	}

	public String getFluenttype() {
		return fluenttype;
	}

	public String[] getArguments() {
		return arguments;
	}
	
	public int[] getConnections() {
		return connections;
	}
	
	/** Creates a constraint for this precondition.
	 * A precondition prototype will be created. This prototype will later be 
	 * connected via NameMatchingConstraints to the open fluents.
	 * 
	 * @param taskfluent The task that is expanded.
	 * @param groundSolver The fluentnetworksolver acting as a ground solver.
	 * @return New PRE constraint between new prototypes and taskfluent.
	 */
	public FluentConstraint createPreconditionConstraint(Fluent taskfluent, 
			FluentNetworkSolver groundSolver) {
		VariablePrototype newFluent = new VariablePrototype(groundSolver, component, 
				fluenttype, arguments);
		newFluent.setMarking(markings.UNJUSTIFIED);
		FluentConstraint preconstr = new FluentConstraint(FluentConstraint.Type.PRE, 
				connections);
		preconstr.setFrom(newFluent);
		preconstr.setTo(taskfluent);
		return preconstr;
	}
	
}