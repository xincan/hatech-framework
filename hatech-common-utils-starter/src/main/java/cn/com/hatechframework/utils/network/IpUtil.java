package cn.com.hatechframework.utils.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: ResultCode
 * Author:   JiangXincan
 * Date:     2018-12-19 16:30:00
 * @description
 */
/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.network
 * @className IpUtil
 * @description IP处理工具类
 * @author YeMeng
 * @create 2019/12/26 15:25
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/26 15:25             1.0                        IP处理工具类
 */
public class IpUtil {

	private IpUtil(){}

	/**
	 * 获取服务器地址
	 * @return
	 * @throws UnknownHostException
	 */
	public static InetAddress getLocalHostLanAddress() throws UnknownHostException {
		try {
			InetAddress candidateAddress = null;
			// 遍历所有的网络接口
			for (Enumeration<NetworkInterface> iFaces = NetworkInterface.getNetworkInterfaces(); iFaces.hasMoreElements();) {
				NetworkInterface iFace = iFaces.nextElement();
				// 在所有的接口下再遍历IP
				for (Enumeration<InetAddress> inetAddrs = iFace.getInetAddresses(); inetAddrs.hasMoreElements();) {
					InetAddress inetAddr = inetAddrs.nextElement();
					// 排除loopback类型地址
					if (!inetAddr.isLoopbackAddress()) {
						if (inetAddr.isSiteLocalAddress()) {
							// site-local地址
							return inetAddr;
						} else if (candidateAddress == null) {
							// site-local类型的地址未被发现，先记录候选地址
							candidateAddress = inetAddr;
						}
					}
				}
			}
			if (candidateAddress != null) {
				return candidateAddress;
			}
			// 如果没有发现 non-loopback地址.只能用JDK内置方案
			InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
			if (jdkSuppliedAddress == null) {
				throw new UnknownHostException("JDK InetAddress.getLocalHost() 方法未得到地址");
			}
			return jdkSuppliedAddress;
		} catch (Exception e) {
			UnknownHostException unknownHostException = new UnknownHostException(
					"检测 LAN 地址失败: " + e);
			unknownHostException.initCause(e);
			throw unknownHostException;
		}
	}
}
