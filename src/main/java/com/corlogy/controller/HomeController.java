package com.corlogy.controller;

import com.corlogy.model.Job;
import com.corlogy.service.ApplyJobService;
import com.corlogy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        return "career/index";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String index1(Model model, HttpSession session) {

        return "home";
    }

    @RequestMapping(value = {"/list-job"}, method = RequestMethod.GET)
    public String listJob(Model model, HttpSession session) {
        return "career/job-listings";
    }

    @RequestMapping(value = {"/services"}, method = RequestMethod.GET)
    public String services(Model model, HttpSession session) {

        return "career/services";
    }

    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public String contact(Model model, HttpSession session) {

        return "career/contact";
    }

    @RequestMapping(value = {"/blogs"}, method = RequestMethod.GET)
    public String blogs(Model model, HttpSession session) {

        return "career/blog";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String abouts(Model model, HttpSession session) {
        return "career/about";
    }

    @RequestMapping(value = {"/job-single"}, method = RequestMethod.GET)
    public String jobSingle() {
        return "career/job-single";
    }
}
