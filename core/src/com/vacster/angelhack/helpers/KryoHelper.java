package com.vacster.angelhack.helpers;

import com.esotericsoftware.kryo.Kryo;
import com.vacster.angelhack.packets.RotationPacket;

public class KryoHelper {

	public static void registerClasses(Kryo kryo){
		kryo.register(RotationPacket.class);
	}
	
}
