package ycmweb.struts2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ycmweb.util.RandomImageGenerator;

public class RandomImageAction extends ActionSupport {

	public String execute() throws IOException {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpSession ssn = req.getSession();
		
		if (ssn != null) {
			String randomString = RandomImageGenerator.random();
			ssn.setAttribute("VERIFICATION_CODE_KEY", randomString);
			res.setContentType("image/jpeg");

			RandomImageGenerator.render(randomString, res.getOutputStream());
		}
        return SUCCESS;
    }

}
