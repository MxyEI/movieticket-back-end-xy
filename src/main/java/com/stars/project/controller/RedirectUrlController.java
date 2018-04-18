package com.stars.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author mxy
 * @create 2017-08-28-下午 17:00
 */
@Controller
public class RedirectUrlController {
    /**
     * 获取detail.html
     * @return
     */
    @GetMapping("/getDetailHtml/{code}")
    public String getDetailHtml(@PathVariable("code") String htmlCode, HttpServletRequest request){
        request.setAttribute("htmlCode",htmlCode);
        return "front/detail";
    }

    /**
     * 获取后台首页
     * @return
     */
    @GetMapping("/manager")
    public String   manager(){
        return "manager/index";
    }
    /**
     * 获取用户添加页面
     * @return
     */
    @GetMapping("/getUserAddPage")
    public String   userAdd(){
        return "manager/user/useradd";
    }
    /**
     * 获取用户查询页面
     * @return
     */
    @GetMapping("/getUserListPage")
    public String   userList(){
        return "manager/user/userlist";
    }
    /**
     * 获取用户查询页面
     * @return
     */
    @GetMapping("/getUserModifyPage")
    public String   userModifyPage(@RequestParam("id") Integer id, HttpServletRequest request){
        request.setAttribute("id",id);
        return "manager/user/usermodify";
    }
    /**
     * 获取模板修改页面
     * @return
     */
    @GetMapping("/getHtmlModifyPage")
    public String   htmlModifyPage(){
        return "manager/model/pagemodify";
    }
    /**
     * 获取模板添加页面
     * @return
     */
    @GetMapping("/getHtmlAddPage")
    public String   htmlAddPage(){
        return "manager/model/pageadd";
    }
    /**
     * 获取模板列表页面
     * @return
     */
    @GetMapping("/getHtmlListPage")
    public String   htmlListPage(){
        return "manager/model/pagelist";
    }
    /**
     * 获取登录页面
     * @return
     */
    @GetMapping("/getLoginPage")
    public String   getLoginPage(){
        return "manager/login";
    }
    /**
     * 获取页面详情
     * @return
     */
    @GetMapping("/pagedetail")
    public String   getPageDetail(@RequestParam("pageId")String pageId, HttpServletRequest request){
        request.setAttribute("pageId",pageId);
        return "manager/model/pageDetails";
    }
    /**
     * 保存页面菜单状态
     * @return
     */
    @PostMapping("/saveMenuState")
    @ResponseBody
    public void  saveMenuState(@RequestParam("menuState")String menuState, HttpSession session){
        session.setAttribute("menuState",menuState);
    }
}
