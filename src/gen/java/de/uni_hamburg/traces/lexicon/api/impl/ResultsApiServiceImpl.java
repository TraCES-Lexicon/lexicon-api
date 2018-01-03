package de.uni_hamburg.traces.lexicon.api.impl;

import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import de.uni_hamburg.traces.lexicon.api.NotFoundException;
import de.uni_hamburg.traces.lexicon.api.ResultsApiService;
import de.uni_hamburg.traces.lexicon.model.Result;

public class ResultsApiServiceImpl extends ResultsApiService {

	@Override
	public Response resultsUuidGet(String uuid, SecurityContext securityContext) throws NotFoundException {
		// Check if the UUID is valid at all
		try {
			UUID.fromString(uuid);
		}
		catch (IllegalArgumentException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Result result = queryWorker.getResults().getIfPresent(uuid);
		if (result != null) {
			// Finished, see other 303
			return Response.ok(result).build();
		}
		else {
			// Gone 410
			return Response.serverError().status(Status.GONE).build();
		}
	}


}