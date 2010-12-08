package dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jemr
 */
public class LineGraph extends AbstractGraph {

	@ServiceProvider(service = GraphFactory.class, position = 200)
	public static class Factory implements GraphFactory {

		public AbstractGraph newInstance(String eventType, Pipe pipe) {
			return new LineGraph(eventType, pipe);
		}

		public String getName() {
			return "Line graph";
		}
	}


    public LineGraph(String eventType, Pipe pipe) {
        super(eventType, pipe);
    }

    @Override
    protected void paintComponent(Graphics g) {
        List<DataEvent> data = getData();

		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// If no data, just return, no point in wasting time on parsing nothing
		// So just draw t
		if (data.isEmpty()) {
			drawBackground(g, 0, 0);
			return;
		}

		final long start = getStartTime();
		final double msecPerPixel = getMSecPerPixel();

        double min = data.get(0).getValue();
		double max = data.get(0).getValue();

		for (DataEvent d: data) {
			min = Math.min(min, d.getValue());
			max = Math.max(max, d.getValue());
		}

		double diff = max - min;
		if (diff == 0.0)
			diff = 0.1;

		max += diff * 0.1;
		min -= diff * 0.1;

        double pointPerPixel = (max - min) / (double)getHeight();

		drawBackground(g, min, max);

        g.setColor(TEXT_COLOR);
        g.drawString("Event " + getEventType(), 5, 15);

		final int dotWidth = (data.size() > getWidth() / 6) ? 1 : 2;

		DataEvent prev = data.get(0);
		for (DataEvent event: data) {
			int leftX = (int)((prev.getTimeInMillis() - start) / msecPerPixel);
			int leftY = getHeight() - (int)((prev.getValue() - min) / pointPerPixel);

			int rightX = (int)((event.getTimeInMillis() - start) / msecPerPixel);
			int rightY = getHeight() - (int)((event.getValue() - min) / pointPerPixel);

			g.setColor(FOREGROUND_COLOR);
			drawLine(g, leftX, leftY, rightX, rightY);
			
			g.setColor(Color.red);
			g.fillRect(leftX - dotWidth, leftY - dotWidth, dotWidth * 2 + 1, dotWidth * 2 + 1);
			g.fillRect(rightX - dotWidth, rightY - dotWidth, dotWidth * 2 + 1, dotWidth * 2 + 1);
			
			prev = event;
        }
    }

	protected void drawLine(Graphics g, int leftX, int leftY, int rightX, int rightY) {
		g.drawLine(leftX, leftY, rightX, rightY);
	}
}

