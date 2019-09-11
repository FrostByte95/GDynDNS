# GDynDNS
Small API to update Google Domains Dynamic DNS settings using Google Dynamic DNS API
#Dependencies
org.apache.httpcomponents:httpclient:4.5.9
org.apache.httpcomponents:fluent-hc:4.5.9

# Methods
## getPubIPv4

### public static String getPubIPv4()

### Returns:
> returns public IPv4 Address from http://checkip.amazonaws.com
### Throws:
> java.io.IOException - Request failed.

## updateGoogleDNS
### public static java.lang.String updateGoogleDNS(java.lang.String username, java.lang.String password, java.lang.String hostname, java.lang.String myip, boolean offline)
                                  
### Parameters:
> username - The generated username associated with the host that is to be updated.

> password - The generated password associated with the host that is to be updated.

> hostname - The generated username and password associated with the host that is to be updated.

> myip - The IP address to which the host will be set. If not supplied, we’ll use the IP of the agent that sent the request.

> offline - Sets the current host to offline status. If an update request is performed on an offline host, the host is removed from the offline state.

### Returns:
> returns http response in the form of a string.
### Throws:
> java.io.IOException - Request failed.
