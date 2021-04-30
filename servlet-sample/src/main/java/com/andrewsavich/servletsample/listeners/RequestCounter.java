package com.andrewsavich.servletsample.listeners;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestCounter implements ServletRequestListener {

	private static final AtomicInteger COUNETR = new AtomicInteger(0);

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		int currentCounterValue = COUNETR.incrementAndGet();

		log.info("current counter value is " + currentCounterValue);

	}

}
