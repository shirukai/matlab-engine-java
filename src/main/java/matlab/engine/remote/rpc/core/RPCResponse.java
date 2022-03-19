package matlab.engine.remote.rpc.core;

import java.io.Serializable;

/**
 * PRC响应类型
 *
 * @author shirukai
 */
public class RPCResponse implements Serializable {
    public static String SUCCEED = "succeed";
    public static String FAILED = "failed";
    private static final long serialVersionUID = 6595683424889346485L;

    /**
     * 响应状态
     */
    private String status = "succeed";
    /**
     * 响应信息，如异常信息
     */
    private String message;

    /**
     * 响应数据，返回值
     */
    private Object data;

    public String getStatus() {
        return status;
    }

    public RPCResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RPCResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RPCResponse setData(Object data) {
        this.data = data;
        return this;
    }
}