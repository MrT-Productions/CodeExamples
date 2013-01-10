package redboxMovies;

import java.util.Map;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ForceSessionSerializationPhaseListener implements PhaseListener {
	private static final Logger LOGGER = Logger.getLogger(ForceSessionSerializationPhaseListener.class.getName());
	
	private void touchSession() {
		LOGGER.finest("forcing session serialization");
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		final Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		sessionMap.put("forceGaeSessionSerialization", System.currentTimeMillis());
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {
		touchSession();
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {	
	}

	@Override
	public PhaseId getPhaseId() {
		// return PhaseId.INVOKE_APPLICATION;
		// DJP - Setting after any phase to support immediate event handling
		return PhaseId.ANY_PHASE;
	}

}
