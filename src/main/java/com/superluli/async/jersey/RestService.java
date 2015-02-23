package com.superluli.async.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("test")
public class RestService {

	@GET
	@Path("/sync")
	@Produces("text/plain")
	public String test() {

		longProcess();
		return "XXX";
	}

	@GET
	@Path("/async")
	@Produces("text/plain")
	public void test2(@Suspended final AsyncResponse asyncResponse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                longProcess();
                asyncResponse.resume("XXX");
            }
        }).start();
	}

	void longProcess() {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
