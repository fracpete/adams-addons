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
 * EchoClientTransformer.java
 * Copyright (C) 2018 University of Waikato, Hamilton, NZ
 */

package adams.flow.rest.echo;

import adams.core.base.BaseURL;
import adams.core.net.HttpRequestHelper;
import adams.flow.container.HttpRequestResult;
import adams.flow.rest.AbstractRESTClientSource;
import org.jsoup.Connection.Method;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Source client for Echo REST service.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class EchoClientSource
  extends AbstractRESTClientSource<String> {

  private static final long serialVersionUID = -4005180585673812548L;

  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Client (source) for Echo REST service.";
  }

  /**
   * Returns the classes that this client generates.
   *
   * @return		the classes
   */
  @Override
  public Class[] generates() {
    return new Class[]{String.class};
  }

  /**
   * Performs the actual webservice query.
   *
   * @throws Exception	if accessing webservice fails for some reason
   */
  @Override
  protected void doQuery() throws Exception {
    String		url;
    HttpRequestResult result;

    if (getUseAlternativeURL())
      url = getAlternativeURL();
    else
      url = new EchoServer().getDefaultURL();
    url += "echo/" + URLEncoder.encode(getOwner().getFullName(), "UTF-8");
    result = HttpRequestHelper.send(new BaseURL(url), Method.GET, null, null);
    if (result.getValue(HttpRequestResult.VALUE_STATUSCODE, Integer.class) == 200)
      setResponseData(URLDecoder.decode(result.getValue(HttpRequestResult.VALUE_BODY, String.class), "UTF-8"));
    else
      m_LastError = result.getValue(HttpRequestResult.VALUE_STATUSCODE) + ": " + result.getValue(HttpRequestResult.VALUE_STATUSMESSAGE);
  }
}
