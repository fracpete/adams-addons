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
 * Rats.java
 * Copyright (C) 2014-2018 University of Waikato, Hamilton, New Zealand
 */
package adams.flow.standalone;

import adams.core.Pausable;
import adams.flow.core.Actor;
import adams.flow.core.ActorExecution;
import adams.flow.core.ActorHandlerInfo;
import adams.flow.core.ActorReferenceHandler;
import adams.flow.core.ActorReferenceHandlerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 <!-- globalinfo-start -->
 * Encapsulates all Rat setups.
 * <br><br>
 <!-- globalinfo-end -->
 *
 <!-- flow-summary-start -->
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
 * &nbsp;&nbsp;&nbsp;default: Rats
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
 * <pre>-rat &lt;adams.flow.core.Actor&gt; [-rat ...] (property: rats)
 * &nbsp;&nbsp;&nbsp;The reception&#47;transmission setups.
 * &nbsp;&nbsp;&nbsp;default: 
 * </pre>
 * 
 <!-- options-end -->
 *
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 */
public class Rats
  extends AbstractStandaloneMutableGroup<Rat>
  implements Pausable, ActorReferenceHandler {

  /** for serialization. */
  private static final long serialVersionUID = -6092821156832607603L;
  
  /** whether the execution has been paused. */
  protected boolean m_Paused;
  
  /**
   * Returns a string describing the object.
   *
   * @return 			a description suitable for displaying in the gui
   */
  @Override
  public String globalInfo() {
    return "Encapsulates all Rat setups.";
  }

  /**
   * Adds options to the internal list of options.
   */
  @Override
  public void defineOptions() {
    super.defineOptions();

    m_OptionManager.add(
	    "rat", "rats",
	    new Actor[0]);
  }

  /**
   * Initializes the members.
   */
  @Override
  protected void initialize() {
    super.initialize();
    
    m_Paused = false;
  }
  
  /**
   * Returns the list of default actors.
   * 
   * @return		the default actors
   */
  @Override
  protected List<Rat> getDefaultActors() {
    return new ArrayList<>();
  }

  /**
   * Sets the receptions to use.
   *
   * @param value	the receptions
   */
  public void setRats(Actor[] value) {
    int		i;
    String	msg;
    
    for (i = 0; i < value.length; i++) {
      msg = checkActor(value[i], i);
      if (msg != null) {
	getLogger().warning(msg);
	return;
      }
    }
    
    m_Actors.clear();
    for (Actor actor: value)
      m_Actors.add((Rat) actor);
    reset();
    updateParent();
  }

  /**
   * Returns the receptions to use.
   *
   * @return		the receptions
   */
  public Actor[] getRats() {
    return m_Actors.toArray(new Actor[m_Actors.size()]);
  }

  /**
   * Returns the tip text for this property.
   *
   * @return 		tip text for this property suitable for
   * 			displaying in the GUI or for listing the options.
   */
  public String ratsTipText() {
    return "The reception/transmission setups.";
  }

  /**
   * Returns some information about the actor handler, e.g., whether it can
   * contain standalones and the actor execution.
   *
   * @return		the info
   */
  @Override
  public ActorHandlerInfo getActorHandlerInfo() {
    return new ActorHandlerInfo()
      .allowStandalones(true)
      .allowSource(false)
      .actorExecution(ActorExecution.UNDEFINED)
      .forwardsInput(false)
      .restrictions(new Class[]{Rat.class, LabRat.class});
  }

  /**
   * Returns the classes that are prohibited to appear before this reference
   * handler.
   *
   * @return		the classes
   */
  public Class[] getProhibitedPrecedingActorReferenceHandlers() {
    return new Class[]{};
  }

  /**
   * Ensures that the handlers appear in the correct order.
   *
   * @return		null if OK, otherwise error message
   * @see		#getProhibitedPrecedingActorReferenceHandlers()
   */
  @Override
  public String checkActorReferenceHandlers() {
    return ActorReferenceHandlerHelper.checkActorReferenceHandlers(this);
  }

  /**
   * Returns whether actors have to be referenced elsewhere in the flow
   * or whether it is optional.
   *
   * @return		true if required, false if optional
   */
  public boolean isReferencingRequired() {
    return false;
  }

  /**
   * Checks the actor whether it is of the correct type.
   * 
   * @param actor	the actor to check
   * @param index	the index of actor, ignored if -1
   * @return		null if OK, otherwise the error message
   */
  @Override
  protected String checkActor(Actor actor, int index) {
    if (!(actor instanceof Rat) && !(actor instanceof LabRat))
      return 
	  "Actor" + (index > -1 ? (" #" + (index+1)) : "") + " is neither " 
	+ Rat.class.getName() + " nor " + LabRat.class.getName() 
	+ ", provided: " + actor.getClass().getName();
    else
      return null;
  }

  /**
   * Checks whether the actor is valid.
   *
   * @param actor	the actor to check
   * @return		null if OK, otherwise error message
   */
  protected String checkActor(Actor actor) {
    String	result;

    result = super.checkActor(actor);
    if (result != null)
      return result;

    if (getScopeHandler() != null)
      return getScopeHandler().addCallableName(this, actor);

    return null;
  }

  /**
   * Performs checks on the "sub-actors".
   *
   * @return		null if everything is fine, otherwise the error
   */
  @Override
  public String check() {
    return checkActorReferenceHandlers();
  }
  
  /**
   * Executes the flow item.
   *
   * @return		null if everything is fine, otherwise error message
   */
  @Override
  protected String doExecute() {
    String	result;
    int		i;
    
    result = null;
    
    for (i = 0; i < m_Actors.size(); i++) {
      if (m_Actors.get(i).getSkip())
	continue;
      
      try {
	result = m_Actors.get(i).execute();
	if (result != null) {
	  result = "Rat #" + (i+1) + " failed: " + result;
	  break;
	}
      }
      catch (Exception e) {
	result = handleException("Failed to execute Rat #" + (i+1), e);
      }
    }
      
    return result;
  }

  /**
   * Pauses the execution.
   */
  @Override
  public void pauseExecution() {
    int		i;
    
    for (i = 0; i < size(); i++)
      ((Rat) get(i)).pauseExecution();
    
    m_Paused = true;
  }

  /**
   * Returns whether the object is currently paused.
   *
   * @return		true if object is paused
   */
  @Override
  public boolean isPaused() {
    return m_Paused;
  }

  /**
   * Resumes the execution.
   */
  @Override
  public void resumeExecution() {
    int		i;
    
    for (i = 0; i < size(); i++)
      ((Rat) get(i)).resumeExecution();
    
    m_Paused = false;
  }
}
