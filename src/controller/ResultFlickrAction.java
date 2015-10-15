/*
 * Team 1
 * Task 8
 * 02/10/2015
 */
package controller;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;

import databean.Photo;
import model.GetFlickr;


public class ResultFlickrAction extends Action {
	public ResultFlickrAction() {
		
	}

	public String getName() { return "resultFlickr.do"; }
    
    public String perform(HttpServletRequest request) {       
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        ArrayList<Photo> result = new ArrayList<Photo>();
		String keyword = (String) request.getSession().getAttribute("keyword");
		try {
			result = GetFlickr.getPhotos(keyword, 20);
		} catch (XMLStreamException e) {
			errors.add(e.toString());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			errors.add(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			errors.add(e.toString());
			e.printStackTrace();
		}				
		request.getSession().setAttribute("flickrs", result);
		return "resultFlickr.jsp";
    }
}
