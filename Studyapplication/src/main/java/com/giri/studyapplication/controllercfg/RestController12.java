package com.giri.studyapplication.controllercfg;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.giri.studyapplication.repositoryCfg.materialDAO.BannerService;
import com.giri.studyapplication.repositoryCfg.materialDAO.MaterialsService;

@RestController()
public class RestController12  implements ErrorController{

	private MaterialsService materialsSer;
	private BannerService bannerservice;

	@Autowired
	public RestController12(MaterialsService materialsSer, BannerService bannerService) {
		this.materialsSer = materialsSer;
		this.bannerservice = bannerService;
	}

	@GetMapping(path = "/")
	public ModelAndView getName() {
		return new ModelAndView("index.html");
	}

	@GetMapping(path = "/material", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<?> getname() {
		
			return this.materialsSer.getMaterial();
		

	}

	@GetMapping(path = "/bannerdetai", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<?> getBannerNames() {
		return this.bannerservice.getBannerNames();

	}
	@RequestMapping("/error")
	  @ResponseBody
	  public String handleError(HttpServletRequest request) {
	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	      return String.format("<html><body><h2>giri error page</h2><div>Status code: <b>%s</b></div>"
	                      + "<div>Exception Message: <b>%s</b></div><body></html>",
	              statusCode, exception==null? "N/A": exception.getMessage());
	  }

	  @Override
	  public String getErrorPath() {
	      return "/error";
	  }
	}	

