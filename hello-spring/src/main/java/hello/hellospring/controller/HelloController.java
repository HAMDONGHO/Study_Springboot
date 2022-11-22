package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //GetMapping은 url 매핑
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //hello는 templates에 hello.html에 던진다는 의미
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_template";
    }

    //http에서 body부에 직접 값을 넣어주겠다는 ResponseBody이다. HttpMessageConverter가 동작함. 문자 그대로 반환은(StringConverter)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //객체를 넘기면 Json으로 그대로 반환하라고 인식(JsonConverter)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
