package matlab.engine.remote.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义Matlab引擎的接口，其中继承Remote用来兼容RMI方式调用
 *
 * @author shirukai
 */
public interface MatlabEngineService extends Remote {
    /**
     * 执行Matlab函数
     *
     * <blockquote><pre>
     * double[] x = {2.0, 4.0, 6.0};
     * double[] res = service.feval("sqrt", (Object) x);
     * </pre></blockquote>
     *
     * @param funcName 函数名称
     * @param params   函数的参数列表
     * @param <T>      返回值类型
     * @return 执行结果
     * @throws RemoteException 兼容RMI
     */
    <T> T feval(String funcName, Object... params) throws RemoteException;

    /**
     * 执行Matlab脚本
     *
     * @param script 脚本
     * @throws RemoteException 兼容RMI
     */
    void eval(String script) throws RemoteException;

    /**
     * 获取变量
     * 执行eval()方法之后，可以调用此方法获取脚本中的变量
     *
     * @param varName 变量名称
     * @param <T>     返回值类型
     * @return 变量结果
     * @throws RemoteException 兼容RMI
     */
    <T> T getVariable(String varName) throws RemoteException;
}
