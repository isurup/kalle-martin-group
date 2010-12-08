package dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.awt.Graphics;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class ActivityGraph extends AbstractGraph {

	@ServiceProvider(service = GraphFactory.class, position = 300)
	public static class Factory implements GraphFactory {

		public AbstractGraph newInstance(String eventType, Pipe pipe) {
			return new ActivityGraph(eventType, pipe);
		}

		public String getName() {
			return "Activity graph";
		}
	}

    public ActivityGraph(String eventType, Pipe pipe) {
        super(eventType, pipe);
    }

    @Override
    protected void paintComponent(Graphics g) {
		List<DataEvent> data = getData();

		drawBackground(g, 0, 0);

		if (data.isEmpty())
			return;

		final double msecPerPixel = getMSecPerPixel();
		final long start = getStartTime();

        g.setColor(TEXT_COLOR);
        g.drawString("Event " + getEventType(), 5, 15);

        g.setColor(FOREGROUND_COLOR);
		for (DataEvent event: data) {
			int pos = (int)((event.getTimeInMillis() - start) / msecPerPixel);
			g.drawLine(pos, 0, pos, getHeight());
        }
    }
}
