package equus.carbine.exception;

@SuppressWarnings("serial")
public class ConfigurationException extends RuntimeException {

    public ConfigurationException(final String config, final String message, final Throwable cause) {

        super("config is [" + config + "]. " + message, cause);
    }

    public ConfigurationException(final String config, final Throwable cause) {

        super("config is [" + config + "]. ", cause);
    }

    public ConfigurationException(final String config, final String message) {

        super("config is [" + config + "]. " + message);
    }
}
