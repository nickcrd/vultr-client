# vultr-client
Java client for Vultr cloud hosting platform.

## How to use:
To create an instance of VultrAPI, you need to invoke build() on a VultrApiBuilder object. Make sure to set a base URL and a valid API key, otherwise, it won't work.

### Example Usage: 
Create a VPS:
```java
  VultrAPI vultrAPI = new VultrApiBuilder().setBaseUrl("https://api.vultr.com")
                    .setApiKey("YOUR_API_KEY_HERE").build();

  // This creates a new VPS with 1vCore and 1GB RAM in the Frankfurt Region and installs CentOS (id: 127 from API)
  vultrAPI.getServerManager().createServer(Region.FRANKFURT, ServerPlan.CC_1vCore_1GB, vultrApi.getOSManager().getOS(127));
```
