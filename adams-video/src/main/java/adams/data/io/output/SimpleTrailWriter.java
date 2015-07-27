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
 * SimpleTrailWriter.java
 * Copyright (C) 2015 University of Waikato, Hamilton, NZ
 */

package adams.data.io.output;

import adams.core.Properties;
import adams.core.io.FileUtils;
import adams.data.image.BufferedImageHelper;
import adams.data.image.IntArrayMatrixView;
import adams.data.io.input.SimpleTrailReader;
import adams.data.spreadsheet.SpreadSheet;
import adams.data.trail.Trail;

import java.awt.image.BufferedImage;
import java.io.StringWriter;
import java.util.List;

/**
 <!-- globalinfo-start -->
 * Writes trails in the simple CSV-like format.
 * <br><br>
 <!-- globalinfo-end -->
 *
 <!-- options-start -->
 * <pre>-logging-level &lt;OFF|SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST&gt; (property: loggingLevel)
 * &nbsp;&nbsp;&nbsp;The logging level for outputting errors and debugging output.
 * &nbsp;&nbsp;&nbsp;default: WARNING
 * </pre>
 * 
 * <pre>-output &lt;adams.core.io.PlaceholderFile&gt; (property: output)
 * &nbsp;&nbsp;&nbsp;The file to write the container to.
 * &nbsp;&nbsp;&nbsp;default: ${TMP}&#47;out.tmp
 * </pre>
 * 
 * <pre>-store-background &lt;boolean&gt; (property: storeBackground)
 * &nbsp;&nbsp;&nbsp;If enabled, the background gets stored in the file as well.
 * &nbsp;&nbsp;&nbsp;default: true
 * </pre>
 * 
 <!-- options-end -->
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class SimpleTrailWriter
  extends AbstractTrailWriter {

  private static final long serialVersionUID = -7138302129366743189L;

  /** whether to save the background as well. */
  protected boolean m_StoreBackground;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Writes trails in the simple CSV-like format.";
  }

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
      "store-background", "storeBackground",
      true);
  }

  /**
   * Sets whether to store the background as well.
   *
   * @param value	true if to store background
   */
  public void setStoreBackground(boolean value) {
    m_StoreBackground = value;
    reset();
  }

  /**
   * Returns whether to store the background as well.
   *
   * @return 		ture if to store background
   */
  public boolean getStoreBackground() {
    return m_StoreBackground;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return tip text for this property suitable for displaying in the GUI or
   *         for listing the options.
   */
  public String storeBackgroundTipText() {
    return "If enabled, the background gets stored in the file as well.";
  }

  /**
   * Returns a string describing the format (used in the file chooser).
   *
   * @return a description suitable for displaying in the file chooser
   */
  @Override
  public String getFormatDescription() {
    return new SimpleTrailReader().getFormatDescription();
  }

  /**
   * Returns the extension(s) of the format.
   *
   * @return the extension(s) (without the dot!)
   */
  @Override
  public String[] getFormatExtensions() {
    return new SimpleTrailReader().getFormatExtensions();
  }

  /**
   * Returns whether writing of multiple containers is supported.
   *
   * @return 		true if multiple containers are supported
   */
  @Override
  public boolean canWriteMultiple() {
    return false;
  }

  /**
   * Performs the actual writing.
   *
   * @param data	the data to write
   * @return		true if successfully written
   */
  @Override
  protected boolean writeData(List<Trail> data) {
    boolean			result;
    Trail			trail;
    SpreadSheet 		sheet;
    StringWriter		swriter;
    Properties			props;
    CsvSpreadSheetWriter	writer;
    StringBuilder		row;
    BufferedImage		image;
    IntArrayMatrixView		matrix;
    int				x;
    int				y;

    if (data.size() == 0)
      return false;

    trail   = data.get(0);
    swriter = new StringWriter();

    // report
    if (trail.hasReport()) {
      props = trail.getReport().toProperties();
      swriter.write(props.toComment());
    }

    // background
    if (getStoreBackground() && trail.hasBackground()) {
      image  = BufferedImageHelper.convert(trail.getBackground(), BufferedImage.TYPE_INT_ARGB);
      matrix = BufferedImageHelper.getPixelMatrix(image);
      for (y = 0; y < matrix.getHeight(); y++) {
	row = new StringBuilder(SimpleTrailReader.BACKGROUND);
	for (x = 0; x < matrix.getWidth(); x++) {
	  if (x > 0)
	    row.append(",");
	  row.append(Integer.toHexString(matrix.get(x, y)));
	}
	row.append("\n");
	swriter.append(row.toString());
      }
    }

    // data
    sheet = trail.toSpreadSheet();
    writer = new CsvSpreadSheetWriter();
    writer.setMissingValue("");
    result = writer.write(sheet, swriter);

    if (result)
      result = FileUtils.writeToFile(m_Output.getAbsolutePath(), swriter.toString(), false);

    return result;
  }
}
