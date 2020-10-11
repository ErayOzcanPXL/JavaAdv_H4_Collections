package be.pxl.ja.streamingservice.model;

import java.util.Objects;

public abstract class Content {
	private String title;
	private Rating maturityRating;
	private String imageUrl;

	public Content(String title, Rating maturityRating) {
		this.title = title;
		this.maturityRating = maturityRating;
	}

	public Rating getMaturityRating() {
		return maturityRating;
	}

	public String getTitle() {
		return title;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String toString() {
		return title;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || this.getClass() != object.getClass()) return false;
		Content content = (Content) object;
		return Objects.equals(title, content.title) &&
				maturityRating == content.maturityRating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, maturityRating);
	}
}
