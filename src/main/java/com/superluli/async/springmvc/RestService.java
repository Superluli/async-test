package com.superluli.async.springmvc;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/test")
public class RestService {

	@RequestMapping(value = "/sync", method = RequestMethod.GET)
	public String testSync() {

		longProcess();
		return "XXX";
	}

	@RequestMapping(value = "/async", method = RequestMethod.GET)
	public Callable<String> testAsync() {

		return new Callable<String>() {
			public String call() throws Exception {
				longProcess();
				return "XXX";
			}
		};
	}

	@RequestMapping(value = "/async2", method = RequestMethod.GET)
	public DeferredResult<String> testAsync2() {
		final DeferredResult<String> deferredResult = new DeferredResult<String>();
		// Save the deferredResult in in-memory queue ...

		new Thread(new Runnable() {

			@Override
			public void run() {
				longProcess();
				deferredResult.setResult("XXX");
			}
		}).start();

		return deferredResult;
	}

	void longProcess() {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
