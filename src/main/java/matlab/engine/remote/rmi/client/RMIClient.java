package matlab.engine.remote.rmi.client;

import matlab.engine.remote.common.Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端
 *
 * @author shirukai
 */
public class RMIClient extends Client {
    public RMIClient(String host, Integer port) {
        super(host, port);
    }

    /**
     * 获取客户端
     *
     * @param interfaceClass 代理接口类
     * @param <T>            代理接口类型
     * @return 代理实例
     * @throws Exception e
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> interfaceClass) throws Exception {
        Registry registry = LocateRegistry.getRegistry(this.host, this.port);
        return (T) registry.lookup(interfaceClass.getSimpleName());
    }
}
