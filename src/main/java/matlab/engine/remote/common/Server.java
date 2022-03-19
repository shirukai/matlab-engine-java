package matlab.engine.remote.common;

/**
 * 定义服务端创建参数，及启动方法
 *
 * @author shirukai
 */
public abstract class Server<T> {
    protected final Integer port;
    protected final T instance;

    public Server(Integer port, T instance) {
        this.port = port;
        this.instance = instance;
    }

    public abstract void start() throws Exception;
}
