package logic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

public class Profile implements Serializable {
	
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1623924841221148301L;
	private String				nickname;
	private String				description;
	private String				status;
	private Image				profilePicture;
	private Date				lastUpdated;
	private ImageIcon			imageicon;
	private byte[]				image;
	
	public Profile(String nickname, String description, String status, BufferedImage profilePicture, Date lastUpdated) {
		this.nickname = nickname;
		this.description = description;
		this.status = status;
		this.profilePicture = profilePicture;
		this.lastUpdated = lastUpdated;
	}
	
	public Profile() {

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Image getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public ImageIcon getImageicon() {
		return imageicon;
	}

	public void setImageicon(ImageIcon imageicon) {
		this.imageicon = imageicon;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}

}
