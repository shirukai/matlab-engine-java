package matlab.engine.remote.common;

/**
 * 定义客户端创建参数，及创建方法
 *
 * @author shirukai
 */
public abstract class Client {
    protected final String host;
    protected final Integer port;

    public Client(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    abstract public <T> T get(Class<T> interfaceClass) throws Exception;
}
