package utils;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config
{
String baseUrl();
String browser();

}
