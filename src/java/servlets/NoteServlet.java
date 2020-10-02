
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit = request.getParameter("edit");
        if(edit !=null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
         String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
         BufferedReader br = new BufferedReader(new FileReader(new File(path)));
         ArrayList<String> list = new ArrayList<String>();
         StringBuilder sb = new StringBuilder();
         String line;
         while((line = br.readLine()) != null){
             sb.append(line).append("\n");
             list.add(line);
         }
         String title = list.get(0);
         String content = list.get(1);
         
        Note n = new Note(title,content);
        String t = n.getTitle();
        System.out.println(t);
        request.setAttribute("message", t);
        
         
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
