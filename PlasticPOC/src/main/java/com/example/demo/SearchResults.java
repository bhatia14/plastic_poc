package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author RachitBhatia
 *
 */


@RestController
public class SearchResults {

	/**
	 * 
	 * @param Query param item
	 * @return List
	 */
	@RequestMapping(value = "/api", method = RequestMethod.GET)
    public List<Data> searchResult(@RequestParam("data") String item) {
        
		URL	 url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    
	    ArrayList<String> name = new ArrayList<String>();
	    ArrayList<String> date = new ArrayList<String>();
	    List<Data> al = new ArrayList<>();
	    

	    try {
	    	//calling direct craigslist url
	        url = new URL("https://toronto.craigslist.ca/search/hhh?query="+item);
	        is = url.openStream();
	        br = new BufferedReader(new InputStreamReader(is));
	        //reading Html page
	        while ((line = br.readLine()) != null) {
	        	
	        	//parsing and extracting values
	        	if(line.contains("datetime")){
	    			int from = line.indexOf(">");
	    			int to = line.lastIndexOf("<");
	    			if(from>0 && to > 0){
	    				date.add(line.substring(from+1, to));
	    			}
	    		}
	        	
	    		if(line.contains("result-title")){
	    			int from = line.indexOf(">");
	    			int to = line.lastIndexOf("<");
	    			if(from>0 && to > 0){
	    				name.add(line.substring(from+1, to));
	    			}
	    		}
	        }
	        
	        //response prepare
	        for(int i =0;i<name.size();i++){
	        	Data data=new Data();
	        	data.setTitle(name.get(i));
	        	data.setDate(date.get(i));
	        	al.add(data);
	        }
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
	    return al;
    }
}
