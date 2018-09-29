package com.mall.seckill.controller;

import com.mall.seckill.domain.SeckillUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/toList")
    public String list(Model model, SeckillUser seckillUser) {
        model.addAttribute("seckillUser", seckillUser);
        return "goodsList";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
