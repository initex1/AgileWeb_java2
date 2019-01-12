package lv.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.console.domain.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskServlet extends HttpServlet {

    private List<Task> tasks = new ArrayList<>(); //will be removed after DI
    private ObjectMapper mapper = new ObjectMapper(); //will be removed after DI

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println(mapper.writeValueAsString(tasks));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Task task = mapper.readValue(reader, Task.class);
        tasks.add(task);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}
