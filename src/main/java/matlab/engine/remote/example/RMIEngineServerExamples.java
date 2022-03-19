package matlab.engine.remote.example;

import matlab.engine.remote.common.Server;
import matlab.engine.remote.common.ServerFactory;
import matlab.engine.remote.service.MatlabEngineServiceImpl;

/**
 * @author shirukai
 */
public class RMIEngineServerExamples {
    public static void main(String[] args) throws Exception {
        MatlabEngineServiceImpl service = new MatlabEngineServiceImpl();
        Server<MatlabEngineServiceImpl> server = ServerFactory.createRMIServer(10991, service);
        server.start();
    }
}
