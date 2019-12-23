package com.corlogy.controller;

import com.corlogy.model.Applyjob;
import com.corlogy.model.Job;
import com.corlogy.model.UserSys;
import com.corlogy.service.ApplyJobService;
import com.corlogy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    private UserSys usersys;
    private String errorMsg;
    private String successMsgTable;
    private String errorMsgTable;
    @Autowired
    private JobService jobService;
    @Autowired
    private ApplyJobService applyJobService;
    @PostConstruct
    public void init() {
        refreshData();
        clearMsg();
    }

    public void refreshData() {
        usersys = new UserSys();
    }

    public void clearMsg() {
        errorMsg = "";
    }

    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        init();
        session.invalidate();
        return "home";
    }

    @GetMapping(value = {"/admin/listjob"})
    public ModelAndView getListJob(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<Job> listJob = jobService.listAllJob();
        modelAndView.addObject("listJob", listJob);
        modelAndView.setViewName("jobForm");
        return modelAndView;
    }
    @GetMapping(value = {"/admin/applyjob"})
    public ModelAndView getApplyListJob(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<Applyjob> listApplyJob = applyJobService.getAll();
        modelAndView.addObject("listApplyJob", listApplyJob);
        modelAndView.setViewName("applyJobForm");
        return modelAndView;
    }
    @GetMapping(value = "/admin/job/add")
    public ModelAndView addJob(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs",new Job());
        modelAndView.setViewName("job");
        return modelAndView;
    }
    @GetMapping(value = "/admin/job/edit")
    public ModelAndView editJob(@RequestParam("jobId") int jobId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs",jobService.getJobById(jobId));
        modelAndView.setViewName("job");
        return modelAndView;
    }
    @RequestMapping(value = "/admin/job/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("jobs") Job job, RedirectAttributes redirect) {
        if (jobService.saveJob(job) == null) {
            return new ModelAndView("redirect:/error/400");
        }
        jobService.saveJob(job);
        redirect.addFlashAttribute("notification","bạn đã lưu job thành công !");
        return new ModelAndView("redirect:/listjob");
    }
    @GetMapping(value="/admin/deleteJob")
    public String deleteJob(@RequestParam(value = "jobId",required = true) int jobId){
        if(jobService.deleteJob(jobId)){
            successMsgTable = "delete success";
        }else{
            errorMsg = "delete falure";
        }
        return "redirect:/admin/listjob";
    }
    @PostMapping(value="/applyjob/deleteApplyJob")
    public String deleteApplyJob(@RequestParam(value = "applyJobId",required = true) int applyJobId){
        if(applyJobService.deleteApplyJob(applyJobId)){
            successMsgTable = "delete success";
        }else{
            errorMsg = "delete falure";
        }
        return "redirect:/applyJobForm";
    }
}
