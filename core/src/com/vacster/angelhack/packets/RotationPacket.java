package com.vacster.angelhack.packets;

public class RotationPacket {
	public float rotation, acc;
	
	public RotationPacket(float r, float a) {
		acc = a;
		rotation = r;
	}
	
	public RotationPacket() {
	}
}
