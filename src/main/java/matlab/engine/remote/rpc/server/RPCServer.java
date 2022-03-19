package matlab.engine.remote.rpc.server;

import matlab.engine.remote.common.Server;
import matlab.engine.remote.rpc.core.RpcProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RPC服务端
 *
 * @author shirukai
 */
public class RPCServer<T> extends Server<T> {
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);

    public RPCServer(Integer port, T instance) {
        super(port, instance);
    }

    @Override
    public void start() throws Exception {
        LOG.info("Starting the RPC-based Matlab engine...");
        LOG.info("Listening port: {}.", port);
        LOG.info("Service backend: {}.", instance.getClass());
        RpcProvider.start(port, instance);
    }
}
