package com.springapp.mvc;

import com.common.tool.PrintInfoThread;
import com.common.tool.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller

public class HelloController {
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/streaming",method = RequestMethod.POST)
    public void streaming(HttpServletRequest request,HttpServletResponse response){
       // response.setHeader("Transfer-Encoding","chunked");
        PrintInfoThread th=new PrintInfoThread(response);
        th.run();

    }

    @RequestMapping(value="/longplling",method = RequestMethod.GET)
    public String longPoll(){
        return "long-polling";
    }

  /*  @RequestMapping(value="/polling",method = RequestMethod.POST)
    public @ResponseBody
    User longPolling(HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        Thread.sleep(1000);
        User user=new User(1,"ajw");
        return user;

    }*/
  @RequestMapping(value="/polling",method = RequestMethod.POST)
  public
  void longPolling(HttpServletResponse response) throws Exception{
      PrintWriter out=response.getWriter();
      Thread.sleep(3000);
      out.println("you have received a message");
      out.flush();
      out.close();

  }
}