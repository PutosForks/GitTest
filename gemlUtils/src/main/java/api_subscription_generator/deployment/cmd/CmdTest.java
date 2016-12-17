package api_subscription_generator.deployment.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CmdTest {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("user.dir");

        System.out.println(dir);
        ProcessBuilder builder = new ProcessBuilder(
                //  "cmd.exe", "/c", "svn log -r233:238 -v -q");
                "log.bat", "/c ");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}
