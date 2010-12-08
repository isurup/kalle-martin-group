package dk.sdu.mmmi.intellihome.visualization.impl.standard.graphs;

import dk.sdu.mmmi.intellihome.core.dataaccess.DataEvent;
import dk.sdu.mmmi.intellihome.visualization.impl.standard.DeviceListTopComponent;
import dk.sdu.mmmi.intellihome.core.pipe.Pipe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import org.openide.util.NbBundle;

/**
 *
 * @author jemr
 */
public abstract class AbstractGraph extends JComponent {
    protected static final Color BORDER_COLOR;
    protected static final int BORDER_WIDTH;

    protected static final Color TEXT_COLOR;
    protected static final Color BACKGROUND_COLOR;
    protected static final Color FOREGROUND_COLOR;

	static {
		ResourceBundle bundle = NbBundle.getBundle(DeviceListTopComponent.class);

		BORDER_COLOR = Color.decode(bundle.getString("graph.borderColor"));
		BORDER_WIDTH = Integer.decode(bundle.getString("graph.borderWidth"));

		TEXT_COLOR = Color.decode(bundle.getString("graph.textColor"));
		BACKGROUND_COLOR = Color.decode(bundle.getString("graph.backgroundColor"));
		FOREGROUND_COLOR = Color.decode(bundle.getString("graph.foregroundColor"));
	}


    private final String eventType;
	private final Pipe pipe;
	private long endTime;
	private long startTime;

    public AbstractGraph(String eventType, Pipe pipe) {
        this.eventType = eventType;
		this.pipe = pipe;

        setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER_WIDTH));
		setMinimumSize(new Dimension(200, 200));
		setPreferredSize(new Dimension(200, 200));
    }

    protected String getEventType() {
        return eventType;
    }

	protected Pipe getPipe() {
		return pipe;
	}

	public void updateTime(long start, long end) {
		startTime = start;
		endTime = end;
	}

	protected long getStartTime() {
		return startTime;
	}

	protected long getEndTime() {
		return endTime;
	}

	protected List<DataEvent> getData() {
		Calendar start = Calendar.getInstance(); start.setTimeInMillis(getStartTime());
		Calendar stop = Calendar.getInstance(); stop.setTimeInMillis(getEndTime());
		return getPipe().getEvents(getEventType(), start, stop);
	}

	protected double getMSecPerPixel() {
		return (1.0 * getEndTime() - getStartTime()) / getWidth();
	}

	protected void drawBackground(Graphics g, double minX, double maxX) {
		Graphics2D g2d = (Graphics2D)g;
		Color gridColor = new Color(55, 55, 55, 150);
		Color textColor = new Color(155, 155, 155, 150);

		// Clear the background
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(AbstractGraph.BACKGROUND_COLOR);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		// Draw horizontal lines, if needed
		if (minX != maxX) {
			double pixelPerUnit = getHeight() / (maxX - minX);
			double zeroPixel = getHeight() + minX * pixelPerUnit;
			// determine the lines
			double span = maxX - minX;
			double scale = 1;
			     if (span < 0.25) scale = 0.01;
			else if (span < 2.5)   scale = 0.1;
			else if (span < 25)  scale = 1;
			else if (span < 250) scale = 10;
			else if (span < 2500) scale = 100;
			else scale = Math.pow(10, Math.ceil(Math.log10(span)) - 1);

			double start = Math.ceil(minX / scale) * scale;
			int width = getWidth();
			for (; start < maxX + scale; start += scale) {
				int y = (int)(zeroPixel - start * pixelPerUnit);
				g2d.setColor(gridColor);
				g2d.drawLine(0, y, width, y);
				g2d.setColor(textColor);
				g2d.drawString(String.format("%.2f", start), 0, y);
			}
		}

		// Draw vertical lines, if needed
		if (startTime != endTime) {
			double pixelPerUnit = (double)getWidth() / (endTime - startTime);
			// determine the lines
			long timeSpan = endTime - startTime;
			long scale = 60 * 1000L;
			     if (timeSpan <= (           20 * 60 * 1000L)) scale =               60 * 1000L; // <   20 min, scale =  1 min
			else if (timeSpan <= (           60 * 60 * 1000L)) scale =           5 * 60 * 1000L; // <   60 min, scale =  5 min
			else if (timeSpan <= (       6 * 60 * 60 * 1000L)) scale =          15 * 60 * 1000L; // <  6 hours, scale = 15 min
			else if (timeSpan <= (      12 * 60 * 60 * 1000L)) scale =          30 * 60 * 1000L; // < 12 hours, scale = 30 min
			else if (timeSpan <= (      24 * 60 * 60 * 1000L)) scale =          60 * 60 * 1000L; // < 24 hours, scale = 60 min
			else if (timeSpan <= (  4 * 24 * 60 * 60 * 1000L)) scale =      4 * 60 * 60 * 1000L; // <  4 days, scale = 4 hours
			else if (timeSpan <= ( 16 * 24 * 60 * 60 * 1000L)) scale =     12 * 60 * 60 * 1000L; // < 16 days, scale = 12 hours
			else if (timeSpan <= ( 32 * 24 * 60 * 60 * 1000L)) scale =     24 * 60 * 60 * 1000L; // < 32 days, scale = 24 hours
			else                                        scale = 7 * 24 * 60 * 60 * 1000L; //            scale =  1 week

			long t = (long)(Math.ceil(startTime / scale) * scale);
			int height = getHeight();

			DateFormat dateFormat = DateFormat.getDateInstance();
			DateFormat timeFormat = DateFormat.getTimeInstance();
			Calendar cal = Calendar.getInstance();
			int lastDay = 0;
			for (; t < endTime + scale; t += scale) {
				int x = (int)((t - startTime) * pixelPerUnit);

				// If this is to be drawn outside if the screen area, just skip it
				// why waste time on that?
				if (x < 0)
					continue;

				// Draw the grid line
				g2d.setColor(gridColor);
				g2d.drawLine(x, 0, x, height);

				// Apply rotate transformation to write text vertically
				g2d.rotate(Math.PI / 2.0);

				// Set text color
				g2d.setColor(textColor);

				// Generate the time string, and find the dimensions for it
				cal.setTimeInMillis(t);
				String time = timeFormat.format(cal.getTime());
				int textX = height - (int)g2d.getFontMetrics().getStringBounds(time, g2d).getWidth() - 2;

				// NOTE - due to the rotation matrix, the coordinates are rotated
				// as well, mean inverse of what they normally are
				g2d.drawString(time, textX, -(x + 1));

				// If this is a new day, write the date as well
				if (cal.get(Calendar.DAY_OF_YEAR) != lastDay) {
					String date = dateFormat.format(cal.getTime());
					textX = height - (int)g2d.getFontMetrics().getStringBounds(date, g2d).getWidth() - 2;
					g2d.drawString(date, textX, -(x + 11));
					lastDay = cal.get(Calendar.DAY_OF_YEAR);
				}

				// Apply inverse rotation transformation to turn it back
				g2d.rotate(-Math.PI / 2.0);
			}
		}
	}
}
