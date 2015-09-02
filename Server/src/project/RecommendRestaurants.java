package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RecommendRestaurants
 */
@WebServlet("/RecommendRestaurants")
public class RecommendRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	  	 response.addHeader("Access-Control-Allow-Origin", "*");
	  	 String username = "";
	  	 if (request.getParameter("username") != null) {
	  		 username = request.getParameter("username");
	  	 }
	  	 JSONObject obj = new JSONObject();
	  	 try {
	  		 obj.append("username", username);
	  	 } catch (JSONException e) {
	  		 // TODO Auto-generated catch block
	  		 e.printStackTrace();
	  	 }
	  	 PrintWriter out = response.getWriter();
	  	 out.print(obj);
	  	 out.flush();
	  	 out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
	  	 String line = null;
	  	 try {
	  		 BufferedReader reader = request.getReader();
	  		 while ((line = reader.readLine()) != null) {
	  			 jb.append(line);
	  		 }
	  		 reader.close();
	  	 } catch (Exception e) { /* report an error */
	  	 }

	  	 try {
	  		 JSONObject input = new JSONObject(jb.toString());
	  		 JSONObject output = new JSONObject();
	  		 List<String> list = new ArrayList<String>();
	  		 list.add("panda express");
	  		 list.add("hong kong express");
	  		 list.add("chinatown express");
	  		 JSONArray array = new JSONArray(list);
	  		 output.append("name",array);
	  		 response.setContentType("application/json");
	  		 response.addHeader("Access-Control-Allow-Origin", "*");
	  		 PrintWriter out = response.getWriter();
	  		 out.print(output);
	  		 out.flush();
	  		 out.close();
	  	 } catch (JSONException e) {
	  		 e.printStackTrace();
	  	 }
	}

}
