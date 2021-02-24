package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController //annotation
@RequestMapping("/api") //localhost 8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET,path ="getMethod") //localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")  //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){

        String password = "bbbb"; //non-recommended
        System.out.println("id : "+id);
        System.out.println("pwd : "+pwd);

        return id +pwd;
    }

    @GetMapping("/getMultiParameter")
    //localhost:8080/api/multiParameter?account=abcd&email=2zun@naver.com&page=10
    public SearchParam getMultiPatameter(
            SearchParam searchParam)
    {

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{account": "","email":"","page":0}
        //json 형태로 출력
        return searchParam;

    }
}
