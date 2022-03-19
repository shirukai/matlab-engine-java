package matlab.engine.remote.common;

import matlab.engine.remote.rmi.server.RMIServer;
import matlab.engine.remote.rpc.server.RPCServer;

import java.rmi.Remote;

/**
 * 用来创建指定类型的服务端
 *
 * @author shirukai
 */
public class ServerFactory {
    /**
     * 创建RMI的服务端
     *
     * @param port     监听端口号
     * @param instance 代理实例
     * @param <T>      实例类型
     * @return RMI服务端
     */
    public static <T extends Remote> Server<T> createRMIServer(Integer port, T instance) {
        return new RMIServer<>(port, instance);
    }

    /**
     * 创建RPC的服务端
     *
     * @param port     监听端口号
     * @param instance 代理实例
     * @param <T>      实例类型
     * @return RPC服务端
     */
    public static <T> Server<T> createRPCServer(Integer port, T instance) {
        return new RPCServer<>(port, instance);
    }
}
