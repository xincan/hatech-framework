package cn.com.hatechframework.data.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.data.page
 * @className PaginationQuery
 * @description 分页查询公用处理类
 * @author JiangXincan
 * @create 2019/12/19 13:15
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/19 13:15             1.0                         分页查询公用处理类
 */
@ApiModel(value = "cn.com.hatechframework.data.page.PaginationQuery", description = "操作日志实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationQuery{

    @ApiModelProperty(value="当前页数,为空时，默认从第1页开始", dataType = "Integer", example = "1")
    @DecimalMin(message = "当前页数错误,应当大于等于于{value}一页", value = "1")
    private Integer page = 1;

    @ApiModelProperty(value="每页条数，为空时，默认每页提供10条数据", dataType = "Integer", example = "10")
    @NotNull(message = "每页条数不能为空")
    @DecimalMin(message = "每页条数错误,应当大于等于于{value}条", value = "1")
    private Integer limit = 10;

    @ApiModelProperty(name="sortName",value="排序字段名称", dataType = "String")
    private String sortName;

    @ApiModelProperty(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", dataType = "OrderType", example = "DESC")
    private OrderType sortOrder;

    @ApiModelProperty(value="开始时间日期格式，例：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty(value="开始时间日期格式，例：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public PaginationQuery(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public PaginationQuery(String sortName, OrderType sortOrder) {
        this.sortName = sortName;
        this.sortOrder = sortOrder;
    }

}
