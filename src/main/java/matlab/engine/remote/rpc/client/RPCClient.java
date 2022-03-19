package matlab.engine.remote.rpc.client;

import matlab.engine.remote.common.Client;
import matlab.engine.remote.rpc.core.RPCConsumer;

/**
 * PRC客户端
 *
 * @author shirukai
 */
public class RPCClient extends Client {
    public RPCClient(String host, Integer port) {
        super(host, port);
    }

    @Override
    public <T> T get(Class<T> interfaceClass) throws Exception {
        return RPCConsumer.get(host, port, interfaceClass);
    }
}
