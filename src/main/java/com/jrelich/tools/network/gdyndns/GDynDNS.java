package com.jrelich.tools.network.gdyndns;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Utility Functions for getting public IP address and setting Google Dynamic DNS settings
 * @author Joshua Relich
 * @version 1.0
 * @since 09/08/2019
 */
public final class GDynDNS {
	final private static String pubIPv4Lookup = "http://checkip.amazonaws.com";

	private GDynDNS(){}

	/**
	 *
	 * @return returns public IPv4 Address from {@value #pubIPv4Lookup}
	 * @throws IOException Request failed.
	 */
	public static String getPubIPv4() throws IOException {
		String publicIP;
		publicIP = Request.Get(pubIPv4Lookup)
				.execute()
				.returnContent()
				.asString().trim();
		return publicIP;

	}

	/**
	 *
	 * @param username The generated username associated with the host that is to be updated.
	 * @param password The generated password associated with the host that is to be updated.
	 * @param hostname The generated username and password associated with the host that is to be updated.
	 * @param myip The IP address to which the host will be set. If not supplied, we’ll use the IP of the agent that sent the request.
	 * @param offline Sets the current host to offline status. If an update request is performed on an offline host, the host is removed from the offline state.
	 * @return returns http response in the form of a string.
	 * @throws IOException Request failed.
	 */
	public static String updateGoogleDNS(String username, String password, String hostname, String myip, boolean offline) throws IOException{
		StringBuilder URL = new StringBuilder("https://" + username + ":" + password + "@domains.google.com/nic/update?");
		URL.append("hostname=" + hostname);
		if (!myip.isEmpty()){
			URL.append("&myip=" + myip);
		}
		if (offline == true){
			URL.append("&offline=yes");
		}
		String response = Request.Post(URL.toString()).execute().returnContent().asString();


		return  response;
	}

	public static String updateGoogleDNS(String username, String password, String hostname, String myip) throws IOException{
		return updateGoogleDNS(username, password, hostname, myip, false);
	}

	public static String updateGoogleDNS(String username, String password, String hostname) throws IOException{
		return updateGoogleDNS(username, password, hostname, null, false);
	}

}
