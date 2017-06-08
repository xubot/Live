package com.example.administrator.live.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */

public class List_Try {
    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {

        private String page_index;
        private int total;
        private String page_size;
        @SerializedName("try")
        private List<TryBean> tryX;

        @Override
        public String toString() {
            return "DataBean{" +
                    "page_index='" + page_index + '\'' +
                    ", total=" + total +
                    ", page_size='" + page_size + '\'' +
                    ", tryX=" + tryX +
                    '}';
        }

        public String getPage_index() {
            return page_index;
        }

        public void setPage_index(String page_index) {
            this.page_index = page_index;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public List<TryBean> getTryX() {
            return tryX;
        }

        public void setTryX(List<TryBean> tryX) {
            this.tryX = tryX;
        }

        public static class TryBean {


            private String title2;
            private String speaker;
            private String title;
            private int try_time;
            private String image;
            private int type;
            private int length;
            private String object_id;

            @Override
            public String toString() {
                return "TryBean{" +
                        "title2='" + title2 + '\'' +
                        ", speaker='" + speaker + '\'' +
                        ", title='" + title + '\'' +
                        ", try_time=" + try_time +
                        ", image='" + image + '\'' +
                        ", type=" + type +
                        ", length=" + length +
                        ", object_id='" + object_id + '\'' +
                        '}';
            }

            public String getTitle2() {
                return title2;
            }

            public void setTitle2(String title2) {
                this.title2 = title2;
            }

            public String getSpeaker() {
                return speaker;
            }

            public void setSpeaker(String speaker) {
                this.speaker = speaker;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTry_time() {
                return try_time;
            }

            public void setTry_time(int try_time) {
                this.try_time = try_time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }
        }
    }

    @Override
    public String toString() {
        return "Free_bean{" +
                "data=" + data +
                ", ret=" + ret +
                '}';
    }
}
