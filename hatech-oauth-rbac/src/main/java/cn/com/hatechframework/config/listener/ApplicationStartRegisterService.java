package cn.com.hatechframework.config.listener;

import cn.com.hatechframework.config.feign.IFRegisterOauthService;
import cn.com.hatechframework.config.shardingjdbc.ShardingCreateDataSource;
import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.tenant.service.ITenantDataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.listener
 * @className ApplicationStartRegisterService
 * @description 系统启动完成监听
 * @author WangMingShuai
 * @create 2019/12/20 15:27
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:27             1.0                         系统启动完成监听
 */
@Component
@Slf4j
public class ApplicationStartRegisterService implements ApplicationRunner {

    /**
     * oauth2 资源端注册参数
     */
    @Value("${security.oauth2.client.clientId}")
    private String clientId;
    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;
    @Value("${security.oauth2.client.scope}")
    private String scope;
    @Value("${security.oauth2.client.grant-type}")
    private String grantType;


    private IFRegisterOauthService registerOauthService;
    private ITenantDataSourceService tenantDataSourceService;
    private ShardingCreateDataSource shardingCreateDataSource;

    public ApplicationStartRegisterService (IFRegisterOauthService registerOauthService,
             ITenantDataSourceService tenantDataSourceService, ShardingCreateDataSource shardingCreateDataSource) {
        this.registerOauthService = registerOauthService;
        this.tenantDataSourceService = tenantDataSourceService;
        this.shardingCreateDataSource = shardingCreateDataSource;
    }

    /**
     * 项目启动后将服务注册到 oauth-server
     * @param args
     * @author WangMingShuai
     * @date 2019/12/25 9:28
     * @return void
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("{}","项目启动完成，将服务注册到 oauth2 server");
        ClientDetailDTO clientDetailDTO = ClientDetailDTO.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .scope(scope)
                .authorizedGrantTypes(grantType).build();
        registerOauthService.addClient(clientDetailDTO);

        log.info("{}","项目启动完成，初始化系统中的数据源");
        List<TenantDataSourceVO> list = tenantDataSourceService.findAllUsedDataSource();
        if (!ObjectUtils.isEmpty(list)) {
            for (TenantDataSourceVO tenantDataSourceVO : list) {
                shardingCreateDataSource.checkAndDynamicCreateShardingDataSource(tenantDataSourceVO.getTenantName());
            }
        }
    }
}
