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
 * AbstractWebServiceProviderWithCallableTransformer.java
 * Copyright (C) 2012-2016 University of Waikato, Hamilton, New Zealand
 */
package adams.flow.webservice;

import adams.flow.core.Actor;
import adams.flow.core.ActorUtils;
import adams.flow.core.CallableActorHelper;
import adams.flow.core.CallableActorReference;
import adams.flow.core.InputConsumer;
import adams.flow.core.OutputProducer;
import adams.flow.core.Token;

/**
 * Ancestor for webservice providers that processes the incoming request
 * data with a data
 * 
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 * @param <I> the type of data that the callable transformer gets as input
 * @param <O> the type of data that the callable transfomer generates
 */
public abstract class AbstractWebServiceProviderWithCallableTransformer<I,O>
  extends AbstractWebServiceProvider
  implements CallableTransformerSupport<I,O> {

  /** for serialization. */
  private static final long serialVersionUID = 4969001323504517094L;

  /** the callable transformer. */
  protected CallableActorReference m_Transformer;

  /** the actual transformer to use. */
  protected Actor m_ActualTransformer;

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
	    "transformer", "transformer",
	    new CallableActorReference());
  }

  /**
   * Sets the callable transformer to use.
   * 
   * @param value	the reference
   */
  public void setTransformer(CallableActorReference value) {
    m_Transformer = value;
    reset();
  }
  
  /**
   * Returns the callable transformer in use.
   * 
   * @return		the reference
   */
  public CallableActorReference getTransformer() {
    return m_Transformer;
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String transformerTipText() {
    return "The callable transformer to use for further processing the data.";
  }
  
  /**
   * Performs some initial checks before starting the service.
   */
  @Override
  protected void check() {
    CallableActorHelper	helper;

    super.check();

    helper = new CallableActorHelper();
    m_ActualTransformer = helper.findCallableActorRecursive(getFlowContext(), m_Transformer);
    if (m_ActualTransformer == null)
      throw new IllegalStateException("Failed to locate callable transformer '" + m_Transformer + "'!");
    if (!ActorUtils.isTransformer(m_ActualTransformer))
      throw new IllegalStateException("Callable actor '" + m_Transformer + "' is not a transformer!");
  }
  
  /**
   * Applies the transformer to the data.
   * 
   * @param data	the data to process
   * @return		the processed data
   * @throws Exception	if it fails for some reason
   */
  public O applyTransformer(I data) throws Exception {
    O		result;
    String	msg;
    
    ((InputConsumer) m_ActualTransformer).input(new Token(data));
    msg = m_ActualTransformer.execute();
    if (msg != null)
      throw new IllegalStateException("Failed to post-process response data: " + msg);
    if (!((OutputProducer) m_ActualTransformer).hasPendingOutput())
      throw new IllegalStateException("Callable transformer did not produce any data!");
    result = (O) ((OutputProducer) m_ActualTransformer).output().getPayload();
    if (((OutputProducer) m_ActualTransformer).hasPendingOutput())
      throw new IllegalStateException("Callable transformer still has pending output!");
    return result;
  }
}
