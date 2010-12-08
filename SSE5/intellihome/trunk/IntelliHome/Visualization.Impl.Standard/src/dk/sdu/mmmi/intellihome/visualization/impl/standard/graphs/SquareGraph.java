package dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs;

import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.awt.Graphics;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class SquareGraph extends LineGraph {

	@ServiceProvider(service = GraphFactory.class, position = 100)
	public static class Factory implements GraphFactory {

		public AbstractGraph newInstance(String eventType, Pipe pipe) {
			return new SquareGraph(eventType, pipe);
		}

		public String getName() {
			return "Square graph";
		}
	}


    public SquareGraph(String eventType, Pipe pipe) {
        super(eventType, pipe);
    }

	@Override
	protected void drawLine(Graphics g, int leftX, int leftY, int rightX, int rightY) {
		g.drawLine(leftX, leftY, rightX, leftY);
		g.drawLine(rightX, leftY, rightX, rightY);
	}
}
