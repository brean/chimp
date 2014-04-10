package pfd0;

import org.metacsp.booleanSAT.BooleanSatisfiabilitySolver;
import org.metacsp.framework.ConstraintSolver;
import org.metacsp.framework.multi.MultiConstraintSolver;
import org.metacsp.multi.allenInterval.AllenIntervalNetworkSolver;
import org.metacsp.multi.spatial.rectangleAlgebra.RectangleConstraint;
import org.metacsp.multi.spatial.rectangleAlgebra.RectangularRegion;
import org.metacsp.multi.spatial.rectangleAlgebra.UnaryRectangleConstraint;
import org.metacsp.multi.symbols.SymbolicVariableConstraintSolver;

public class FluentBooleanConstraintSolver extends MultiConstraintSolver {

	private static final long serialVersionUID = -8105880522155296176L;
	
	public FluentBooleanConstraintSolver(long origin, long horizon) {
		super(new Class[] {FluentBooleanValueConstraint.class}, Fluent.class, createConstraintSolvers(origin, horizon, -1), new int[] {1});
	}

	@Override
	public boolean propagate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static ConstraintSolver[] createConstraintSolvers(long origin, long horizon, int maxFluents) {
		ConstraintSolver[] ret = new ConstraintSolver[] {new BooleanSatisfiabilitySolver()};
		return ret;
	}

}