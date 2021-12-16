

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String q="Q";
	String ans="answer";
	String option_A="A";
	String option_B="B";
	String option_C="C";
	String option_D="D";
	String correct_ans="Ans";
	
    
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//out.print(correct_ans);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category =request.getParameter("Category");
		String tags = request.getParameter("Tags");
		String link= "https://quizapi.io/api/v1/questions?apiKey=NJUkTXvqny5YvRmwJG6hdAVsIF1BpYkiAwnbedyY&category="+category+"&limit=1&tags="+tags;
		//System.out.println(link);
		var x= link;
		var request1  = HttpRequest.newBuilder().GET().uri(URI.create(x)).build();
		var client = HttpClient.newBuilder().build();
		try {
			var r = client.send(request1, HttpResponse.BodyHandlers.ofString());
			String s=r.body().toString();
			System.out.println(s);
			
			JSONArray albums = new JSONArray(s);
			for(int i=0;i<albums.length();i++)
			{
				JSONObject album = albums.getJSONObject(i);
				q =album.getString("question");
				ans = album.getString("correct_answer");
				//System.out.println("Correct option captured "+ ans );
				JSONObject options = album.getJSONObject("answers");
				option_A= options.getString("answer_a");
				option_B= options.getString("answer_b");
				if(options.getString("answer_c")!=null)
				option_C= options.getString("answer_c");
				if(options.getString("answer_d")!=null)
				option_D= options.getString("answer_d");
				correct_ans="";
				
				if(ans.charAt(ans.length()-1)=='a')
					correct_ans=option_A;
				else if(ans.charAt(ans.length()-1)=='b')
					correct_ans=option_B;
				else if(ans.charAt(ans.length()-1)=='c')
				correct_ans=option_C;
				else if(ans.charAt(ans.length()-1)=='d')
				correct_ans=option_D;
				
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//System.out.println("Question "+q);	
			//System.out.println("Option are  A)" + option_A+"	" + "B)"+ option_B+"	 "+"Option C)"+ option_C+"		" + "Option D)"+ option_D);
			//System.out.println("Correct answer is : "+ans +" which is "+correct_ans);
			
			request.setAttribute("question", q);
			request.setAttribute("option_A", option_A);
			request.setAttribute("option_B", option_B);
			request.setAttribute("option_C", option_C);
			request.setAttribute("option_D", option_D);
			request.setAttribute("ans", correct_ans);
			request.getRequestDispatcher("view.jsp").forward(request,response);
			
	

}

}
