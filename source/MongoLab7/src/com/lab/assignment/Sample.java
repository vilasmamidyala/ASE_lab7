package com.lab.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

@Path("/sample")
public class Sample extends HttpServlet {
	
	String result;
	@GET
	@Path("/test")
	public String sample()
	{
		return "Hello";
	}

	@GET
	@Path("/example")
	@Produces(MediaType.APPLICATION_XML)
	public String example(){
		/*
		HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("https://api.mongolab.com/api/1/databases/ase_spring/collections/assignment7/?apiKey=fLr-gBAV6_SS8Qtf-0-MEBlfR51d2nQr");


        JSONObject j = new JSONObject();
		
        try {
            j.put("fname", fname);
            j.put("lname", lname);
            j.put("email", email);
            j.put("password", password);
            j.put("passport",passport);
            j.put("dlicence",dlicence);
            httpPost.setEntity(new ByteArrayEntity(j.toString().getBytes("UTF-8")));
            httpPost.setHeader("Content-Type", "application/json");
            httpClient.execute(httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
		MongoClientURI uri = new MongoClientURI("mongodb://vilas:vilas@ds053300.mlab.com:53300/ase_vilas");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection users = db.getCollection("studentinfo");
		BasicDBObject query = new BasicDBObject();
		query.put("name","vilas");// request.getParameter("name"));
		query.put("password","vilas"); //request.getParameter("password"));
		DBCursor docs = users.find(query);
		result = docs.toArray().toString();
		return result;
		/*
		response.getWriter().write(docs.toArray().toString());
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
		*/
	}
}
