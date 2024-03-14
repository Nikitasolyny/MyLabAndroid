package dataaccess;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import helpers.DateFormatter;

public class ArticleDTO implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("news_site")
    @Expose
    private String newsSite;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public ArticleDTO(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        url = in.readString();
        imageUrl = in.readString();
        newsSite = in.readString();
        summary = in.readString();
        publishedAt = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<ArticleDTO> CREATOR = new Creator<ArticleDTO>() {
        @Override
        public ArticleDTO createFromParcel(Parcel in) {
            return new ArticleDTO(in);
        }

        @Override
        public ArticleDTO[] newArray(int size) {
            return new ArticleDTO[size];
        }
    };

    public ArticleDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedAt() {
        return DateFormatter.formatDateString(publishedAt, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return DateFormatter.formatDateString(updatedAt, "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeString(imageUrl);
        parcel.writeString(newsSite);
        parcel.writeString(summary);
        parcel.writeString(publishedAt);
        parcel.writeString(updatedAt);
    }
}