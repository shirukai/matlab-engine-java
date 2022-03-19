package matlab.engine.remote.common;

import matlab.engine.remote.rmi.client.RMIClient;
import matlab.engine.remote.rpc.client.RPCClient;

/**
 * 用来创建指定类型的客户端
 *
 * @author shirukai
 */
public class ClientFactory {
    /**
     * 创建基于RMI方式的客户端
     *
     * @param host 远程服务端的地址
     * @param port 远程服务端的端口
     * @return RMI客户端
     */
    public static Client createRMIClient(String host, Integer port) {
        return new RMIClient(host, port);
    }

    /**
     * 创建基于RPC方式的服务端
     *
     * @param host 远程服务端的地址
     * @param port 远程服务端的端口
     * @return RPC客户端
     */
    public static Client createRPCClient(String host, Integer port) {
        return new RPCClient(host, port);
    }
}
