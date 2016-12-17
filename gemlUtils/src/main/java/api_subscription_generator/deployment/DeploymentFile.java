package api_subscription_generator.deployment;

import settings.Settings;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static settings.Settings.encoding;

/**
 * Created by 502413934 on 31.8.2016.
 */
public class DeploymentFile {

	public final static String  s = Settings.DEPLOYMENT_CORE;

	public static void main(String[] args) {


		File incFilePath = new File(Settings.DEPLOYMENT_CORE);
		System.out.println(incFilePath.toString());

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\deployment\\include\\01.inc"), encoding));
			String currentLine = null;
			int RowNum = 0;

			while ((currentLine = br.readLine()) != null) {


					String str[] = currentLine.split("\\\\");

					File f = new File(incFilePath, currentLine);
				    System.out.println(f.getCanonicalPath());

					for (int i = 0; i < str.length; i++) {

						System.out.println(str[i]);
					}
			}

		} catch (IOException ex) {
			Logger.getLogger(DeploymentFile.class.getName()).log(Level.SEVERE, null, ex);
		}


	}


}
