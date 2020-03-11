package cn.com.hatechframework.utils.statics;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author YeMeng
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.statics
 * @className FileType
 * @description 文件类型
 * @create 2020/3/3 15:49
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/3/3 15:49             1.0                         文件类型
 */
public class FileType {

    /**
     * excel xls文件类型
     */
    public static final String EXCEL_XLS = "xls";

    /**
     * excel xlsx 文件类型
     */
    public static final String EXCEL_XLSX = "xlsx";

    /**
     * excel 文件类型
     */
    public static final String[] EXCEL = new String[]{ EXCEL_XLS, EXCEL_XLSX};

    private FileType() {}
}
