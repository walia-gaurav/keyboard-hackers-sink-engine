package model;

import java.time.LocalDateTime;

import utility.DeviceIdentifier;

public class Device {

	private final String idDevice;
	private final LocalDateTime installationDate;
	private final String token;

	private LocalDateTime deleteDate;

	public Device(String deviceId, LocalDateTime installationDate) {
		this.idDevice = deviceId;
		this.installationDate = installationDate;
		this.token = DeviceIdentifier.generateRandomTokenValue();
	}

	public String getIdDevice() {
		return idDevice;
	}

	public LocalDateTime getInstallationDate() {
		return installationDate;
	}

	public LocalDateTime getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(LocalDateTime deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getToken() {
		return token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDevice == null) ? 0 : idDevice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (idDevice == null) {
			if (other.idDevice != null)
				return false;
		} else if (!idDevice.equals(other.idDevice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [deviceId=");
		builder.append(idDevice);
		builder.append(", installationDate=");
		builder.append(installationDate);
		builder.append(", uninstallationDate=");
		builder.append(deleteDate);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}

}
