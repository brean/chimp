package fluentSolver;

import htn.HTNMetaConstraint;
import org.metacsp.framework.Constraint;
import org.metacsp.framework.ConstraintSolver;
import org.metacsp.framework.Domain;
import org.metacsp.framework.Variable;
import org.metacsp.framework.multi.MultiVariable;
import org.metacsp.multi.activity.Activity;
import org.metacsp.multi.allenInterval.AllenInterval;

import unify.CompoundSymbolicVariable;

public class Fluent extends MultiVariable implements Activity{

	public static String ACTIVITY_TYPE_STR = "Activity";
	public static String STATE_TYPE_STR = "State";
	public static String PLANNED_STATE_TYPE_STR = "PlannedState";
	public static String TASK_TYPE_STR = "Task";

	/**
	 * 
	 */
	private static final long serialVersionUID = -3155335762297801220L;
	
	public Fluent(ConstraintSolver cs, int id, ConstraintSolver[] internalSolvers, Variable[] 
			internalVars) {
		super(cs, id, internalSolvers, internalVars);
	}
	
	
	/**
	 * @return The {@link CompoundSymbolicVariable} representing the compound symbolic value 
	 * of this {@link Fluent}.
	 */
	public CompoundSymbolicVariable getCompoundSymbolicVariable() {
		return (CompoundSymbolicVariable)this.getInternalVariables()[0];
	}

	/**
	 * @return The {@link AllenInterval} representing the temporal extent of this {@link Fluent}.
	 */
	public AllenInterval getAllenInterval() {
		return (AllenInterval)this.getInternalVariables()[1];
	}
	
	public void setName(String name) {
		this.getCompoundSymbolicVariable().setFullName(name);
	}
	
	public void setName(String type, String[] arguments) {
		this.getCompoundSymbolicVariable().setName(type, arguments);
	}

	@Override
	public int compareTo(Variable arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Constraint[] createInternalConstraints(Variable[] variables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDomain(Domain d) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
//		ret.append(this.getComponent());
		ret.append("(");
		ret.append(this.getID());
		ret.append(")::");
//		ret.append(this.getInternalVariables()[0].toString());
		ret.append(((CompoundSymbolicVariable) this.getInternalVariables()[0]).getShortName());
//		ret.append(">U<");
		ret.append(this.getAllenInterval().getDomain());
//		ret.append(this.getInternalVariables()[1].toString());
//		ret.append(">");
		if (this.getMarking() == HTNMetaConstraint.markings.UNIFIED) {
			ret.append("/");
			ret.append(this.getMarking());
		}
//		ret.append("/");
//		ret.append(this.getMarking());
		return ret.toString();
//		return "";
	}
	
	public String getName() {
		return ((CompoundSymbolicVariable) this.getInternalVariables()[0]).getShortName();
	}

	@Override
	public AllenInterval getTemporalVariable() {
		return getAllenInterval();
	}


	@Override
	public Variable getVariable() {
		return this;
	}


	@Override
	public String[] getSymbols() {
		return new String[] {this.getInternalVariables()[0].toString()};
	}

	public String getTypeStr() {
		String component = this.getComponent();
		if (component != null) {
			return component;
		} else {
			return STATE_TYPE_STR;
		}
	}

}
