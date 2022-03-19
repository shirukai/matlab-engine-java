package matlab.engine.remote.service;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import matlab.engine.remote.api.MatlabEngineService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * Matlab引擎服务接口的具体实现
 * 参考：{@link MatlabEngine}
 *
 * @author shirukai
 */
public class MatlabEngineServiceImpl extends UnicastRemoteObject implements MatlabEngineService, Serializable {
    private final MatlabEngine engine;

    public MatlabEngineServiceImpl() throws RemoteException, EngineException, InterruptedException {
        super();
        // 启动Matlab服务
        this.engine = MatlabEngine.startMatlab();
    }

    @Override
    public <T> T feval(String funcName, Object... params) throws RemoteException {
        try {
            return engine.feval(funcName, params);
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }


    @Override
    public void eval(String script) throws RemoteException {
        try {
            engine.eval(script);
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public <T> T getVariable(String varName) throws RemoteException {
        try {
            return engine.getVariable(varName);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
