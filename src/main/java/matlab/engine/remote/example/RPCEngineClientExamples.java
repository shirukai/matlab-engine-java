package matlab.engine.remote.example;

import matlab.engine.remote.api.MatlabEngineService;
import matlab.engine.remote.common.Client;
import matlab.engine.remote.common.ClientFactory;

/**
 * @author shirukai
 */
public class RPCEngineClientExamples {
    public static void main(String[] args)throws Exception {
        Client client = ClientFactory.createRPCClient("192.168.66.212", 10992);
        MatlabEngineService service = client.get(MatlabEngineService.class);

        double[] x = {2.0, 4.0, 6.0};
        double[] res = service.feval("sqrt", x);
        for (double e : res) {
            System.out.println(e);
        }
    }
}
