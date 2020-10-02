
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        //for the link edit
        String edit = request.getParameter("edit");
        if(edit !=null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        
         //read the data from note.txt file
         String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
         BufferedReader br = new BufferedReader(new FileReader(new File(path)));
         Note note = new Note( br.readLine(),  br.readLine());
         request.setAttribute("note", note);
         //render the page
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //collect the data and write it into the note.txt file
       String newTitle = request.getParameter("title");
       String newContent = request.getParameter("content");
       System.out.println(newTitle);
       System.out.println(newContent);
       String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
       pw.write(newTitle + "\n");
       pw.write(newContent);
       pw.flush(); 
       pw.close();
       //load the data before i render to the page viewnote
       BufferedReader br = new BufferedReader(new FileReader(new File(path)));
       Note note = new Note( br.readLine(), br.readLine());
       request.setAttribute("note", note);
       //after click save , render it to the viewnote page
       getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
