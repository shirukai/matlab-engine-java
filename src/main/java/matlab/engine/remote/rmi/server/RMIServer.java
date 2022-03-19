package matlab.engine.remote.rmi.server;

import matlab.engine.remote.common.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI服务端
 *
 * @author shirukai
 */
public class RMIServer<T extends Remote> extends Server<T> {
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);

    public RMIServer(Integer port, T instance) {
        super(port, instance);
    }

    /**
     * 启动监听服务
     *
     * @throws Exception e
     */
    @Override
    public void start() throws Exception {
        LOG.info("Starting the RMI-based Matlab engine...");
        LOG.info("Listening port: {}.", port);
        LOG.info("Service backend: {}.", instance.getClass());
        Registry registry = LocateRegistry.createRegistry(port);
        String name = instance.getClass().getInterfaces()[0].getSimpleName();
        registry.rebind(name, instance);
    }
}
