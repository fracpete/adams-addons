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
 * NoAuthenticationRequired.java
 * Copyright (C) 2019 University of Waikato, Hamilton, NZ
 */

package adams.flow.rest.dex.authentication;

import java.util.Map;

/**
 * Allows all requests.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class NoAuthenticationRequired
  extends AbstractAuthentication {

  private static final long serialVersionUID = -4554175452731913974L;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Allows all requests.";
  }

  /**
   * Performs the authentication.
   *
   * @param params	the parameters to use use for authentication
   * @return		null if successfully authenticated, otherwise error message
   */
  @Override
  protected String doAuthenticate(Map<String, String> params) {
    return null;
  }
}
