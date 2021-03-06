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
 * Include.java
 * Copyright (C) 2017 University of Waikato, Hamilton, NZ
 */

package adams.doc.latex.generator;

import adams.core.QuickInfoHelper;
import adams.core.io.PlaceholderFile;

/**
 <!-- globalinfo-start -->
 * Includes the specified LaTeX file.
 * <br><br>
 <!-- globalinfo-end -->
 *
 <!-- options-start -->
 * <pre>-logging-level &lt;OFF|SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST&gt; (property: loggingLevel)
 * &nbsp;&nbsp;&nbsp;The logging level for outputting errors and debugging output.
 * &nbsp;&nbsp;&nbsp;default: WARNING
 * </pre>
 * 
 * <pre>-skip &lt;boolean&gt; (property: skip)
 * &nbsp;&nbsp;&nbsp;If enabled, the code generation gets skipped.
 * &nbsp;&nbsp;&nbsp;default: false
 * </pre>
 * 
 * <pre>-no-var-expansion &lt;boolean&gt; (property: noVariableExpansion)
 * &nbsp;&nbsp;&nbsp;If enabled, variable expansion gets skipped.
 * &nbsp;&nbsp;&nbsp;default: false
 * </pre>
 * 
 * <pre>-path-type &lt;ABSOLUTE|BASENAME|SUPPLIED_DIR&gt; (property: pathType)
 * &nbsp;&nbsp;&nbsp;Determines how to process the file name.
 * &nbsp;&nbsp;&nbsp;default: ABSOLUTE
 * </pre>
 * 
 * <pre>-supplied-dir &lt;java.lang.String&gt; (property: suppliedDir)
 * &nbsp;&nbsp;&nbsp;The directory name to use instead.
 * &nbsp;&nbsp;&nbsp;default: 
 * </pre>
 * 
 * <pre>-remove-extension &lt;boolean&gt; (property: removeExtension)
 * &nbsp;&nbsp;&nbsp;If enabled, removes the extension from the filename.
 * &nbsp;&nbsp;&nbsp;default: true
 * </pre>
 * 
 * <pre>-include &lt;adams.core.io.PlaceholderFile&gt; (property: include)
 * &nbsp;&nbsp;&nbsp;The LaTeX file to include.
 * &nbsp;&nbsp;&nbsp;default: ${CWD}
 * </pre>
 * 
 <!-- options-end -->
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class Include
  extends AbstractFileReferencingCodeGenerator {

  private static final long serialVersionUID = 101642148012049382L;

  /** the file to include. */
  protected PlaceholderFile m_Include;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Includes the specified LaTeX file.";
  }

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
      "include", "include",
      new PlaceholderFile());
  }

  /**
   * Returns the default for removing the extension.
   *
   * @return		the default
   */
  protected boolean getDefaultRemoveExtension() {
    return true;
  }

  /**
   * Sets the LaTeX file to include.
   *
   * @param value	the file
   */
  public void setInclude(PlaceholderFile value) {
    m_Include = value;
    reset();
  }

  /**
   * Returns the LaTeX file to include.
   *
   * @return		the file
   */
  public PlaceholderFile getInclude() {
    return m_Include;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String includeTipText() {
    return "The LaTeX file to include.";
  }

  /**
   * Returns the list of required LaTeX packages for this code generator.
   *
   * @return		the packages
   */
  public String[] getRequiredPackages() {
    return new String[0];
  }

  /**
   * Returns a quick info about the object, which can be displayed in the GUI.
   *
   * @return		null if no info available, otherwise short string
   */
  public String getQuickInfo() {
    return QuickInfoHelper.toString(this, "include", m_Include, "include: ");
  }

  /**
   * Generates the actual code.
   *
   * @return		the generated code
   */
  @Override
  protected String doGenerate() {
    StringBuilder	result;

    result = new StringBuilder();
    result.append("\\include{");
    result.append(processFile(m_Include));
    result.append("}\n");

    return result.toString();
  }
}
