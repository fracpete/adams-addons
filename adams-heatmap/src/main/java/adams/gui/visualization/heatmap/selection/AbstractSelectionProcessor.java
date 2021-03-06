/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * AbstractSelectionProcessor.java
 * Copyright (C) 2016 University of Waikato, Hamilton, New Zealand
 */
package adams.gui.visualization.heatmap.selection;

import adams.core.ShallowCopySupporter;
import adams.core.option.AbstractOptionHandler;
import adams.core.option.OptionUtils;
import adams.gui.event.HeatmapPanelSelectionEvent;
import adams.gui.event.HeatmapPanelSelectionListener;
import adams.gui.visualization.heatmap.HeatmapPanel;

import java.awt.Point;

/**
 * Ancestor for classes that react to selection in an heatmap.
 * 
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public abstract class AbstractSelectionProcessor
  extends AbstractOptionHandler
  implements HeatmapPanelSelectionListener, ShallowCopySupporter<AbstractSelectionProcessor> {

  /** for serialization. */
  private static final long serialVersionUID = 3515366296579391750L;

  /**
   * Notifies the overlay that the heatmap has changed.
   *
   * @param panel	the panel this overlay belongs to
   */
  protected void doHeatmapChanged(HeatmapPanel panel) {
    reset();
  }

  /**
   * Notifies the overlay that the heatmap has changed.
   *
   * @param panel	the panel this overlay belongs to
   */
  public void heatmapChanged(HeatmapPanel panel) {
    doHeatmapChanged(panel);
  }

  /**
   * Process the selection that occurred in the heatmap panel.
   * 
   * @param panel	the origin
   * @param topLeft	the top-left position of the selection
   * @param bottomRight	the bottom-right position of the selection
   * @param modifiersEx	the associated modifiers
   */
  protected abstract void doProcessSelection(HeatmapPanel panel, Point topLeft, Point bottomRight, int modifiersEx);

  /**
   * Process the selection that occurred in the heatmap panel.
   * 
   * @param panel	the origin
   * @param topLeft	the top-left position of the selection
   * @param bottomRight	the bottom-right position of the selection
   * @param modifiersEx	the associated modifiers
   */
  public void processSelection(HeatmapPanel panel, Point topLeft, Point bottomRight, int modifiersEx) {
    doProcessSelection(panel, topLeft, bottomRight, modifiersEx);
    panel.repaint();
  }
  
  /**
   * Performs a check on the event.
   * 
   * @param e		the event to check
   * @return		null if OK, otherwise error message
   */
  protected String check(HeatmapPanelSelectionEvent e) {
    if (e.getHeatmapPanel() == null)
      return "No HeatmapPanel associated with event!";
    if (e.getTopLeft() == null)
      return "No top-left position associated with event!";
    if (e.getBottomRight() == null)
      return "No bottom-right position associated with event!";
    return null;
  }
  
  /**
   * Invoked when a selection happened in a {@link HeatmapPanel}.
   * 
   * @param e		the event
   */
  @Override
  public void selected(HeatmapPanelSelectionEvent e) {
    String	msg;
    
    msg = check(e);
    if (msg == null)
      processSelection(e.getHeatmapPanel(), e.getTopLeft(), e.getBottomRight(), e.getModifiersEx());
    else
      getLogger().severe(msg);
  }

  /**
   * Returns a shallow copy of itself, i.e., based on the commandline options.
   *
   * @return		the shallow copy
   */
  public AbstractSelectionProcessor shallowCopy() {
    return shallowCopy(false);
  }

  /**
   * Returns a shallow copy of itself, i.e., based on the commandline options.
   *
   * @param expand	whether to expand variables to their current values
   * @return		the shallow copy
   */
  public AbstractSelectionProcessor shallowCopy(boolean expand) {
    return (AbstractSelectionProcessor) OptionUtils.shallowCopy(this, expand);
  }
}
