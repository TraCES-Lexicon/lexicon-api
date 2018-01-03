package de.uni_hamburg.traces.lexicon.api.impl;

import java.net.URI;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;
import de.uni_hamburg.traces.lexicon.api.QueueApiService;
import de.uni_hamburg.traces.lexicon.api.internal.QueryJob;
import de.uni_hamburg.traces.lexicon.model.Result;

public class QueueApiServiceImpl extends QueueApiService {

	@Override
	public Response queueUuidGet(HttpServletRequest request, String uuid, SecurityContext securityContext) throws NotFoundException {
		// Check if the UUID is valid at all
		try {
			UUID.fromString(uuid);
		}
		catch (IllegalArgumentException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		// Result result = null;
		QueryJob runningJob = queryWorker.getRunningJobs().get(uuid);
		Result result = queryWorker.getResults().getIfPresent(uuid);
		if (runningJob != null) {
			// Still running NO CONTENT 204
			return Response.ok().status(Status.NO_CONTENT).build();
		}
		else if (result != null) {
			// Finished, see other 303
			URI uri = UriBuilder.fromPath(request.getContextPath() + "/api/results/" + uuid).build();
			return Response.seeOther(uri).build();
		}
		else {
			// Gone 410
			return Response.serverError().status(Status.GONE).build();
		}
	}

}