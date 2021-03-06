package com.msk.automobiles.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import com.msk.automobiles.business.interfaces.Get_Business_Interface;
import com.msk.automobiles.business.interfaces.Insert_Business_Interface;
import com.msk.automobiles.business.interfaces.Update_Business_Interface;
import com.msk.automobiles.exception.CustomGenericException;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class GenericController {

	@Autowired
	Get_Business_Interface get_Business_Interface;

	@Autowired
	Insert_Business_Interface insert_Business_Interface;

	@Autowired
	Update_Business_Interface update_Business_Interface;

	@POST
	@Path("/forget-password")
	public Response forget_password(@FormParam("username") String username, @Context HttpServletRequest request) {
		String status = null;

		try {
			status = insert_Business_Interface.insertAccessCodeAndSend(username);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(status).build();
	}

	@POST
	@Path("/verify-access")
	public Response verify_access(@FormParam("user_name") String username, @FormParam("access_code") String access_code,
			@Context HttpServletRequest request) {
		String status = null;

		try {
			status = get_Business_Interface.getVerifyAccessCode(username, access_code);
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(status).build();
	}

}
