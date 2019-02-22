package ycmweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycmweb.util.RandomImageGenerator;

public class RandomImageServlet extends HttpServlet {
	private final static String VERIFICATION_CODE_KEY = "VERIFICATION_CODE_KEY";
	
	public void init() throws ServletException {
		System.setProperty("java.awt.headless", "true");
	}

	public static String getRandomLoginKey(HttpServletRequest req) {
		return (String) req.getSession().getAttribute(VERIFICATION_CODE_KEY);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ssn = req.getSession();
		
		if (ssn != null) {
			String randomString = RandomImageGenerator.random();
			ssn.setAttribute(VERIFICATION_CODE_KEY, randomString);
			res.setContentType("image/jpeg");

			RandomImageGenerator.render(randomString, res.getOutputStream());
		}
	}
}
