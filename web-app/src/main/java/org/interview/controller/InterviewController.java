package org.interview.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.interview.model.PaymentPerDay;
import org.interview.service.KingService;
import org.interview.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller provides two services, one to find all payments and another end point for random numbers
 */
@Slf4j
@RestController
@RequestMapping("/v1/interview")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InterviewController {

	@NonNull
	private KingService kingService;

	@NonNull
	private RandomNumberService randomNumberService;

	@GetMapping(value="/findAllCoinsPayment")
	public List<PaymentPerDay> findAllCoinsPayment() {
		log.info("Gold coins payments");
		return kingService.findAll();
	}

	@GetMapping(value="/findRandomNumber")
	public int findRandomNumber() {
		log.info("find randomNumber");
		return randomNumberService.nextNum();
	}
}
