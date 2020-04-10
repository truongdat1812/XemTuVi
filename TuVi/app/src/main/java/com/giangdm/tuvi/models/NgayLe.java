package com.giangdm.tuvi.models;

public class NgayLe {
    private String mDate;
    private String content;
    private String type;

    public NgayLe(String mDate, String content, String type) {
        this.mDate = mDate;
        this.content = content;
        this.type = type;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
