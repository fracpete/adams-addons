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

/*
 * AddTrailStep.java
 * Copyright (C) 2015 University of Waikato, Hamilton, New Zealand
 */

package adams.flow.transformer;

import adams.core.QuickInfoHelper;
import adams.core.base.BaseDateTimeMsec;
import adams.core.base.BaseKeyValuePair;
import adams.data.trail.Step;
import adams.data.trail.Trail;
import adams.flow.core.Token;

/**
 <!-- globalinfo-start -->
 * Adds a step to the trail passing through.
 * <br><br>
 <!-- globalinfo-end -->
 *
 <!-- flow-summary-start -->
 * Input&#47;output:<br>
 * - accepts:<br>
 * &nbsp;&nbsp;&nbsp;adams.data.trail.Trail<br>
 * - generates:<br>
 * &nbsp;&nbsp;&nbsp;adams.data.trail.Trail<br>
 * <br><br>
 <!-- flow-summary-end -->
 *
 <!-- options-start -->
 * <pre>-logging-level &lt;OFF|SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST&gt; (property: loggingLevel)
 * &nbsp;&nbsp;&nbsp;The logging level for outputting errors and debugging output.
 * &nbsp;&nbsp;&nbsp;default: WARNING
 * </pre>
 * 
 * <pre>-name &lt;java.lang.String&gt; (property: name)
 * &nbsp;&nbsp;&nbsp;The name of the actor.
 * &nbsp;&nbsp;&nbsp;default: AddTrailStep
 * </pre>
 * 
 * <pre>-annotation &lt;adams.core.base.BaseAnnotation&gt; (property: annotations)
 * &nbsp;&nbsp;&nbsp;The annotations to attach to this actor.
 * &nbsp;&nbsp;&nbsp;default: 
 * </pre>
 * 
 * <pre>-skip &lt;boolean&gt; (property: skip)
 * &nbsp;&nbsp;&nbsp;If set to true, transformation is skipped and the input token is just forwarded 
 * &nbsp;&nbsp;&nbsp;as it is.
 * &nbsp;&nbsp;&nbsp;default: false
 * </pre>
 * 
 * <pre>-stop-flow-on-error &lt;boolean&gt; (property: stopFlowOnError)
 * &nbsp;&nbsp;&nbsp;If set to true, the flow gets stopped in case this actor encounters an error;
 * &nbsp;&nbsp;&nbsp; useful for critical actors.
 * &nbsp;&nbsp;&nbsp;default: false
 * </pre>
 * 
 * <pre>-silent &lt;boolean&gt; (property: silent)
 * &nbsp;&nbsp;&nbsp;If enabled, then no errors are output in the console.
 * &nbsp;&nbsp;&nbsp;default: false
 * </pre>
 * 
 * <pre>-timestamp &lt;adams.core.base.BaseDateTimeMsec&gt; (property: timestamp)
 * &nbsp;&nbsp;&nbsp;The timestamp of the step to add.
 * &nbsp;&nbsp;&nbsp;default: NOW
 * </pre>
 * 
 * <pre>-x &lt;float&gt; (property: X)
 * &nbsp;&nbsp;&nbsp;The X of the step to add.
 * &nbsp;&nbsp;&nbsp;default: 0.0
 * &nbsp;&nbsp;&nbsp;minimum: 0.0
 * </pre>
 * 
 * <pre>-y &lt;float&gt; (property: Y)
 * &nbsp;&nbsp;&nbsp;The Y of the step to add.
 * &nbsp;&nbsp;&nbsp;default: 0.0
 * &nbsp;&nbsp;&nbsp;minimum: 0.0
 * </pre>
 * 
 * <pre>-meta-data &lt;adams.core.base.BaseKeyValuePair&gt; [-meta-data ...] (property: metaData)
 * &nbsp;&nbsp;&nbsp;The (optional) meta-data to attached to the step.
 * &nbsp;&nbsp;&nbsp;default: 
 * </pre>
 * 
 <!-- options-end -->
 *
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class AddTrailStep
  extends AbstractTransformer {

  /** for serialization. */
  private static final long serialVersionUID = 3690378527551302472L;

  /** the timestamp. */
  protected BaseDateTimeMsec m_Timestamp;

  /** the X of the step. */
  protected float m_X;

  /** the Y of the step. */
  protected float m_Y;

  /** the optional meta-data. */
  protected BaseKeyValuePair[] m_MetaData;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Adds a step to the trail passing through.";
  }

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
      "timestamp", "timestamp",
      new BaseDateTimeMsec());

    m_OptionManager.add(
      "x", "X",
      0.0f, 0.0f, null);

    m_OptionManager.add(
      "y", "Y",
      0.0f, 0.0f, null);

    m_OptionManager.add(
      "meta-data", "metaData",
      new BaseKeyValuePair[0]);
  }

  /**
   * Sets the timestamp.
   *
   * @param value	the timestamp
   */
  public void setTimestamp(BaseDateTimeMsec value) {
    m_Timestamp = value;
    reset();
  }

  /**
   * Returns the timestamp.
   *
   * @return		the timestamp
   */
  public BaseDateTimeMsec getTimestamp() {
    return m_Timestamp;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String timestampTipText() {
    return "The timestamp of the step to add.";
  }

  /**
   * Sets the X of the step.
   *
   * @param value	the X
   */
  public void setX(float value) {
    if (getOptionManager().isValid("X", value)) {
      m_X = value;
      reset();
    }
  }

  /**
   * Returns the X of the step.
   *
   * @return		the X
   */
  public float getX() {
    return m_X;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String XTipText() {
    return "The X of the step to add.";
  }

  /**
   * Sets the Y of the step.
   *
   * @param value	the Y
   */
  public void setY(float value) {
    if (getOptionManager().isValid("Y", value)) {
      m_Y = value;
      reset();
    }
  }

  /**
   * Returns the Y of the step.
   *
   * @return		the Y
   */
  public float getY() {
    return m_Y;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String YTipText() {
    return "The Y of the step to add.";
  }

  /**
   * Sets the meta-data to use (optional).
   *
   * @param value	the meta-data
   */
  public void setMetaData(BaseKeyValuePair[] value) {
    m_MetaData = value;
    reset();
  }

  /**
   * Returns the meta-data to use (optional).
   *
   * @return		the meta-data
   */
  public BaseKeyValuePair[] getMetaData() {
    return m_MetaData;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String metaDataTipText() {
    return "The (optional) meta-data to attached to the step.";
  }

  /**
   * Returns a quick info about the actor, which will be displayed in the GUI.
   *
   * @return		null if no info available, otherwise short string
   */
  @Override
  public String getQuickInfo() {
    String	result;

    result  = QuickInfoHelper.toString(this, "timestamp", m_Timestamp, "timestamp: ");
    result += QuickInfoHelper.toString(this, "X", m_X, ", x: ");
    result += QuickInfoHelper.toString(this, "Y", m_Y, ", y: ");

    return result;
  }

  /**
   * Returns the class that the consumer accepts.
   *
   * @return		the Class of objects that can be processed
   */
  public Class[] accepts() {
    return new Class[]{Trail.class};
  }

  /**
   * Returns the class of objects that it generates.
   *
   * @return		the Class of the generated tokens
   */
  @Override
  public Class[] generates() {
    return new Class[]{Trail.class};
  }

  /**
   * Executes the flow item.
   *
   * @return		null if everything is fine, otherwise error message
   */
  @Override
  protected String doExecute() {
    Trail 	trail;
    Step	step;

    trail = (Trail) m_InputToken.getPayload();
    step = new Step(m_Timestamp.dateValue(), m_X, m_Y);
    for (BaseKeyValuePair pair: m_MetaData)
      step.addMetaData(pair.getPairKey(), pair.getPairValue());
    trail.add(step);

    m_OutputToken = new Token(trail);

    return null;
  }
}
