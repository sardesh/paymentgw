package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	PaymentGateway paymentGateway;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "index";
	}
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	@ResponseBody
	public String getPaymetDetails(@RequestParam("msg") String msg) {
		String responce = paymentGateway.verifyPymentDetails(msg);
		return responce;
	}
}