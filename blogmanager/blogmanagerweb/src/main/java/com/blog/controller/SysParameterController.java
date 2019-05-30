package com.blog.controller;

import com.blog.common.pojo.Result;
import com.blog.pojo.TbSysParameter;
import com.blog.service.SysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys")
public class SysParameterController {

    @Autowired
    SysParameterService sysParameterService;

    @RequestMapping("getSysParameter.do")
    @ResponseBody
    public Result getSysParameter() {
        return sysParameterService.getSysParameter();
    }

    @RequestMapping("editSysParameter.do")
    @ResponseBody
    public Result editSysParameter(@RequestBody TbSysParameter sysParameter) {
        return sysParameterService.editSysParameter(sysParameter);
    }

}
