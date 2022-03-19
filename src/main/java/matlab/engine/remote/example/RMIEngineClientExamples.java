package matlab.engine.remote.example;

import matlab.engine.remote.api.MatlabEngineService;
import matlab.engine.remote.common.Client;
import matlab.engine.remote.common.ClientFactory;

import java.util.Arrays;

/**
 * @author shirukai
 */
public class RMIEngineClientExamples {
    public static void main(String[] args) throws Exception {
        Client client = ClientFactory.createRMIClient("192.168.66.212", 10991);
        MatlabEngineService service = client.get(MatlabEngineService.class);

        // 调用matlab函数
        double[] x = {2.0, 4.0, 6.0};
        double[] res = service.feval("sqrt", (Object) x);
        for (double e : res) {
            System.out.println(e);
        }

        // 调用matlab脚本
        String scripts = "y=0:1024-1;s=sin(2.0*pi*y*100.0/1000.0);fx=abs(fft(s));";
        service.eval(scripts);

        // 获取变量
        double[] fx = service.getVariable("fx");
        System.out.println(Arrays.toString(fx));
    }
}
