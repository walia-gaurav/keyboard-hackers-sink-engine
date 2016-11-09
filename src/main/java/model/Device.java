package model;

import java.util.Date;

import utility.Helper;

public class Device {

	private final String idDevice;
	private final Date installationDate;
	private final String token;

	private Date deleteDate;

	public Device(String deviceId, Date installationDate) {
		this.idDevice = deviceId;
		this.installationDate = installationDate;
		this.token = Helper.generateRandomTokenValue();
	}

	public String getIdDevice() {
		return idDevice;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
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
