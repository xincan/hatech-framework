package cn.com.hatechframework.utils.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.file
 * @className FileUtils
 * @description 文件处理工具类
 * @author YeMeng
 * @create 2019/12/26 15:25
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/26 15:25             1.0                        文件处理工具类
 */
public class FileUtils {

    private FileUtils(){}

    /**
     * @description 获取指定文件夹中的所有文件
     * @param path  文件夹路径
     * @author YeMeng
     * @date 2020/1/8 17:59
     * @return java.util.Map<java.lang.String,java.io.File>
     */
    public static Map<String, File> getFileByDirectory(String path) {
        Map<String, File> res = new HashMap<>(8);
        if (path == null || "".equals(path)) {
            return res;
        }
        File file = new File(path);
        return getFileByDirectory(file);
    }

    /**
     * @description 获取指定文件夹中的所有文件
     * @param directory  文件夹
     * @author YeMeng
     * @date 2020/1/8 17:59
     * @return java.util.Map<java.lang.String,java.io.File>
     */
    public static Map<String, File> getFileByDirectory(File directory) {
        Map<String, File> res = new HashMap<>(8);
        if ( !directory.exists() || !directory.isDirectory()) {
            return res;
        }
        Arrays.stream(Objects.requireNonNull(directory.listFiles())).forEach(t->{
            if (t.isFile()) {
                res.put(t.getName(), t);
            }
        });
        return res;
    }

    /**
     * @description 读取文件内容
     * @param file  文件路径
     * @author YeMeng
     * @date 2020/1/8 18:00
     * @return java.lang.String
     */
    public static String readFile(File file) throws IOException {
        StringBuilder res = new StringBuilder();
        if (file==null || !file.exists() || !file.isFile()) {
            return res.toString();
        }
        try (InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(read);){
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                res.append("\n").append(lineTxt);
            }
        }
        return res.toString();
    }

}
