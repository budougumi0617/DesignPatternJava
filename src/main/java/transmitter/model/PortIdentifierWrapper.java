package transmitter.model;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;

public class PortIdentifierWrapper {

	static  CommPort getCommPort(String comPort) throws NoSuchPortException, PortInUseException{
		return CommPortIdentifier.getPortIdentifier(comPort).open("Arduino Uno", 2000);
	}
}
