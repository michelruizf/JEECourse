package registry;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class RegistryService {
	
	private final static Map<Class<?>, InetSocketAddress> recorder = new HashMap<Class<?>, InetSocketAddress>();
	
	public static void registerService(Class<?> clazz,
			InetSocketAddress address) {
		recorder.put(clazz, address);		
	}

	public static InetSocketAddress getServiceAddress(Class<?> clazz) throws UnknownHostException {
		if (recorder.containsKey(clazz)) return recorder.get(clazz);		
		return  new InetSocketAddress(InetAddress.getByName("localhost"), 1001);
	}

}
