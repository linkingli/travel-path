package com.bicap.cloud.travelPath.entity;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class TravelPathData {
    private String publishDate;
    private String source;
    private String sourceName;

    @Override
    public String toString() {
        return "TravelPathData{" +
                "publishDate='" + publishDate + '\'' +
                ", source='" + source + '\'' +
                ", sourceName='" + sourceName + '\'' +
                '}';
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
