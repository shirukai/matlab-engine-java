package matlab.engine.remote.rpc.core;

import java.io.Serializable;

/**
 * RPC通信的请求类型
 *
 * @author shirukai
 */
public class RPCRequest implements Serializable {
    private static final long serialVersionUID = 4932007273709224551L;
    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数列表
     */
    private Object[] parameters;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    public String getMethodName() {
        return methodName;
    }

    public RPCRequest setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public RPCRequest setParameters(Object[] parameters) {
        this.parameters = parameters;
        return this;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public RPCRequest setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
        return this;
    }
}