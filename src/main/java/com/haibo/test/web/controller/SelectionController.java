package com.haibo.test.web.controller;

import com.haibo.test.service.HttpRequestService;
import com.xdbigdata.framework.web.model.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XD
 */
@RestController
@RequestMapping("/api")
@Api(description = "中信刷猪接口")
public class SelectionController {
    @Autowired
    private HttpRequestService httpRequestService;

    @ApiOperation(value = "提交接口")
    @PostMapping("/commit")
    public JsonResponse commit(String cookie1, String cookie2,String cookie3) throws Exception {
        return JsonResponse.successMessage(httpRequestService.testMain(cookie1, cookie2));
    }
}
