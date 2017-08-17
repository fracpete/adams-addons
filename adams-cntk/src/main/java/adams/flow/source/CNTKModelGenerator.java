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
 * CNTKModelGenerator.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package adams.flow.source;

import adams.core.QuickInfoHelper;
import adams.ml.cntk.modelgenerator.ManualBrainScriptModel;
import adams.ml.cntk.modelgenerator.ModelGenerator;

/**
 <!-- globalinfo-start -->
 <!-- globalinfo-end -->
 *
 <!-- flow-summary-start -->
 <!-- flow-summary-end -->
 *
 <!-- options-start -->
 <!-- options-end -->
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class CNTKModelGenerator
  extends AbstractArrayProvider {

  private static final long serialVersionUID = 711203375341324288L;

  /** the model configurator. */
  protected ModelGenerator m_ModelGenerator;

  /** the number of input nodes. */
  protected int m_NumInput;

  /** the number of output nodes. */
  protected int m_NumOutput;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return
      "Outputs the model(s) generated by the specified generator scheme.";
  }

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
      "model-generator", "modelGenerator",
      new ManualBrainScriptModel());

    m_OptionManager.add(
      "num-input", "numInput",
      1, 1, null);

    m_OptionManager.add(
      "num-output", "numOutput",
      1, 1, null);
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  @Override
  public String outputArrayTipText() {
    return "If enabled, the models are output as array rather than one-by-one.";
  }

  /**
   * Sets the number of input nodes to use.
   *
   * @param value	the number of nodes
   */
  public void setNumInput(int value) {
    if (getOptionManager().isValid("numInput", value)) {
      m_NumInput = value;
      reset();
    }
  }

  /**
   * Returns the number of input nodes to use.
   *
   * @return 		the number of nodes
   */
  public int getNumInput() {
    return m_NumInput;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return		tip text for this property suitable for
   *             	displaying in the GUI or for listing the options.
   */
  public String numInputTipText() {
    return "The number of input nodes to use.";
  }

  /**
   * Sets the number of output nodes to use.
   *
   * @param value	the number of nodes
   */
  public void setNumOutput(int value) {
    if (getOptionManager().isValid("numOutput", value)) {
      m_NumOutput = value;
      reset();
    }
  }

  /**
   * Returns the number of output nodes to use.
   *
   * @return 		the number of nodes
   */
  public int getNumOutput() {
    return m_NumOutput;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return		tip text for this property suitable for
   *             	displaying in the GUI or for listing the options.
   */
  public String numOutputTipText() {
    return "The number of output nodes to use.";
  }

  /**
   * Sets the model configurator to use.
   *
   * @param value	the configurator
   */
  public void setModelGenerator(ModelGenerator value) {
    m_ModelGenerator = value;
    reset();
  }

  /**
   * Returns the model configurator to use.
   *
   * @return 		the configurator
   */
  public ModelGenerator getModelGenerator() {
    return m_ModelGenerator;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return		tip text for this property suitable for
   *             	displaying in the GUI or for listing the options.
   */
  public String modelGeneratorTipText() {
    return "The model generator to use for generating the actual models.";
  }

  /**
   * Returns the based class of the items.
   *
   * @return the class
   */
  @Override
  protected Class getItemClass() {
    return String.class;
  }

  /**
   * Returns a quick info about the actor, which will be displayed in the GUI.
   *
   * @return		null if no info available, otherwise short string
   */
  @Override
  public String getQuickInfo() {
    String	result;

    result  = QuickInfoHelper.toString(this, "modelGenerator", m_ModelGenerator, "generator: ");
    result += QuickInfoHelper.toString(this, "numInput", m_NumInput, ", input: ");
    result += QuickInfoHelper.toString(this, "numOutput", m_NumOutput, ", output: ");

    return result;
  }

  /**
   * Executes the flow item.
   *
   * @return		null if everything is fine, otherwise error message
   */
  @Override
  protected String doExecute() {
    String	result;

    result = null;
    m_Queue.clear();

    try {
      m_ModelGenerator.setFlowContext(this);
      m_Queue.addAll(m_ModelGenerator.generate(m_NumInput, m_NumOutput));
    }
    catch (Exception e) {
      result = handleException("Failed to generate models!", e);
    }

    return result;
  }
}
