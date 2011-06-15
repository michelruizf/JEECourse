package registry;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class RegistryService {
	
	private static Map<Class<?>, InetSocketAddress> recorder = new HashMap<Class<?>, InetSocketAddress>();
	private static InetSocketAddress defaultAdress = new InetSocketAddress("localhost", 8080);

	public RegistryService() {}
	
	public static void registerService(Class<?> clazz,
			InetSocketAddress address) {
		recorder.put(clazz, address);		
	}

	public static InetSocketAddress getServiceAddress(Class<?> clazz) {
		if (recorder.containsKey(clazz)) return recorder.get(clazz);		
		return defaultAdress;
	}

}
