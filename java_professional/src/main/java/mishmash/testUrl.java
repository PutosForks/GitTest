package mishmash;

import java.net.*;

/**
 * Created by 502413934 on 10.11.2015.
 */
public class testUrl {
	public static void main(String[] args) {


		URI target;
		try {
			target = new URI("https://gemoney.my.salesforce.com");
			System.out.println(target.getHost());
			target = new URI("https://frontend/ufo/ufo/SME");
			System.out.println(target.getHost());

		} catch (URISyntaxException e) {
			System.out.println("Malformed BE URL: ");
		}

		try {
			InetAddress addr = InetAddress.getByName(
					InetAddress.getByName("gemoney.my.salesforce.com").getHostAddress());
			System.out.println(addr.toString());
		}catch(UnknownHostException e){
				System.out.println(e);
			}

		try {
			target = new URI("http://google.com");
			System.out.println(target.getHost());

		} catch (URISyntaxException e) {
			System.out.println("Malformed BE URL: ");
		}

		try {
			InetAddress addr = InetAddress.getByName(
					InetAddress.getByName("google.com").getHostAddress());
		}catch(UnknownHostException e){
			System.out.println(e);
		}




		}
	}
