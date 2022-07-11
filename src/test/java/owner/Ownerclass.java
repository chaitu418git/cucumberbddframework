package owner;

import org.aeonbits.owner.ConfigFactory;

import utils.FrameworkConfig;

public class Ownerclass {
	public static FrameworkConfig config;
	/*
	 * public RunnerWithOwner(FrameworkConfig config) { this.config=config; }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(config.baseUrl()); }
	 */
public static FrameworkConfig configLoader()
{
	 config = ConfigFactory.create(FrameworkConfig.class);
	 return config;
}

/*
 * public static String getUrl() { return config.baseUrl(); }
 */
}
