package matlab.engine.remote.rpc.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 用来创建PRC客户端
 *
 * @author shirukai
 */
public class RPCConsumer {

    @SuppressWarnings("unchecked")
    public static <T> T get(String host, Integer port, Class<?> interfaceClass) {
        // 实例化RPC代理处理器
        RPCInvocationHandler handler = new RPCInvocationHandler(host, port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, handler);
    }

    private static class RPCInvocationHandler implements InvocationHandler {
        private final String host;
        private final Integer port;

        public RPCInvocationHandler(String host, Integer port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 构建请求对象
            RPCRequest rpcRequest = new RPCRequest();
            rpcRequest.setMethodName(method.getName()).setParameterTypes(method.getParameterTypes()).setParameters(args);
            // 使用客户端发送请求
            RPCResponse response = this.send(rpcRequest);

            // 响应成功返回结果
            if (RPCResponse.SUCCEED.equals(response.getStatus())) {
                return response.getData();
            }
            throw new RuntimeException(response.getMessage());
        }

        public RPCResponse send(RPCRequest rpcRequest) throws Exception {

            Socket socket = new Socket(host, port);

            //请求序列化
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //将请求发给服务提供方
            objectOutputStream.writeObject(rpcRequest);

            // 将响应体反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            Object response = objectInputStream.readObject();
            if (response instanceof RPCResponse) {
                return (RPCResponse) response;
            }
            throw new RuntimeException("Return error");
        }
    }
}
