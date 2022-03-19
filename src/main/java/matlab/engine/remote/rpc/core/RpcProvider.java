package matlab.engine.remote.rpc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用来创建RPC服务
 *
 * @author shirukai
 */
public class RpcProvider {
    private static final Logger LOG = LoggerFactory.getLogger(RpcProvider.class);

    public static <T> void start(int port, T ref) {
        try {
            LOG.info("The RPC Server is starting, address:{}, bind:{}", InetAddress.getLocalHost().getHostAddress(), port);
            ServerSocket listener = new ServerSocket(port);
            while (true) {
                Socket socket = listener.accept();
                // 接收数据并进行反序列化
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                // 获取请求对象
                Object object = objectInputStream.readObject();

                if (object instanceof RPCRequest) {
                    RPCRequest request = (RPCRequest) object;
                    LOG.info("Received request:{}", request);
                    // 处理请求
                    RPCResponse response = handleRequest(ref, request);
                    // 将结果返回给客户端
                    LOG.info("Send response to client.{}", response);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(response);
                }
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static <T> RPCResponse handleRequest(T ref, RPCRequest request) {
        RPCResponse response = new RPCResponse();
        try {
            LOG.info("The server is handling request.");
            Method method = ref.getClass().getMethod(request.getMethodName(), request.getParameterTypes());
            Object data = method.invoke(ref, request.getParameters());
            response.setData(data);
        } catch (Exception e) {
            response.setStatus(RPCResponse.FAILED).setMessage(e.getMessage());
        }
        return response;
    }
}