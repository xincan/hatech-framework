package cn.com.hatechframework.server.controller;

import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.server.service.IClientDetailService;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.controller
 * @className ClientDetailController
 * @description ClientDetails接口类
 * @author YeMeng
 * @create 2019/12/18 16:37
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 16:37             1.0                        ClientDetail接口类
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.controller.ClientDetailController", tags = {"客户端详情ClientDetail接口"})
@RestController
@RequestMapping("/client")
public class ClientDetailController {

    /**
     * 客户端详情service
     */
    private IClientDetailService clientDetailService;

    public ClientDetailController(IClientDetailService clientDetailService) {
        this.clientDetailService = clientDetailService;
    }

    /**
     *  添加客户端
     * @param clientDetail 客户端详情
     * @author YeMeng
     * @date 2019/12/24 17:55
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="添加客户端",httpMethod="POST",notes="添加客户端详情")
    @PostMapping
    public ResponseObject addClientDetail(@ApiParam @Validated @RequestBody ClientDetailDTO clientDetail) {
        boolean res= clientDetailService.addClientDetail(clientDetail);
        return res? ResponseResult.success("添加客户端详情成功"): ResponseResult.success("添加客户端详情失败");
    }

}
